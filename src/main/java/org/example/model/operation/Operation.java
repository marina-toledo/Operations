package org.example.model.operation;

import lombok.Data;
import org.example.model.Result;

@Data
public abstract class Operation {
    Integer id;

    public abstract Result calculate();
}
