
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for header complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="header">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="from" type="{http://www.bfh.ch/fax/}fromTo"/>
 *         &lt;element name="to" type="{http://www.bfh.ch/fax/}fromTo"/>
 *         &lt;element name="priority" type="{http://www.bfh.ch/fax/}priority"/>
 *         &lt;element name="pages" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "header", namespace = "http://www.bfh.ch/fax/", propOrder = {

})
public class Header {

    @XmlElement(required = true)
    protected FromTo from;
    @XmlElement(required = true)
    protected FromTo to;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Priority priority;
    protected int pages;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link FromTo }
     *     
     */
    public FromTo getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link FromTo }
     *     
     */
    public void setFrom(FromTo value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link FromTo }
     *     
     */
    public FromTo getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link FromTo }
     *     
     */
    public void setTo(FromTo value) {
        this.to = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link Priority }
     *     
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Priority }
     *     
     */
    public void setPriority(Priority value) {
        this.priority = value;
    }

    /**
     * Gets the value of the pages property.
     * 
     */
    public int getPages() {
        return pages;
    }

    /**
     * Sets the value of the pages property.
     * 
     */
    public void setPages(int value) {
        this.pages = value;
    }

}
