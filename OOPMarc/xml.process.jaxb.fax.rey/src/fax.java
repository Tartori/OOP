
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import generated.*;

public class fax {

    private final static String PACKAGE = "generated";
    private final static String XML_FILE = "fax.xml";

    public static void main(String[] args){

        // First we need a factory object to get basic access!
        ObjectFactory objectFactory = new ObjectFactory();

        FromTo from = objectFactory.createFromTo();
        from.setName("MyCompany");
        from.setFaxno("012 345 67 89");
        FromTo to = objectFactory.createFromTo();
        to.setName("YourCompany");
        to.setFaxno("098 765 43 21");

        Header header = objectFactory.createHeader();
        header.setFrom(from);
        header.setTo(to);
        header.setPriority(Priority.URGENT);
        header.setPages(1);

        String body = "This is the message in the body.";

        Fax fax = objectFactory.createFax();
        fax.setHeader(header);
        fax.setBody(body);


        // Now we want to marshal the content of persons to an XML file
        try {
            // We need a JAXBElement of our type (this represents our datas to
            // be written)

            // We need a JAXBContex which knows our package (generated code)
            JAXBContext context = JAXBContext.newInstance(PACKAGE);

            // The output XML file
            File file = new File(XML_FILE);

            // Use the context to receive a marshaller object
            Marshaller m = context.createMarshaller();

            // set property if you want a pretty printed XML file
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(fax, file);
            m.marshal(fax, System.out);

            // Create the file
            // Print it on console too
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
