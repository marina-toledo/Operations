package org.example.service;

import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;

import java.io.File;
import java.util.List;

abstract class Parser {
    public void process(File input, File output) throws ParseException {

        ExpressionsInput expressionsInput = parseInput(input);

        ExpressionsOutput expressionsOutput = new ExpressionsOutput();
        expressionsOutput.setResult(List.of(expressionsInput.getAddition().calculate(), expressionsInput.getSubtraction().calculate()));

        writeOutput(output,expressionsOutput);
    }

    abstract ExpressionsInput parseInput(File file) throws ParseException;

    abstract void writeOutput(File file, ExpressionsOutput expressionsOutput) throws ParseException;
}
