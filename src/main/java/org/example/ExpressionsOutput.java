package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "expressions")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExpressionsOutput {
    @XmlElement
    private List<Result> result;
}
