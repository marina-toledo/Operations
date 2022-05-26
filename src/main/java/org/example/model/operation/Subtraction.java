package org.example.model.operation;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import org.example.model.Result;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Subtraction implements Operation {
    @XmlAttribute
    private Integer id;
    @XmlElement
    private Integer minuend;
    @XmlElement
    private Integer subtrahend;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(minuend - subtrahend);
        return result;
    }
}
