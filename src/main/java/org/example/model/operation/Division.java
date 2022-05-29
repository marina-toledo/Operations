package org.example.model.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.model.Result;

@EqualsAndHashCode(callSuper = true)
@Data
public class Division extends Operation {
    Integer dividend;
    Integer divisor;

    @Override
    public Integer getValue() {
        return dividend / divisor;
    }
}
