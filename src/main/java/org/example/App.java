package org.example;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
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

        for (File file : files) {
            if (file.isFile() && !file.getName().contains("_result")) {
                try {
                    RandomAccessFile inputReader = new RandomAccessFile(file.getAbsolutePath(), "r");

                    RandomAccessFile outputStream = new RandomAccessFile(getOutputFileName(outputPath, file.getName()), "rw");
                    FileChannel channel = outputStream.getChannel();

                    String value = inputReader.readLine();
                    byte[] strBytes = value.getBytes();
                    ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                    buffer.put(strBytes);

                    buffer.flip();
                    channel.write(buffer);
                    outputStream.close();
                    channel.close();

                    inputReader.close();
                } catch (IOException e) {
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
