package q1employee;

/**
 *
 * @author harshitha
 */
class BaseEmployee extends Employee {
    private double baseSalary;

    // Constructor
    public BaseEmployee(String firstName, String lastName, String ssn, double baseSalary) {
        super(firstName, lastName, ssn);
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    // Display Employee details
    @Override
    public String toString() {
        return super.toString() + ", Base Salary: $" + baseSalary;
    }
}

