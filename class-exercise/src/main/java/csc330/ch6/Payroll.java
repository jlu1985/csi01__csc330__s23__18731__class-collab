package csc330.ch6;

public class Payroll {
    private String name;
    private double rate;
    private double hours;
    private int id;

    public Payroll(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {

        Payroll payroll = new Payroll("random", 3);
        payroll.setHours(40);
        payroll.setRate(25);
        System.out.println(payroll.getGrossPay());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrossPay() {
        return rate * hours;
    }
}
