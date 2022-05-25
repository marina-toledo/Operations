package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class XMLParser {

    public static void process(File file, File fileToBlock) throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(ExpressionsInput.class).createUnmarshaller();
        ExpressionsInput expressionsInput = (ExpressionsInput) unmarshaller.unmarshal(file);

        Marshaller marshaller = JAXBContext.newInstance(ExpressionsOutput.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        ExpressionsOutput expressionsOutput = new ExpressionsOutput();
        expressionsOutput.setResult(List.of(expressionsInput.getAddition().calculate(), expressionsInput.getSubtraction().calculate()));
        marshaller.marshal(expressionsOutput, fileToBlock);
    }
}
