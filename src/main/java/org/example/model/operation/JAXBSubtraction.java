package org.example.model.operation;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "subtraction")
public class JAXBSubtraction extends Subtraction {
    @Override
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @XmlElement
    public void setMinuend(Integer minuend) {
        this.minuend = minuend;
    }

    @Override
    @XmlElement
    public void setSubtrahend(Integer subtrahend) {
        this.subtrahend = subtrahend;
    }
}
