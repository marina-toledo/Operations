package org.example.model.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.Result;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Addition extends Operation {
    List<Integer> item;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(item.stream().reduce(0, Integer::sum));
        return result;
    }
}
