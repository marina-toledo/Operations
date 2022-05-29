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
    public Integer getValue() {
        return minuend - subtrahend;
    }
}
