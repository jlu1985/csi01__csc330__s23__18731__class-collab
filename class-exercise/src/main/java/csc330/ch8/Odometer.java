package csc330.ch8;

public class Odometer {
    private static final int ROLL_OVER = 1000000;
    private double currentMile = 0;

    public Odometer() {
        this(0);
    }

    public Odometer(double currentMile) {
        addMileage(currentMile);
    }

    public static void main(String[] args) {
        System.out.println(new Odometer(1000001));
        System.out.println(new Odometer(1000000));
        System.out.println(new Odometer(15));
        System.out.println(new Odometer(999999));
        System.out.println(new Odometer());
    }

    public double getCurrentMile() {
        return currentMile;
    }

    @Override
    public String toString() {
        return "Odometer{" + "currentMile=" + currentMile + '}';
    }

    public void addMileage(double mile) {
        this.currentMile += mile;
        this.currentMile = this.currentMile % ROLL_OVER;
    }
}
