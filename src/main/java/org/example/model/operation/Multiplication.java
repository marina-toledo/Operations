package org.example.model.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.Result;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Multiplication extends Operation {
    List<Integer> factor;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(factor.stream().reduce(1, (a, b) -> a * b));
        return result;
    }
}
