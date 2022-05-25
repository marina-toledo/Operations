package org.example;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Addition {
    @XmlAttribute
    private Integer id;

    @XmlElement
    private List<Integer> item;
}
