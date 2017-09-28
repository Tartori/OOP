
package fax.Generated;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for priority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="priority">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NORMAL"/>
 *     &lt;enumeration value="URGENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "priority", namespace = "http://www.bfh.ch/fax/")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2017-03-17T09:11:41+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum Priority {

    NORMAL,
    URGENT;

    public String value() {
        return name();
    }

    public static Priority fromValue(String v) {
        return valueOf(v);
    }

}
