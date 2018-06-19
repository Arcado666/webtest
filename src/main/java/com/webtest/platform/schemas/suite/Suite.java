//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.22 at 09:12:44 PM CST 
//


package com.webtest.platform.schemas.suite;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="page" type="{http://suite.surenpi.com}suitePageType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pageConfig" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="pagePackage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rows" type="{http://www.w3.org/2001/XMLSchema}string" default="1" />
 *       &lt;attribute name="lackLines" type="{http://suite.surenpi.com}lackLinesEnum" default="nearby" />
 *       &lt;attribute name="errorLines" type="{http://suite.surenpi.com}errorLinesEnum" default="stop" />
 *       &lt;attribute name="afterSleep" type="{http://www.w3.org/2001/XMLSchema}long" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "page"
})
@XmlRootElement(name = "suite")
public class Suite {

    @XmlElement(required = true)
    protected List<SuitePageType> page;
    @XmlAttribute(name = "pageConfig")
    protected String pageConfig;
    @XmlAttribute(name = "pagePackage")
    protected String pagePackage;
    @XmlAttribute(name = "rows")
    protected String rows;
    @XmlAttribute(name = "lackLines")
    protected LackLinesEnum lackLines;
    @XmlAttribute(name = "errorLines")
    protected ErrorLinesEnum errorLines;
    @XmlAttribute(name = "afterSleep")
    protected Long afterSleep;

    /**
     * Gets the value of the page property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the page property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SuitePageType }
     * 
     * 
     */
    public List<SuitePageType> getPage() {
        if (page == null) {
            page = new ArrayList<SuitePageType>();
        }
        return this.page;
    }

    /**
     * Gets the value of the pageConfig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageConfig() {
        return pageConfig;
    }

    /**
     * Sets the value of the pageConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageConfig(String value) {
        this.pageConfig = value;
    }

    /**
     * Gets the value of the pagePackage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagePackage() {
        return pagePackage;
    }

    /**
     * Sets the value of the pagePackage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagePackage(String value) {
        this.pagePackage = value;
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

    /**
     * Gets the value of the lackLines property.
     * 
     * @return
     *     possible object is
     *     {@link LackLinesEnum }
     *     
     */
    public LackLinesEnum getLackLines() {
        if (lackLines == null) {
            return LackLinesEnum.NEARBY;
        } else {
            return lackLines;
        }
    }

    /**
     * Sets the value of the lackLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link LackLinesEnum }
     *     
     */
    public void setLackLines(LackLinesEnum value) {
        this.lackLines = value;
    }

    /**
     * Gets the value of the errorLines property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorLinesEnum }
     *     
     */
    public ErrorLinesEnum getErrorLines() {
        if (errorLines == null) {
            return ErrorLinesEnum.STOP;
        } else {
            return errorLines;
        }
    }

    /**
     * Sets the value of the errorLines property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorLinesEnum }
     *     
     */
    public void setErrorLines(ErrorLinesEnum value) {
        this.errorLines = value;
    }

    /**
     * Gets the value of the afterSleep property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public long getAfterSleep() {
        if (afterSleep == null) {
            return  0L;
        } else {
            return afterSleep;
        }
    }

    /**
     * Sets the value of the afterSleep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAfterSleep(Long value) {
        this.afterSleep = value;
    }

}
