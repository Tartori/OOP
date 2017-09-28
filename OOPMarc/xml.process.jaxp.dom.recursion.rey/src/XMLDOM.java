

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
			for(int i = 0; i < sections.size(); i++){
				printSection(sections.get(i));
			}
			
		} catch (Exception e) {
			System.out.println("Doc File = " + docFile);
			System.out.println("Doc File Error: " + e.getMessage());
		}
	}

	private ArrayList<Section> readSections(Node node, int level) {

		ArrayList<Section> list = new ArrayList<Section>();
		
		// Check if node has type Node.ELEMENT_NODE
		// If yes, store it
		if(node.getNodeType() == Node.ELEMENT_NODE){
			
			Element element = (Element) node;
			if(element.getTagName().equals("Section")){
				
				String name = element.getAttribute("name");
				String number = element.getAttribute("number");
				Section section = new Section(name, number, level);
				list.add(section);
				level++;
			}
		}
		
		// Get the children of the node and call this method recursively
		NodeList children = node.getChildNodes();
		int childrenCount = children.getLength();
		for(int i = 0; i < childrenCount; i++){
			ArrayList<Section> childList = readSections(children.item(i), level);
			list.addAll(childList);
		}

		// return the constructed ArrayList
		return list;
	}
	
	private void printSection(Section section){
		String indent = "";
		for(int i = 0; i < section.getLevel(); i++){
			indent += " ";
		}
		String output = indent + section.getNumber() + " " + section.getName();
		System.out.println(output);
	}
}
