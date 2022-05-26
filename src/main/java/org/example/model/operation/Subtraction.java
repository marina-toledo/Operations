package org.example.model.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.Result;

@EqualsAndHashCode(callSuper = true)
@Data
public class Subtraction extends Operation {
    Integer minuend;
    Integer subtrahend;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(minuend - subtrahend);
        return result;
    }
}
