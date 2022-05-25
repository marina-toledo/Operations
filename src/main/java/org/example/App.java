package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir") + "/src/main/resources/";
        String outputPath = inputPath;

        File[] files = new File(inputPath).listFiles();//If this pathname does not denote a directory, then listFiles() returns null.

        if (files == null) {
            System.out.println("Empty folder.");
            System.exit(0);
        }

        for (File file : files) {
            if (file.isFile() && !file.getName().contains("_result")) {
                try {
                    RandomAccessFile inputReader = new RandomAccessFile(file.getAbsolutePath(), "r");

                    File fileToBlock = new File(getOutputFileName(outputPath, file.getName()));
                    RandomAccessFile outputStream = new RandomAccessFile(fileToBlock, "rw");
                    FileChannel channel = outputStream.getChannel();

                    Unmarshaller unmarshaller = JAXBContext.newInstance(ExpressionsInput.class).createUnmarshaller();
                    ExpressionsInput expressions = (ExpressionsInput) unmarshaller.unmarshal(file);

                    Marshaller marshaller = JAXBContext.newInstance(ExpressionsOutput.class).createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    ExpressionsOutput expressionsOutput = new ExpressionsOutput();
                    Result result = new Result();
                    result.setId(12);
                    result.setResult(9);
                    expressionsOutput.setResult(List.of(result));
                    marshaller.marshal(expressionsOutput, fileToBlock);

                    outputStream.close();
                    channel.close();

                    inputReader.close();
                } catch (IOException | JAXBException e) {
                    System.out.println("Error in file " + file.getName() + ". Exception: " + e.getMessage());
                }
            }
        }

        //Obs: handle variations in
        //operations
        //format of files
    }

    private static String getOutputFileName(String path, String inputFileName) {
        int indexOfExtension = inputFileName.lastIndexOf('.');
        String outputFileName = path + inputFileName.substring(0, indexOfExtension) + "_result" + inputFileName.substring(indexOfExtension);
        return outputFileName;
    }
}
