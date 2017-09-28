

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Based on the XmlDoc program by Doug Tidwell, 17 February 2000.
 * 
 * @author lua1, 2016
 */
public class XMLDomProcessing {

	public static void processXMLDOM(String xmlFileName, String xsdFileName)
			throws ParserConfigurationException, SAXException, IOException {

		// create the DOM factory
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setIgnoringElementContentWhitespace(true);
		factory.setNamespaceAware(true);

		// Create the schema factory
		final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		factory.setValidating(true);

		// Attach the schema
		final Schema schema = sf.newSchema(new File(xsdFileName));
		factory.setSchema(schema);

		// Create the document builder and set the error handler
		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new DefaultHandler());

		// read the xml file
		Document doc = builder.parse(new File(xmlFileName));

		// process it
		System.out.println("---- original document ----");
		printNode(doc);
	
		// modify the document and print it again
		//modifyDocument(doc);
		//System.out.println();
		//System.out.println("---- modified document ----");
		//printNode(doc);
		
		// modify the document and print it again
		//modifyTitle(doc);
		//System.out.println();
		//System.out.println("---- modified title (task 2) ----");
		//printNode(doc);
		
		// modify the document and print it again
		modifyLines(doc);
		System.out.println();
		System.out.println("---- modified lines (task 3) ----");
		printNode(doc);
		
		// modify the document and print it again
		modifyComment(doc);
		System.out.println();
		System.out.println("---- modified comment (task 4) ----");
		printNode(doc);

	}

	/** Insert some nodes into the document */
	private static Document modifyDocument(Document doc) {
		if (doc != null) {
			// create an additional element
			Element placeOfBirth = doc.createElement("place-of-birth");
			placeOfBirth.setTextContent("Stratford-upon-Avon");

			// get the root element
			Element rootEl = doc.getDocumentElement();
			// navigate to the author element
			NodeList authors = rootEl.getElementsByTagName("author");
			Element author = (Element) authors.item(0);

			NodeList nationalities = author.getElementsByTagName("nationality");
			Element nationality = (Element) nationalities.item(0);
			// modify the nationality
			nationality.setTextContent("English");

			NodeList yearODs = author.getElementsByTagName("year-of-death");
			Element yearOfDeath = (Element) yearODs.item(0);
			// insert it there - Attention the xml is not valid anymore
			author.insertBefore(placeOfBirth, yearOfDeath);
			
			// NOTE: DOM does not re-validate the document
			// when you modify it programmatically !!
		}
		return doc;
	}
	
	/** Insert some nodes into the document */
	private static Document modifyTitle(Document doc) {
		if (doc != null) {
			
			// get the root element (sonnet)
			Element rootEl = doc.getDocumentElement();
			
			// navigate to the title element
			NodeList titles = rootEl.getElementsByTagName("title");
			Element title = (Element) titles.item(0);
			
			String currentTitle = title.getTextContent();
			title.setTextContent("***" + currentTitle + "***");
			/*
			Text text = (Text) title.getFirstChild();
			text = "***" + text + "***";
			title.setTextContent(text);
			*/
			
			
			// NOTE: DOM does not re-validate the document
			// when you modify it programmatically !!
		}
		return doc;
	}
	
	/** Insert lines (task 3) */
	private static Document modifyLines(Document doc) {
		if (doc != null) {
			
			// get the root element (sonnet)
			Element rootEl = doc.getDocumentElement();

			
			// navigate to the lines element
			NodeList linesTags = rootEl.getElementsByTagName("lines");
			Element linesTag = (Element) linesTags.item(0);
			NodeList lineTags = linesTag.getElementsByTagName("line");
			
			// not in for(...) because, will change with each addition!
			int lineCount = lineTags.getLength();
			
			/*
			iterate backwards because otherwise the ith element will always be a spacer.
			thus all spacers will be added at the beginning.
			do iterate for int i = lineCount, not int i = lineCount - 1.
			this works because the list will get longer with each added element and thus really has an element with index of lineCount.
			  */
			for(int i = lineCount ; i >= 0; i--){
				// create spacer element
				Element lineTagWithSpacer = doc.createElement("line");
				lineTagWithSpacer.setTextContent("------------");
				linesTag.insertBefore(lineTagWithSpacer, lineTags.item(i));
			}

			// NOTE: DOM does not re-validate the document
			// when you modify it programmatically !!
		}
		return doc;
	}
	
	/** Insert Comment (task 4) */
	private static Document modifyComment(Document doc){
		if(doc != null){
			// get the root element (sonnet)
			Element rootEl = doc.getDocumentElement();
			
			// navigate to the title element
			NodeList authors = rootEl.getElementsByTagName("author");
			Element author = (Element) authors.item(0);
			
			Comment comment = doc.createComment("A comment...");
			
			rootEl.insertBefore(comment, author);
		}
		return doc;
	}
	
	/** Print a specific node including - if present - its contents. */
	private static void printNode(Node node) {
		
		int type = node.getNodeType();
		// System.out.println("Node Type: " + type);
		NodeList children = null;
		NamedNodeMap attrs = null;

		switch (type) {
		case Node.DOCUMENT_NODE:
			System.out.print("Document Node: <?xml");

			System.out.print(" version=\"" + ((Document) node).getXmlVersion());
			String encoding = ((Document) node).getXmlEncoding();
			if (encoding != null)
				System.out.print(" encoding=" + encoding);
			System.out.println("\" ?>");

			children = node.getChildNodes();
			if (children != null) {
				int len = children.getLength();
				for (int i = 0; i < len; i++)
					printNode(children.item(i));
			}
			break;

		case Node.DOCUMENT_TYPE_NODE:
			String subset = ((DocumentType) node).getInternalSubset();
			System.out.println("<!DOCTYPE " + node.getNodeName() + " [" + subset + "]>");
			break;

		case Node.ELEMENT_NODE:
			System.out.print("<");
			System.out.print(node.getNodeName());
			attrs = node.getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				Node attr = attrs.item(i);
				System.out.print(" " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"");
			}
			System.out.print(">\n");

			children = node.getChildNodes();
			if (children != null) {
				int len = children.getLength();
				for (int i = 0; i < len; i++)
					printNode(children.item(i));
			}

			System.out.println("</" + node.getNodeName() + ">");
			break;

		case Node.ENTITY_REFERENCE_NODE:
			System.out.print("&");
			System.out.print(node.getNodeName());
			System.out.println(";");
			break;

		case Node.CDATA_SECTION_NODE:
			System.out.print("<![CDATA[");
			System.out.print(node.getNodeValue());
			System.out.println("]]>\n");
			break;

		case Node.TEXT_NODE:
			System.out.print(node.getNodeValue().trim());
			break;

		case Node.PROCESSING_INSTRUCTION_NODE:
			System.out.print("<?");
			System.out.print(node.getNodeName());
			System.out.print(" " + node.getNodeValue());
			System.out.println("?>\n");
			break;

		case Node.COMMENT_NODE:
			System.out.print("<!--");
			System.out.print(node.getNodeValue());
			System.out.println("-->");
			break;

		default:
			System.out.print("Unknown node");
			break;

		}
	}

	public static void main(String[] args) {
		if (args.length > 1) {
			try {
				processXMLDOM(args[0], args[1]);
			} catch (ParserConfigurationException e) {
				System.err.println("Document Bilder not correctly configured...");
				e.printStackTrace();
			} catch (SAXException e) {
				System.err.println("Problems to read the xsd file...");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Problems to read the xml file...");
				e.printStackTrace();
			}
		} else {
			System.out.println("Usage: "+XMLDomProcessing.class.getSimpleName()+" xml_file xsd_file");
			System.out.println("No xml or xsd file supplied.");
		}
	}

}
