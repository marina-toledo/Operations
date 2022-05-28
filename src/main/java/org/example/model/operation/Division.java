package org.example.model.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.Result;

@EqualsAndHashCode(callSuper = true)
@Data
public class Division extends Operation {
    Integer dividend;
    Integer divisor;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(dividend / divisor);
        return result;
    }
}
