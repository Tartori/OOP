
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

public class XMLDOMSolution {
	DocumentBuilder db = null;
	DocumentBuilderFactory dbf = null;
	Document doc = null;

	public static void main(String[] args) {
		if (args.length > 0) {
			XMLDOMSolution xd = new XMLDOMSolution(args[0]);
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
	public XMLDOMSolution(String docFile) {
		try {
			dbf = DocumentBuilderFactory.newInstance();

			// Optional: set various configuration options
			dbf.setIgnoringComments(true);
			dbf.setIgnoringElementContentWhitespace(false);

			db = dbf.newDocumentBuilder();
			
			doc = db.parse(new File(docFile));

			ArrayList<Section> sections = readSections(doc, 0);

			// Output the result
			for (Section s: sections) {
				for (int i=0; i<s.getLevel();i++) System.out.print(' ');
				System.out.println(s.getNumber()+" "+s.getName());
			}
			
		} catch (Exception e) {
			System.out.println("Doc File = " + docFile);
			System.out.println("Doc File Error: " + e.getMessage());
		}
	}

	public ArrayList<Section> readSections(Node node, int level) {
		int type = node.getNodeType();
		// System.out.println("Node Type: " + type);
		NodeList children = null;
		NamedNodeMap attrs = null;

		ArrayList<Section> list = new ArrayList<Section>();

		switch (type) {
		case Node.DOCUMENT_NODE:
			// Do nothing, but call method for all children
			children = node.getChildNodes();
			if (children != null) {
				int len = children.getLength();
				for (int i = 0; i < len; i++) {
					ArrayList<Section> childlist =readSections(children.item(i), 1);
					list.addAll(childlist);
				}
			}
			break;
		case Node.ELEMENT_NODE:
			// Check, if Section
			if (node.getNodeName().equals("Section")) {
				// create section instance and store in arraylist
				attrs = node.getAttributes();
				Section s = new Section(attrs.getNamedItem("name").getNodeValue(),
						attrs.getNamedItem("number").getNodeValue(), level);
				list.add(s);
				level++;
			}
			// continue with the children
			children = node.getChildNodes();
			if (children != null) {
				int len = children.getLength();
				for (int i = 0; i < len; i++) {
					ArrayList<Section> childlist = readSections(children.item(i), level);
					list.addAll(childlist);
				}
			}
			break;
		default:
			// Ignore
			break;
		}
		return list;
	}
}
