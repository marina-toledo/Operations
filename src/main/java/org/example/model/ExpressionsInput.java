package org.example.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.example.model.operation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@XmlRootElement(name = "expressions")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExpressionsInput {
    @XmlElement
    private List<JAXBAddition> addition;//todo

    @XmlElement
    private List<JAXBSubtraction> subtraction;//todo

    public List<Operation> getOperations() {
        return Stream.concat(addition.stream(),subtraction.stream()).collect(Collectors.toList());
    }
}
