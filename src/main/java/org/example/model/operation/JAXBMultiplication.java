package org.example.model.operation;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.IValue;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@XmlRootElement(name = "multiplication")
public class JAXBMultiplication extends Multiplication {
    @Override
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @XmlElement
    public void setFactor(List<IValue> factor) {
        this.factor = factor;
    }
}
