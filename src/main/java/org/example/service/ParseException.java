package org.example.service;

import jakarta.xml.bind.JAXBException;

public class ParseException extends Exception{
    public ParseException(JAXBException e) {
        super(e);
    }
}
