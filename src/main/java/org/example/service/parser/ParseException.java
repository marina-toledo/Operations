package org.example.service.parser;

import jakarta.xml.bind.JAXBException;

public class ParseException extends Exception{
    public ParseException(JAXBException e) {
        super(e);
    }
}
