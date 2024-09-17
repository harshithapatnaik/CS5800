package q1employee;

/**
 *
 * @author harshitha
 */
class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    // Constructor
    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = ssn;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSocialSecurityNumber() { return socialSecurityNumber; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSocialSecurityNumber(String ssn) { this.socialSecurityNumber = ssn; }

    // Display Employee details
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", SSN: " + socialSecurityNumber;
    }
}

