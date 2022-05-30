package org.example;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.Objects;

import static org.example.App.OUTPUT_SUFFIX;
import static org.junit.Assert.*;

public class AppTest {

    public static final String SEP = File.separator;
    public static final String RESOURCES_PATH = SEP + "src" + SEP + "test" + SEP + "resources" + SEP;
    public static final String PATH = System.getProperty("user.dir") + RESOURCES_PATH;
    public static final String PATH_SIMPLE = System.getProperty("user.dir") + RESOURCES_PATH + "simple" + SEP;
    public static final String PATH_COMPLEX = System.getProperty("user.dir") + RESOURCES_PATH + "complex" + SEP;

    private void deleteGeneratedResultFiles(String path) {
        File dir = new File(path);
        FileFilter fileFilter = new WildcardFileFilter("*" + OUTPUT_SUFFIX + "*");

        File[] files = dir.listFiles(fileFilter);
        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
            files[i].delete();
        }
    }

    @Test
    public void shouldCreateOutputFile() {
        String outputFileName = PATH + "data0001_result.xml";
        assertFalse(new File(outputFileName).exists());

        App.main(new String[]{PATH, PATH});
        assertTrue(new File(outputFileName).exists());
        deleteGeneratedResultFiles(PATH);
    }

    @Test
    public void shouldGenerateOutputFileName() {
        String outputFileName = App.getOutputFileName("", "inputFileName.json");
        assertEquals("inputFileName_result.json", outputFileName);
    }

    @Test
    public void shouldCalculateSimple() throws IOException {
        App.main(new String[]{PATH_SIMPLE, PATH_SIMPLE});
        compareFileContent(PATH_SIMPLE + "result" + SEP + "data0001_result.xml", PATH_SIMPLE + "data0001_result.xml");
        deleteGeneratedResultFiles(PATH_SIMPLE);
    }

    @Ignore //TODO: Fix
    @Test
    public void shouldCalculateComplex() throws IOException {
        App.main(new String[]{PATH_COMPLEX, PATH_COMPLEX});
        compareFileContent(PATH_COMPLEX + "result" + SEP + "data0002_result.xml", PATH_COMPLEX + "data0002_result.xml");
        deleteGeneratedResultFiles(PATH_COMPLEX);
    }

    private void compareFileContent(String pathExpected, String pathActual) throws IOException {
        Reader reader1 = new BufferedReader(new FileReader(pathExpected));
        Reader reader2 = new BufferedReader(new FileReader(pathActual));
        assertTrue(IOUtils.contentEqualsIgnoreEOL(reader1, reader2));
    }
}
