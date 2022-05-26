package org.example;

import org.example.service.Calculator;
import org.example.service.parser.ParseException;
import org.example.service.parser.Parser;
import org.example.service.parser.ParserFactory;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class App {

    public static final String OUTPUT_SUFFIX = "_result";

    public static void main(String[] args) {
        String inputPath = args[0];
        String outputPath = args[1];

        File[] files = new File(inputPath).listFiles();

        if (files == null) {
            System.out.println("Input path is not a directory.");
            System.exit(0);
        }

        ParserFactory parserFactory = new ParserFactory();

        for (File fileInput : files) {
            if (fileInput.isFile() && !fileInput.getName().contains(OUTPUT_SUFFIX)) {
                try {
                    Parser parser = parserFactory.getParser(fileInput.getName());
                    File fileOutput = new File(getOutputFileName(outputPath, fileInput.getName()));

                    parser.writeTo(
                            fileOutput,
                            Calculator.process(parser.parse(fileInput))
                    );

                } catch (ParseException e) {
                    System.out.println("Error in file " + fileInput.getName() + ". " + e.getMessage());
                }
            }
        }
    }

    @NotNull
    static String getOutputFileName(String path, String inputFileName) {
        int indexOfExtension = inputFileName.lastIndexOf('.');
        return path + inputFileName.substring(0, indexOfExtension) + OUTPUT_SUFFIX + inputFileName.substring(indexOfExtension);
    }
}
