
package com.products.store2.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.8
 * Tue Dec 06 13:07:21 IST 2016
 * Generated source version: 3.1.8
 */

@XmlRootElement(name = "getAllProducts", namespace = "http://store2.products.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllProducts", namespace = "http://store2.products.com/", propOrder = {"arg0", "arg1", "arg2"})

public class GetAllProducts {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;
    @XmlElement(name = "arg1")
    private int arg1;
    @XmlElement(name = "arg2")
    private int arg2;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

    public int getArg1() {
        return this.arg1;
    }

    public void setArg1(int newArg1)  {
        this.arg1 = newArg1;
    }

    public int getArg2() {
        return this.arg2;
    }

    public void setArg2(int newArg2)  {
        this.arg2 = newArg2;
    }

}

