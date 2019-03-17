package com.kamereo.account.problem;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class SolutionTest {

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Spy
    private Solution solution = new Solution();

    @Test
    public void testRun() throws IOException {
        final String input = "6" + System.lineSeparator()
                + "A F" + System.lineSeparator()
                + "A B" + System.lineSeparator()
                + "A C E" + System.lineSeparator()
                + "A" + System.lineSeparator()
                + "D" + System.lineSeparator()
                + "A C" + System.lineSeparator()
                + "A B" + System.lineSeparator()
                + "CEO" + System.lineSeparator()
                + "CEO" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "1" + System.lineSeparator()
                + "2" + System.lineSeparator()
                + "Add 2 F" + System.lineSeparator()
                + "QUERY 2" + System.lineSeparator()
                + "REMOVE 6 B" + System.lineSeparator()
                + "QUERY 2" + System.lineSeparator()
                + "ADD 1 G" + System.lineSeparator()
                + "QUERY CEO" + System.lineSeparator()
                + "REMOVE 5 C" + System.lineSeparator()
                + "QUERY 1" + System.lineSeparator()
                + "QUIT" + System.lineSeparator();

        final String expectedOutput = "A,B,C,D,E,F" + System.lineSeparator()
                + "A,B,C,D" + System.lineSeparator()
                + "A,B,C,E" + System.lineSeparator()
                + "A" + System.lineSeparator()
                + "D" + System.lineSeparator()
                + "A,C" + System.lineSeparator()
                + "A,B" + System.lineSeparator()
                + "A,B,C,E,F" + System.lineSeparator()
                + "A,C,E,F" + System.lineSeparator()
                + "A,B,C,D,E,F,G" + System.lineSeparator()
                + "A,B,D,G" + System.lineSeparator();

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (
                InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
                PrintStream printStream = new PrintStream(outputStream, true, "UTF-8")
        ) {
            when(solution.getInputStream()).thenReturn(inputStream);
            when(solution.getPrintStream()).thenReturn(printStream);

            solution.run();

            String output = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
            assertThat(output, is(expectedOutput));
        }
    }
}
