package com.sp.midterm.exam;

/**
 * Abstract base class representing an Applicant.
 */
public abstract class Applicant {

    private String firstName;
    private String lastName;
    private String socialInsuranceNumber;

    /**
     * Applicant with the required identity fields.
     */
    public Applicant(String firstName, String lastName, String socialInsuranceNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setSocialInsuranceNumber(socialInsuranceNumber);
    }

    public abstract double earnings();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = requireNotBlank(firstName, "firstName");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = requireNotBlank(lastName, "lastName");
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = requireNotBlank(socialInsuranceNumber, "socialInsuranceNumber");
    }

    /** Full name */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    /** Basic validation helper */
    protected static String requireNotBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Field '" + fieldName + "' must not be empty.");
        }
        return value.trim();
    }

    @Override
    public String toString() {
        return String.format("%s (SIN: %s)", getFullName(), getSocialInsuranceNumber());
    }
}
