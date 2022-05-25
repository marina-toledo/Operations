package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Addition implements Operation {
    private Integer id;
    private List<Integer> item;

    @Override
    public Result calculate() {
        Result result = new Result();
        result.setId(id);
        result.setResult(item.stream().reduce(0, Integer::sum));
        return result;
    }
}
