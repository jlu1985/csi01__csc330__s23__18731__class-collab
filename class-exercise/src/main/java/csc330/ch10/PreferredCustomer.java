package csc330.ch10;

import java.util.stream.IntStream;

public class PreferredCustomer {
    private double purchase = 0;
    private double discountPercent = 1;

    public static void main(String[] args) {
        PreferredCustomer preferredCustomer = new PreferredCustomer();

        IntStream.range(1, 25)
                .boxed()
                .forEach(
                        i -> {
                            preferredCustomer.add(100.0);
                            System.out.println(preferredCustomer);
                        });
    }

    public void add(Double purchaseAmount) {
        // look purchase
        // look discountPercent

        if (purchase >= 500) {
            discountPercent = 0.95;
        }
        if (purchase >= 1000) {
            discountPercent = 0.94;
        }
        if (purchase >= 1500) {
            discountPercent = 0.93;
        }
        if (purchase >= 2000) {
            discountPercent = 0.9;
        }

        var discountedPrice = purchaseAmount * discountPercent;
        purchase += discountedPrice;
    }

    @Override
    public String toString() {
        return "PreferredCustomer{"
                + "purchase="
                + purchase
                + ", discountPercent="
                + discountPercent
                + '}';
    }
}
