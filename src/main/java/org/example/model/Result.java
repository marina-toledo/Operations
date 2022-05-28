package org.example.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {
    @XmlAttribute
    Integer id;

    @XmlValue
    Integer result;
}
