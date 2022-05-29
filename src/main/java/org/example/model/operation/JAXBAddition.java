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
@XmlRootElement(name = "addition")
public class JAXBAddition extends Addition {
    @Override
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @XmlElement
    public void setItem(List<IValue> item) {
        this.item = item;
    }
}
