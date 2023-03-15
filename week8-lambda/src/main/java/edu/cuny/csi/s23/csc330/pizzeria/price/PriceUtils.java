package edu.cuny.csi.s23.csc330.pizzeria.price;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceUtils {
    private static final BigDecimal CENTS_99 = BigDecimal.valueOf(0.99);
    private static final BigDecimal CENTS_49 = BigDecimal.valueOf(0.49);

    private static final BigDecimal CENTS_100 = BigDecimal.valueOf(1.0);
    private static final BigDecimal CENTS_75 = BigDecimal.valueOf(0.75);
    private static final BigDecimal CENTS_50 = BigDecimal.valueOf(0.5);
    private static final BigDecimal CENTS_25 = BigDecimal.valueOf(0.25);

    /**
     * For example $10 return $10.49, $10.5 return $10.99
     *
     * @param input dollar amount
     * @return dollar round next 49cents or 99 cents
     */
    public static double roundToX9Cents(double input) {
        if (input < 0) {
            return 0.49;
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(input);
        BigDecimal dollarPart = BigDecimal.valueOf(bigDecimal.intValue());

        BigDecimal decimalPart = bigDecimal.remainder(BigDecimal.ONE);
        if (decimalPart.doubleValue() >= 0.5) {
            return dollarPart.add(CENTS_99).doubleValue();
        }
        return dollarPart.add(CENTS_49).doubleValue();
    }

    /**
     * For example, input is $10 output will be $10.25
     *
     * @param input dollar amount
     * @return dollar round up to next quarter
     */
    public static double roundToQuarter(double input) {
        if (input < 0) {
            return 0.25;
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(input);
        BigDecimal dollarValue = BigDecimal.valueOf(bigDecimal.intValue());
        double decimals = bigDecimal.remainder(BigDecimal.ONE).doubleValue();

        if (decimals >= 0.75) {
            return dollarValue.add(CENTS_100).doubleValue();
        }
        if (decimals >= 0.5) {
            return dollarValue.add(CENTS_75).doubleValue();
        }
        if (decimals >= 0.25) {
            return dollarValue.add(CENTS_50).doubleValue();
        }
        return dollarValue.add(CENTS_25).doubleValue();
    }

    public static double add(double a, double b) {
        return scale(BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)));
    }

    private static double scale(BigDecimal input) {
        return input.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
