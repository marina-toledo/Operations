package org.example.model.operation;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class JAXBAddition extends Addition {
    @Override
    @XmlAttribute
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    @XmlElement
    public void setItem(List<Integer> item) {
        this.item = item;
    }
}
