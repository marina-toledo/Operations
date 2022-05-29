package org.example.model.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Addition extends Operation {
    List<Integer> item;

    @Override
    public Integer getValue() {
        return item.stream().reduce(0, Integer::sum);
    }
}
