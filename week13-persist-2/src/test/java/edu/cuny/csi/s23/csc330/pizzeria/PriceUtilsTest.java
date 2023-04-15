package edu.cuny.csi.s23.csc330.pizzeria;

import static org.junit.jupiter.api.Assertions.*;

import edu.cuny.csi.s23.csc330.pizzeria.price.PriceUtils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceUtilsTest {

    @ParameterizedTest
    @CsvSource(
            textBlock =
                    """
                    -1,0.49
                    0,0.49
                    0.5,0.99
                    10,10.49
                    10.5,10.99
                    1000,1000.49
                    """)
    void roundToX9Cents(double input, double expect) {
        double output = PriceUtils.roundToX9Cents(input);
        assertEquals(expect, output, "expect input " + input + " rounded up to " + expect);
    }

    @ParameterizedTest
    @CsvSource(
            textBlock =
                    """
            -1,0.25
            0,0.25
            0.24,0.25
            0.25,0.5
            0.5,0.75
            0.75,1
            """)
    void roundToQuarter(double input, double expect) {
        double output = PriceUtils.roundToQuarter(input);
        assertEquals(expect, output, "expect input " + input + " rounded up to " + expect);
    }
}
