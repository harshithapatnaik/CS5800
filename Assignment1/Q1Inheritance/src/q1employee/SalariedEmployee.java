package q1employee;

/**
 *
 * @author harshitha
 */
class SalariedEmployee extends Employee {
    private double weeklySalary;

    // Constructor
    public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
        super(firstName, lastName, ssn);
        this.weeklySalary = weeklySalary;
    }

    // Getters and Setters
    public double getWeeklySalary() { return weeklySalary; }
    public void setWeeklySalary(double weeklySalary) { this.weeklySalary = weeklySalary; }

    // Display Employee details
    @Override
    public String toString() {
        return super.toString() + ", Weekly Salary: $" + weeklySalary;
    }
}
