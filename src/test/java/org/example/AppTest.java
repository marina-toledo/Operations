package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;

import static org.example.App.OUTPUT_SUFFIX;
import static org.junit.Assert.*;

public class AppTest {

    public static final String PATH = System.getProperty("user.dir") + "/src/test/resources/";

    @After
    public void afterEachTest() {
        File dir = new File(PATH);
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
    }
}
