//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.22 at 09:12:44 PM CST 
//


package com.webtest.platform.schemas.suite;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lackLinesEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="lackLinesEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="error"/>
 *     &lt;enumeration value="nearby"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "lackLinesEnum")
@XmlEnum
public enum LackLinesEnum {


    /**
     * 
     * 						��ǰȱ��ָ�������ʱ���?
     * 					
     * 
     */
    @XmlEnumValue("error")
    ERROR("error"),

    /**
     * 
     * 						��ǰȱ��ָ�������ʱʹ����������顣
     * 					
     * 
     */
    @XmlEnumValue("nearby")
    NEARBY("nearby");
    private final String value;

    LackLinesEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LackLinesEnum fromValue(String v) {
        for (LackLinesEnum c: LackLinesEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

}
