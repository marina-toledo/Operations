package org.example.model.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.model.IValue;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Multiplication extends Operation {
    List<IValue> factor;

    @Override
    public Integer getValue() {
        return factor.stream().map(IValue::getValue).reduce(1, (a, b) -> a * b);
    }
}
