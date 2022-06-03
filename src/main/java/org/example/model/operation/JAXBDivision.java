package org.example.model.operation;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.IValue;

@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "division")
public class JAXBDivision extends Division {
    @Override
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @XmlElement
    public void setDividend(IValue dividend) {
        this.dividend = dividend;
    }

    @Override
    @XmlElement
    public void setDivisor(IValue divisor) {
        this.divisor = divisor;
    }
}
