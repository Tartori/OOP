
package jaxb.fax.rey.generated;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.fax.rey.generated package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.fax.rey.generated
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

}
