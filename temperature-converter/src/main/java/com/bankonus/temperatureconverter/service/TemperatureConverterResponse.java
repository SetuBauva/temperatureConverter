package com.bankonus.temperatureconverter.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="TemperatureConversion")
//@XmlType(propOrder = {
//	    "celsius",
//	    "fahrenheit"
//	})
@XmlAccessorType(XmlAccessType.NONE)
public class TemperatureConverterResponse {

    @XmlElement(name="Celsius")
    private float celsius;
    @XmlElement(name="Fahrenheit")
    private float fahrenheit;

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(float fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public String toString() {
        return "TempResponse [celsius=" + celsius + ", fahrenheit=" + fahrenheit + "]";
    }



}