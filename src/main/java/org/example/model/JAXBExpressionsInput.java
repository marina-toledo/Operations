package org.example.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.example.model.operation.*;

import java.util.List;

@XmlRootElement(name = "expressions")
public class JAXBExpressionsInput extends ExpressionsInput {

    // replace with that? ->   @XmlElementRef(name= "addition", type = JAXBAddition.class)
    @XmlElements({
            @XmlElement(name = "addition", type = JAXBAddition.class),
            @XmlElement(name = "subtraction", type = JAXBSubtraction.class),
            @XmlElement(name = "multiplication", type = JAXBMultiplication.class),
            @XmlElement(name = "division", type = JAXBDivision.class)
    })
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public List<Operation> getOperations() {
        return operations;
    }
}
