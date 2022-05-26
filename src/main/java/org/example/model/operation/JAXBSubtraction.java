package org.example.model.operation;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
