package org.example.model.operation;

import lombok.Data;
import org.example.model.IValue;

@Data
public abstract class Operation implements IValue {
    Integer id;
}
