package org.example.model.operation;

import lombok.Data;
import lombok.NonNull;
import org.example.model.IValue;

@Data
public class Value implements IValue {
    @NonNull
    Integer value;

    @Override
    public Integer getValue() {
        return value;
    }
}
