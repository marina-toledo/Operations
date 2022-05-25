package org.example.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
    @XmlAttribute
    private Integer id;

    @XmlElement
    private Integer result;
}
