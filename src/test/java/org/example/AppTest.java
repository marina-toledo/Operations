package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.example.model.ExpressionsInput;
import org.example.model.ExpressionsOutput;
import org.example.model.Result;
import org.example.model.operation.*;
import org.example.service.Calculator;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.List;
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
    public void shouldCalculateSimpleAndParseXML() throws IOException {
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
    public void shouldCalculateComplexAndParseXML() throws IOException {
        App.main(new String[]{PATH_COMPLEX, PATH_COMPLEX});
        assertTrue(
                FileUtils.contentEquals(
                        new File(PATH_COMPLEX + "data0002_result.xml"),
                        new File(PATH_COMPLEX + "result/data0002_result.xml")
                )
        );
        deleteGeneratedResultFiles(PATH_COMPLEX);
    }

    @Test
    public void shouldCalculateSimple() {
        // 2 + 3 + 4 = 9
        Addition addition = new Addition(List.of(new Value(2), new Value(3), new Value(4)));
        addition.setId(1);
        ExpressionsInput input = new ExpressionsInput(List.of(addition));

        assertEquals(
                new ExpressionsOutput(List.of(new Result(1, 9))),
                Calculator.process(input)
        );
    }

    @Test
    public void shouldCalculateComplex() {
        // 2+3+(7-3) = 9
        Addition addition = new Addition(List.of(new Value(2), new Value(3), new Subtraction(new Value(7), new Value(3))));
        addition.setId(10);
        // 3-2 = 1
        Subtraction subtraction = new Subtraction(new Value(3), new Value(2));
        subtraction.setId(11);
        // 5*6*8 = 240
        Multiplication multiplication = new Multiplication(List.of(new Value(5), new Value(6), new Value(8)));
        multiplication.setId(12);
        // (2+3+4)*6*(3*4*5*10*56) = 1814400
        Multiplication multiplication2 = new Multiplication(List.of(
                new Addition(List.of(new Value(2), new Value(3), new Value(4))),
                new Value(6),
                new Multiplication(List.of(new Value(3), new Value(4), new Value(5), new Value(10), new Value(56)))
        ));
        multiplication2.setId(13);
        // 54/(3+6) = 6
        Division division = new Division(new Value(54), new Addition(List.of(new Value(3), new Value(6))));
        division.setId(14);
        ExpressionsInput input = new ExpressionsInput(List.of(addition, subtraction, multiplication, multiplication2, division));

        ExpressionsOutput expectedOutput = new ExpressionsOutput(List.of(
                new Result(10, 9),
                new Result(11, 1),
                new Result(12, 240),
                new Result(13, 1814400),
                new Result(14, 6)
        ));

        assertEquals(expectedOutput,
                Calculator.process(input)
        );
    }
}
