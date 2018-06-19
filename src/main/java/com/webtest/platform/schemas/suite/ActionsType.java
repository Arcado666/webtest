//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.22 at 09:12:44 PM CST 
//


package com.webtest.platform.schemas.suite;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				�������ϣ����
 * 			
 * 
 * <p>Java class for actionsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="action" type="{http://suite.surenpi.com}actionType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://suite.surenpi.com}commonActionAttr"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actionsType", propOrder = {
    "action"
})
public class ActionsType {

    @XmlElement(required = true)
    protected List<ActionType> action;
    @XmlAttribute(name = "beforeSleep")
    protected Integer beforeSleep;
    @XmlAttribute(name = "afterSleep")
    protected Integer afterSleep;
    @XmlAttribute(name = "disable")
    protected Boolean disable;
    @XmlAttribute(name = "repeat")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger repeat;
    @XmlAttribute(name = "rows")
    protected String rows;

    /**
     * Gets the value of the action property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the action property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActionType }
     * 
     * 
     */
    public List<ActionType> getAction() {
        if (action == null) {
            action = new ArrayList<ActionType>();
        }
        return this.action;
    }

    /**
     * Gets the value of the beforeSleep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getBeforeSleep() {
        if (beforeSleep == null) {
            return  0;
        } else {
            return beforeSleep;
        }
    }

    /**
     * Sets the value of the beforeSleep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBeforeSleep(Integer value) {
        this.beforeSleep = value;
    }

    /**
     * Gets the value of the afterSleep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getAfterSleep() {
        if (afterSleep == null) {
            return  0;
        } else {
            return afterSleep;
        }
    }

    /**
     * Sets the value of the afterSleep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAfterSleep(Integer value) {
        this.afterSleep = value;
    }

    /**
     * Gets the value of the disable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDisable() {
        if (disable == null) {
            return false;
        } else {
            return disable;
        }
    }

    /**
     * Sets the value of the disable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisable(Boolean value) {
        this.disable = value;
    }

    /**
     * Gets the value of the repeat property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRepeat() {
        if (repeat == null) {
            return new BigInteger("1");
        } else {
            return repeat;
        }
    }

    /**
     * Sets the value of the repeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRepeat(BigInteger value) {
        this.repeat = value;
    }

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRows() {
        if (rows == null) {
            return "1";
        } else {
            return rows;
        }
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRows(String value) {
        this.rows = value;
    }

}
