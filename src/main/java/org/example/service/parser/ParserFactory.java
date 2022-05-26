package org.example.service.parser;

public class ParserFactory {

    private final XMLParser XML_PARSER = new XMLParser();

    public enum FileFormat {
        XML
    }

    public Parser getParser(String fileName) throws ParseException {
        if (getFileExtension(fileName).equals(FileFormat.XML.name())) {
            return XML_PARSER;
        }
        throw new ParseException(new Exception("File Format not supported yet."));
    }

    private String getFileExtension(String fileName) {
        int indexOfExtension = fileName.lastIndexOf('.');
        return fileName.substring(indexOfExtension + 1).toUpperCase();
    }
}
