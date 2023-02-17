package csc330.ch8;

public class FuelGauge {
    public static final double MAX = 15.0;
    private double currentLevel = 0.0;

    public FuelGauge(double currentLevel) {
        addFuel(currentLevel);
    }

    public static void main(String[] args) {

        /*
        //example fueling up 1 gallon at a time
        for (int i = 0; i <= 16; i++) {
            FuelGauge fuel = new FuelGauge();
            fuel.addFuel(i);
            System.out.println(fuel);
        }*/

        // example fueling up until its full
        FuelGauge fuelGauge = new FuelGauge(0);
        while (!fuelGauge.addFuel(1.3)) {
            System.out.println(fuelGauge);
        }
        System.out.println(fuelGauge);
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public String toString() {
        return "FuelGauge{" + "currentLevel=" + currentLevel + '}';
    }

    public boolean addFuel(double fuel) {
        this.currentLevel += fuel;
        if (this.currentLevel > MAX) {
            this.currentLevel = MAX;
            return true;
        }
        return false;
    }

    public void consume(double fuel) {
        this.currentLevel -= fuel;
    }
}
