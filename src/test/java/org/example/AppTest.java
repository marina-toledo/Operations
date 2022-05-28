package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Objects;

import static org.example.App.OUTPUT_SUFFIX;
import static org.junit.Assert.*;

public class AppTest {

    public static final String PATH = System.getProperty("user.dir") + "/src/test/resources/";
    public static final String PATH_SIMPLE = System.getProperty("user.dir") + "/src/test/resources/simple/";
    public static final String PATH_COMPLEX = System.getProperty("user.dir") + "/src/test/resources/complex/";

    public void deleteGeneratedResultFiles(String path) {
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
        assertTrue(
                FileUtils.contentEquals(
                        new File(PATH_SIMPLE + "data0001_result.xml"),
                        new File(PATH_SIMPLE + "result/data0001_result.xml")
                )
        );
        deleteGeneratedResultFiles(PATH_SIMPLE);
    }

    @Test
    public void shouldCalculateComplex() throws IOException {
        App.main(new String[]{PATH_COMPLEX, PATH_COMPLEX});
        assertTrue(
                FileUtils.contentEquals(
                        new File(PATH_COMPLEX + "data0002_result.xml"),
                        new File(PATH_COMPLEX + "result/data0002_result.xml")
                )
        );
        deleteGeneratedResultFiles(PATH_COMPLEX);
    }
}
