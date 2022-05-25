package org.example.model;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Addition implements Operation {
    @XmlAttribute
    private Integer id;

    @XmlElement
    private List<Integer> item;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(item.stream().reduce(0, Integer::sum));
        return result;
    }
}
