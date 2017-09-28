

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
		
			
		} catch (Exception e) {
			System.out.println("Doc File = " + docFile);
			System.out.println("Doc File Error: " + e.getMessage());
		}
	}

	public ArrayList<Section> readSections(Node node, int level) {
        // TODO Insert your code here
		
		// get the node
		
		// Check if node has type Node.ELEMENT_NODE
		// If yes, store it
		
		// Get the children of the node and call this method recursively
		
		// return the constructed ArrayList
		return null;
	}
}
