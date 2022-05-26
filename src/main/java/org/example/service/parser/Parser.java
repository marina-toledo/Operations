package org.example.service.parser;

import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;

import java.io.File;

interface Parser {

    ExpressionsInput parseInput(File file) throws ParseException;

    void writeOutput(File file, ExpressionsOutput expressionsOutput) throws ParseException;
}
