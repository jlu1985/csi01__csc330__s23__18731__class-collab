package edu.cuny.csi.s23.csc330.pizzeria;

public class Wing implements SaleItem {
    @Override
    public String toString() {
        return "Wing{" + "size=" + size + '}';
    }

    public Wing(int size) {
        this.size = size;
    }

    private final int size;

    @Override
    public int getSize() {
        return this.size;
    }
}
