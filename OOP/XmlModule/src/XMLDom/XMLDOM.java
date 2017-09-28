package XMLDom;

import java.io.*;
import java.util.ArrayList;

import org.w3c.dom.*;

import javax.xml.parsers.*;

/**
 * XmlDoc program reading the sections.xml and outputting the section information
 * 
 * @author A. Laube, 2017
 * @version 1.0
 */

public class XMLDOM {
	DocumentBuilder db = null;
	DocumentBuilderFactory dbf = null;
	Document doc = null;

	public static void main(String[] args) {
		if (args.length > 0) {
			XMLDOM xd = new XMLDOM(args[0]);
		} else {
			System.out.println("No document file supplied.");
			System.exit(1);
		}
	}

	/** Read the document and create corresponding DOM nodes. */
	/**
	 * @param docFile
	 *          the xml file
	 */
	public XMLDOM(String docFile) {
		System.out.println("Document = " + docFile);
		try {
			dbf = DocumentBuilderFactory.newInstance();

			// Optional: set various configuration options
			dbf.setIgnoringComments(true);
			dbf.setIgnoringElementContentWhitespace(false);

			db = dbf.newDocumentBuilder();

			doc = db.parse(new File(docFile));

			// TODO Implement this method
			ArrayList<Section> sections = readSections(doc, 0);

			// TODO Output the result - Insert your code here
			for(Section sec: sections){
				System.out.println(sec);
			}
			
		} catch (Exception e) {
			System.out.println("Doc File = " + docFile);
			System.out.println("Doc File Error: " + e.getMessage());
		}
	}

	public ArrayList<Section> readSections(Node node, int level) {
        // TODO Insert your code here
		
		// get the node
		int type = node.getNodeType();
		NodeList children = null;
		NamedNodeMap attrs = null;
		ArrayList<Section> ret = new ArrayList<Section>();

		if(node.getNodeType() == Node.ELEMENT_NODE) {
			if(((Element)node).getTagName().equals("Section")) {
				attrs = node.getAttributes();

				Node name = attrs.getNamedItem("name");
				Node number = attrs.getNamedItem("number");
				if (name != null && number != null) {
					Section sec = new Section(name.getTextContent(), number.getTextContent(), level);
					ret.add(sec);
					level++;
				}
			}
		}

		children=node.getChildNodes();
		if(children!=null){
			for(int i = 0; i<children.getLength(); i++){
				ret.addAll(readSections(children.item(i), level));
			}
		}
		// Get the children of the node and call this method recursively
		
		// return the constructed ArrayList
		return ret;
	}
}
