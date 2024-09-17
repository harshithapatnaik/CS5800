package q3aggregation;

/**
 *
 * @author harshitha
 */
class Instructor {
    private String firstName;
    private String lastName;
    private String officeNumber;

    // Constructor
    public Instructor(String firstName, String lastName, String officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getOfficeNumber() { return officeNumber; }
    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; }

    // Display Instructor details
    public void print() {
        System.out.println("Instructor: " + firstName + " " + lastName + ", Office: " + officeNumber);
    }
}

