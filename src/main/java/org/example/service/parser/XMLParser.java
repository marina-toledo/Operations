package org.example.service.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;
import org.example.model.JAXBExpressionsInput;
import org.example.model.JAXBExpressionsOutput;

import java.io.File;

public class XMLParser implements Parser {

    @Override
    public ExpressionsInput parse(File file) throws ParseException {
        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(ExpressionsInput.class, JAXBExpressionsInput.class).createUnmarshaller();
            return (ExpressionsInput) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void writeTo(File file, ExpressionsOutput expressionsOutput) throws ParseException {
        try {
            Marshaller marshaller = JAXBContext.newInstance(ExpressionsOutput.class, JAXBExpressionsOutput.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new JAXBExpressionsOutput(expressionsOutput), file);
        } catch (JAXBException e) {
            throw new ParseException(e);
        }
    }
}
