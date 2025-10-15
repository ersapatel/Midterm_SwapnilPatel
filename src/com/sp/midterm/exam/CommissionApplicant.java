package com.sp.midterm.exam;

/**
 * CommissionApplicant extends Applicant
 */
public class CommissionApplicant extends Applicant {

    private double grossSales;
    private double commissionRate;

    public CommissionApplicant(String firstName, String lastName, String sin,
                               double grossSales, double commissionRate) {
        super(firstName, lastName, sin);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0) {
            throw new IllegalArgumentException("grossSales must be greater than 0");
        }
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0 || commissionRate > 100) {
            throw new IllegalArgumentException(
                "commissionRate must be between 0 and 100"
            );
        }
        this.commissionRate = commissionRate / 100;
    }

    @Override
    public double earnings() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return String.format(
            "CommissionApplicant: %s | grossSales=%.2f, commissionRate=%.2f, earnings=%.2f",
            super.toString(), grossSales, commissionRate, earnings()
        );
    }
}
