package org.example.model;

import org.example.model.operation.Addition;
import org.example.model.operation.Operation;
import org.example.model.operation.Subtraction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExpressionsInput {
    List<Addition> addition;//todo

    List<Subtraction> subtraction;//todo

    public List<Operation> getOperations() {
        return Stream.concat(addition.stream(), subtraction.stream()).collect(Collectors.toList());
    }
}
