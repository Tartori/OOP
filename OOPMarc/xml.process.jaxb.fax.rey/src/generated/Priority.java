
package generated;

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
