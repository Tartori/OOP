
package fax.Generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fax package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {
    private final static QName _Persons_QNAME = new QName("http://www.bfh.ch/Fax/", "fax");


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fax
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Fax }
     * 
     */
    public Fax createFax() {
        return new Fax();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link FromTo }
     * 
     */
    public FromTo createFromTo() {
        return new FromTo();
    }

    @XmlElementDecl(namespace = "http://www.bfh.ch/Fax/", name = "fax")
    public JAXBElement<Fax> createFax(Fax value) {
        return new JAXBElement<Fax>(_Persons_QNAME, Fax.class, null, value);
    }
}
