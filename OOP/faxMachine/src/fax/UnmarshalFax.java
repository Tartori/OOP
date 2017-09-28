package fax;

import fax.Generated.Fax;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by julia on 17-Mar-17.
 */
public class UnmarshalFax {
    private final static String PACKAGE = "Generated";
    private final static String XSD_FILE = "c:/temp/schema/fax.xsd";
    private final static String XML_FILE = "faxCreated.xml";

    public static void main(String[] l){
        // First of all: Validate the  XML file against it's schema
        if (!XMLValidation.validateXMLSchema(XSD_FILE, XML_FILE)) {
            System.out.println("THE XML file " +
                    XML_FILE+ " is not valid against " + XSD_FILE);
            System.exit(0);
        }
        else
            System.out.println("THE XML file " +
                    XML_FILE+ " is valid against " + XSD_FILE);

        try {
            // Get the context with out a specific class !!!
            JAXBContext context = JAXBContext.newInstance(PACKAGE);

            // Get an unmarshaller object from the context
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Define a source (=our XML file)
            Source source = new StreamSource(new java.io.FileInputStream(XML_FILE));

            // UnMarshall the XML content and get access to the root element
            JAXBElement<Fax> root =
                    unmarshaller.unmarshal(source,Fax.class);

            // Our root element can deliver a persons object (of type PersonsType)
            Fax fax = root.getValue();

            System.out.println(fax.getHeader().getFrom().getName());
            System.out.println(fax.getBody());
        }
        catch (JAXBException e) {e.printStackTrace();}
        catch (FileNotFoundException e) {e.printStackTrace();}
    }
}
