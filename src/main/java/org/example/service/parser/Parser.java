package org.example.service.parser;

import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;

import java.io.File;

public interface Parser {

    ExpressionsInput parse(File file) throws ParseException;

    void writeTo(File dest, ExpressionsOutput content) throws ParseException;
}
