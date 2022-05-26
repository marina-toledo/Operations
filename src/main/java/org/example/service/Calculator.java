package org.example.service;

import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;
import org.example.model.Operation;
import org.example.model.Result;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static ExpressionsOutput process(ExpressionsInput input) {
        ExpressionsOutput output = new ExpressionsOutput();
        List<Result> results = new ArrayList<>();
        for (Operation operation : input.getOperations()) {
            results.add(operation.calculate());
        }
        output.setResult(results);
        return output;
    }
}
