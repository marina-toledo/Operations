package org.example.service;

import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;
import org.example.model.Operation;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

abstract class Parser {
    public void process(File input, File output) throws ParseException {

        ExpressionsInput expressionsInput = parseInput(input);
        ExpressionsOutput expressionsOutput = new ExpressionsOutput();

        expressionsOutput.setResult(
                Stream.concat(
                                expressionsInput.getAddition().stream().map(Operation::calculate),
                                expressionsInput.getSubtraction().stream().map(Operation::calculate))
                        .collect(Collectors.toList())
        );

        writeOutput(output, expressionsOutput);
    }

    abstract ExpressionsInput parseInput(File file) throws ParseException;

    abstract void writeOutput(File file, ExpressionsOutput expressionsOutput) throws ParseException;
}
