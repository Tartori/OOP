package fax;

import fax.Generated.*;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by julia on 17-Mar-17.
 */
public class faxMachine {
    private final static String PACKAGE = "Generated";
    private final static String XML_FILE = "faxCreated.xml";
    public static void main(String[] args) {
// First we need a factory object to get basic access!
        ObjectFactory objectFactory = new ObjectFactory();

        // To get a fax object do:
        Fax fax = objectFactory.createFax();


        // Now we set up a person object!
        fax.setBody("my body");

        Header header = objectFactory.createHeader();
        FromTo from = objectFactory.createFromTo();
        FromTo to = objectFactory.createFromTo();

        from.setFaxno("123456789");
        from.setName("Dude");

        to.setFaxno("987654321");
        to.setName("Dudette");

        header.setFrom(from);
        header.setTo(to);
        header.setPages(1234);
        header.setPriority(Priority.URGENT);

        fax.setHeader(header);


        // Now we want to marshal the content of persons to an XML file
        try {
            // We need a JAXBElement of our type (this represents our datas to
            // be written)
            JAXBElement<Fax> dataContent = objectFactory
                    .createFax(fax);
            // We need a JAXBContex which knows our package (generated code)
            JAXBContext context = JAXBContext.newInstance(PACKAGE);
            // The output XML file
            File file = new File(XML_FILE);
            // Use the context to receive a marshaller object
            Marshaller m = context.createMarshaller();
            // set property if you want a pretty printed XML file
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(dataContent, file); // Create the file
            m.marshal(dataContent, System.out); // Print it on console too
        } catch (JAXBException jbe) {
            jbe.printStackTrace();
        }
    }


}