package com.sp.midterm.exam;

import java.util.Scanner;

/**
 * Driver class for demo
 */
public class MidtermDriver_SwapnilPatel {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Midterm: Salary and Commission Calculator \n");

        // to hold 3 hourly and 3 commission applicants
        HourlyApplicant[] hourly = new HourlyApplicant[3];
        CommissionApplicant[] commission = new CommissionApplicant[3];

        // Collect Hourly Applicants
        System.out.println("Enter details for 3 HOURLY applicants:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nHourly Applicant #" + (i + 1));

            System.out.print("Enter First name: ");
            String first = scan.nextLine();

            System.out.print("Enter Last name: ");
            String last = scan.nextLine();

            System.out.print("Enter SIN: ");
            String sin = scan.nextLine();

            System.out.print("Enter Hourly wage: ");
            double wage = readDouble(scan);

            System.out.print("Enter Hours worked : ");
            double hours = readDouble(scan);

            try {
                hourly[i] = new HourlyApplicant(first, last, sin, wage, hours);
                System.out.println("Saved: " + hourly[i]);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
                i--;
                System.out.println("Please re-enter this hourly applicant.");
                if (scan.hasNextLine()) scan.nextLine();
            }
        }

        // Collect Commission Applicants
        System.out.println("\nEnter details for 3 COMMISSION applicants:");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nCommission Applicant #" + (i + 1));

            System.out.print("Enter First name: ");
            String first = scan.nextLine();

            System.out.print("Enter Last name: ");
            String last = scan.nextLine();

            System.out.print("Enter SIN: ");
            String sin = scan.nextLine();

            System.out.print("Enter Gross sales: ");
            double grossSales = readDouble(scan);

            System.out.print("Enter Commission rate in %: ");
            double commissionRate = readDouble(scan);

            try {
                commission[i] = new CommissionApplicant(first, last, sin, grossSales, commissionRate);
                System.out.println("Saved: " + commission[i]);
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input: " + ex.getMessage());
                i--;
                System.out.println("Please re-enter this commission applicant.");
                if (scan.hasNextLine()) scan.nextLine();
            }
        }

        // Summary
        System.out.println("\n=== Summary: Hourly Applicants ===");
        for (HourlyApplicant h : hourly) {
            System.out.println(h);
        }

        System.out.println("\n=== Summary: Commission Applicants ===");
        for (CommissionApplicant c : commission) {
            System.out.println(c);
        }

        scan.close();
    }

    // helper method to read a double
    private static double readDouble(Scanner scan) {
        while (true) {
            String line = scan.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
