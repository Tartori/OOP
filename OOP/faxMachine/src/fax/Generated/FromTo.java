
package fax.Generated;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fromTo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fromTo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute ref="{http://www.bfh.ch/fax/}faxno"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fromTo", namespace = "http://www.bfh.ch/fax/")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class FromTo {

    @XmlAttribute(name = "name")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String name;
    @XmlAttribute(name = "faxno", namespace = "http://www.bfh.ch/fax/")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String faxno;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the faxno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getFaxno() {
        return faxno;
    }

    /**
     * Sets the value of the faxno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setFaxno(String value) {
        this.faxno = value;
    }

}
