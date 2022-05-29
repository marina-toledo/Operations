package org.example.model.operation;

import lombok.Data;
import org.example.model.Value;

@Data
public abstract class Operation implements Value {
    Integer id;
}
