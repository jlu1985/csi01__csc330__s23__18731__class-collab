package edu.cuny.csi.s23.csc330.pizzeria;

public class Menu {
    private final Pizza pepperoni;
    private final Pizza hawaiian;
    private final Pizza specialty;
    private final Pizza buildYourOwn;

    public Menu(Pizza pepperoni, Pizza hawaiian, Pizza specialty, Pizza buildYourOwn) {
        this.pepperoni = pepperoni;
        this.hawaiian = hawaiian;
        this.specialty = specialty;
        this.buildYourOwn = buildYourOwn;
    }

    public Pizza getPepperoni() {
        return pepperoni;
    }

    public Pizza getHawaiian() {
        return hawaiian;
    }

    public Pizza getSpecialty() {
        return specialty;
    }

    public Pizza getBuildYourOwn() {
        return buildYourOwn;
    }

    public Pizza get(double choice) {
        return switch ((int) choice) {
            case 1 -> pepperoni;
            case 2 -> hawaiian;
            case 3 -> specialty;
            case 4 -> buildYourOwn;
            default -> null;
        };
    }
}
