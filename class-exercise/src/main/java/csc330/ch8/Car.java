package csc330.ch8;

// note that FuelGauge and Odometer are in the same package, so no import statements

import java.util.Random;

public class Car {
    public static final int MILES_PER_GALLON = 24;
    private final FuelGauge fuelGauge;
    private final Odometer odometer;

    public Car(double fuelGauge, double odometer) {
        this.fuelGauge = new FuelGauge(fuelGauge);
        this.odometer = new Odometer(odometer);
    }

    public static void main(String[] args) {
        Car car = new Car(FuelGauge.MAX, 999700);
        goSomewhere(car);
        car.fuelUp(10);
        System.out.printf("get 10 gallon %s%n", car);
        goSomewhere(car);
    }

    private static void goSomewhere(Car car) {
        Random random = new Random();
        System.out.println(car);
        double excessiveMiles = 0;
        while (excessiveMiles <= 0.0) {
            double miles = random.nextDouble(100);
            System.out.printf("Going to drive %.1f%n", miles);
            excessiveMiles = car.drive(miles);
            System.out.printf("-After driving %.1f miles, %s%n", miles, car);
        }
        System.out.printf(
                "cannot go further excessive miles %.1f, need to get gas %s%n",
                excessiveMiles, car);
    }

    @Override
    public String toString() {
        return "Car{"
                + "fuelGauge="
                + String.format("%.2f", fuelGauge.getCurrentLevel())
                + ", odometer="
                + String.format("%.1f", odometer.getCurrentMile())
                + '}';
    }

    private void fuelUp(double fuel) {
        fuelGauge.addFuel(fuel);
    }

    private double drive(double miles) {
        double targetConsumption = miles / MILES_PER_GALLON;
        double currentLevel = fuelGauge.getCurrentLevel();
        if (targetConsumption > currentLevel) {
            double actualConsumption = currentLevel;
            fuelGauge.consume(currentLevel);
            odometer.addMileage(actualConsumption * MILES_PER_GALLON);
            double excessiveMiles = (targetConsumption - actualConsumption) * MILES_PER_GALLON;
            return excessiveMiles;
        } else {
            fuelGauge.consume(targetConsumption);
            odometer.addMileage(miles);
            return 0;
        }
    }
}
