package org.example;

import jakarta.xml.bind.JAXBException;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class App {
    public static void main(String[] args) {
        String inputPath = System.getProperty("user.dir") + "/src/main/resources/";
        String outputPath = inputPath;

        File[] files = new File(inputPath).listFiles();//If this pathname does not denote a directory, then listFiles() returns null.

        if (files == null) {
            System.out.println("Empty folder.");
            System.exit(0);
        }

        for (File fileInput : files) {
            if (fileInput.isFile() && !fileInput.getName().contains("_result")) {
                try {
                    RandomAccessFile inputReader = new RandomAccessFile(fileInput.getAbsolutePath(), "r");

                    File fileOutput = new File(getOutputFileName(outputPath, fileInput.getName()));
                    RandomAccessFile outputStream = new RandomAccessFile(fileOutput, "rw");
                    FileChannel channel = outputStream.getChannel();

                    new XMLParser().process(fileInput, fileOutput);

                    outputStream.close();
                    channel.close();

                    inputReader.close();
                } catch (IOException | ParseException e) {
                    System.out.println("Error in file " + fileInput.getName() + ". Exception: " + e.getMessage());
                }
            }
        }

        //Obs: handle variations in
        //operations
        //format of files
    }

    @NotNull
    private static String getOutputFileName(String path, String inputFileName) {
        int indexOfExtension = inputFileName.lastIndexOf('.');
        return path + inputFileName.substring(0, indexOfExtension) + "_result" + inputFileName.substring(indexOfExtension);
    }
}
