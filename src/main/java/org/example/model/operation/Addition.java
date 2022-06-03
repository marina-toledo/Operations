package org.example.model.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.model.IValue;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Addition extends Operation {
    List<IValue> item;

    @Override
    public Integer getValue() {
        return item.stream().map(IValue::getValue).reduce(0, Integer::sum);
    }
}
