package org.example.model.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.model.IValue;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subtraction extends Operation {
    IValue minuend;
    IValue subtrahend;

    @Override
    public Integer getValue() {
        return minuend.getValue() - subtrahend.getValue();
    }
}
