package org.example.model;

import lombok.Data;

@Data
public class Subtraction implements Operation {
    private Integer id;
    private Integer minuend;
    private Integer subtrahend;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(minuend - subtrahend);
        return result;
    }
}
