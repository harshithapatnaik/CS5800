package q1employee;

/**
 *
 * @author harshitha
 */
class HourlyEmployee extends Employee {
    private double wage;
    private double hoursWorked;

    // Constructor
    public HourlyEmployee(String firstName, String lastName, String ssn, double wage, double hoursWorked) {
        super(firstName, lastName, ssn);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    // Getters and Setters
    public double getWage() { return wage; }
    public double getHoursWorked() { return hoursWorked; }

    public void setWage(double wage) { this.wage = wage; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    // Display Employee details
    @Override
    public String toString() {
        return super.toString() + ", Wage: $" + wage + ", Hours Worked: " + hoursWorked;
    }
}
