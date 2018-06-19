//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.22 at 09:12:27 PM CST 
//


package com.webtest.platform.schemas.datasource;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.suren.autotest.platform.schemas.datasource package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.suren.autotest.platform.schemas.datasource
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataSources }
     * 
     */
    public DataSources createDataSources() {
        return new DataSources();
    }

    /**
     * Create an instance of {@link DataSources.DataSource }
     * 
     */
    public DataSources.DataSource createDataSourcesDataSource() {
        return new DataSources.DataSource();
    }

    /**
     * Create an instance of {@link DataSourceParamType }
     * 
     */
    public DataSourceParamType createDataSourceParamType() {
        return new DataSourceParamType();
    }

    /**
     * Create an instance of {@link DataSourcePageFieldType }
     * 
     */
    public DataSourcePageFieldType createDataSourcePageFieldType() {
        return new DataSourcePageFieldType();
    }

    /**
     * Create an instance of {@link DataSourcePageType }
     * 
     */
    public DataSourcePageType createDataSourcePageType() {
        return new DataSourcePageType();
    }

}
