package org.example;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class Addition {
    @XmlAttribute
    private Integer id;

    @XmlElement
    private List<Integer> item;
}
