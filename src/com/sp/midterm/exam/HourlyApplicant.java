package com.sp.midterm.exam;

/**
 * HourlyApplicant extends Applicant
 */
public class HourlyApplicant extends Applicant {

    private double wage;
    private double hours;

    public HourlyApplicant(String firstName, String lastName, String sin,
                           double wage, double hours) {
        super(firstName, lastName, sin);
        setWage(wage);
        setHours(hours);
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        if (wage < 0) {
            throw new IllegalArgumentException("wage must be greater than 0");
        }
        this.wage = wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("hours must be greater than 0");
        }
        this.hours = hours;
    }

    @Override
    public double earnings() {
        return wage * hours;
    }

    @Override
    public String toString() {
        return String.format("HourlyApplicant: %s | wage=%.2f, hours=%.2f, earnings=%.2f",
                super.toString(), wage, hours, earnings());
    }
}
