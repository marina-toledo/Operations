package org.example.service;

import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;
import org.example.model.Result;
import org.example.model.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static ExpressionsOutput process(ExpressionsInput input) {
        ExpressionsOutput output = new ExpressionsOutput();
        List<Result> results = new ArrayList<>();

        for (Operation operation : input.getOperations()) {
            Result result = new Result();
            result.setId(operation.getId());
            result.setResult(operation.getValue());
            results.add(result);
        }

        output.setResult(results);
        return output;
    }
}
