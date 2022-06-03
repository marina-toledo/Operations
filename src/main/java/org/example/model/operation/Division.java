package org.example.model.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.model.IValue;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class Division extends Operation {
    IValue dividend;
    IValue divisor;

    @Override
    public Integer getValue() {
        return dividend.getValue() / divisor.getValue();
    }
}
