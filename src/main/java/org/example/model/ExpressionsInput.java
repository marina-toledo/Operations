package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.operation.Operation;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpressionsInput {
    List<Operation> operations;
}
