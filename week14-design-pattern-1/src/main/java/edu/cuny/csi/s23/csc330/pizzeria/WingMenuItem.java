package edu.cuny.csi.s23.csc330.pizzeria;

import java.awt.*;
import java.util.LinkedHashSet;
import java.util.Set;

public class WingMenuItem implements MenuItem {
    private final Set<Integer> sizes;

    public WingMenuItem() {
        sizes = new LinkedHashSet<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(20);
    }

    public Set<Integer> getSizes() {
        return this.sizes;
    }
}
