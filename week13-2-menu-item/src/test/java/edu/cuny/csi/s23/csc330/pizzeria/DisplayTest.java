package edu.cuny.csi.s23.csc330.pizzeria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class DisplayTest {

    @Test
    void testDisplay() {
        ByteArrayInputStream in = new ByteArrayInputStream("42".getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream baOut = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baOut);
        Display display = new Display(in, out);
        int hello = display.sayAndGetInt("hello test 42");

        Assertions.assertEquals(42, hello, "expected Display to read 42");

        String helloMessage = baOut.toString();
        Assertions.assertEquals(
                "hello test 42\n", helloMessage, "expected Display print the message");
    }
}
