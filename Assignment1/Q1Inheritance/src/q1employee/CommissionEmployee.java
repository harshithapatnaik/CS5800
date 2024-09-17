package q1employee;

/**
 *
 * @author harshitha
 */
class CommissionEmployee extends Employee {
    private double commissionRate;
    private double grossSales;

    // Constructor
    public CommissionEmployee(String firstName, String lastName, String ssn, double commissionRate, double grossSales) {
        super(firstName, lastName, ssn);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    // Getters and Setters
    public double getCommissionRate() { return commissionRate; }
    public double getGrossSales() { return grossSales; }

    public void setCommissionRate(double commissionRate) { this.commissionRate = commissionRate; }
    public void setGrossSales(double grossSales) { this.grossSales = grossSales; }

    // Display Employee details
    @Override
    public String toString() {
        return super.toString() + ", Commission Rate: " + commissionRate + "%, Gross Sales: $" + grossSales;
    }
}

