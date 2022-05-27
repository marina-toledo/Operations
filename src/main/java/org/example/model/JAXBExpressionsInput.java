package org.example.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.operation.Addition;
import org.example.model.operation.JAXBAddition;
import org.example.model.operation.JAXBSubtraction;
import org.example.model.operation.Subtraction;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "expressions")
public class JAXBExpressionsInput extends ExpressionsInput {

    // replace with that? ->   @XmlElementRef(name= "addition", type = JAXBAddition.class)
    @XmlElements({
            @XmlElement(name = "addition", type = JAXBAddition.class)
    })
    public void setAddition(List<Addition> addition) {
        this.addition = addition;
    }

    public List<Addition> getAddition() {
        return addition;
    }

    @XmlElements({
            @XmlElement(name = "subtraction", type = JAXBSubtraction.class)
    })
    public void setSubtraction(List<Subtraction> subtraction) {
        this.subtraction = subtraction;
    }

    public List<Subtraction> getSubtraction() {
        return subtraction;
    }
}
