package q1employee;

/**
 *
 * @author harshitha
 */
public class Q1Employee {
    
    public static void main(String[] args) {
        
        SalariedEmployee emp1 = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500);
        HourlyEmployee emp2 = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25, 32);
        HourlyEmployee emp3 = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19, 47);
        CommissionEmployee emp4 = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 15, 50000);
        SalariedEmployee emp5 = new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700);
        BaseEmployee emp6 = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000);
        CommissionEmployee emp7 = new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 22, 40000);

        // Print header
        System.out.printf("%-12s%-12s%-15s%-15s%-8s%-14s%-10s%-15s%-12s\n", 
                          "First_name", "Last_name", "Social_Sec_#", "Weekly_Salary", "Wage", "Hours_worked", "Com_rate", "Gross_salary", "Base_salary");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        printEmployee(emp1, emp1.getWeeklySalary(), 0, 0, 0, 0, 0);
        printEmployee(emp2, 0, emp2.getWage(), emp2.getHoursWorked(), 0, 0, 0);
        printEmployee(emp3, 0, emp3.getWage(), emp3.getHoursWorked(), 0, 0, 0);
        printEmployee(emp4, 0, 0, 0, emp4.getCommissionRate(), emp4.getGrossSales(), 0);
        printEmployee(emp5, emp5.getWeeklySalary(), 0, 0, 0, 0, 0);
        printEmployee(emp6, 0, 0, 0, 0, 0 , emp6.getBaseSalary());
        printEmployee(emp7, 0, 0, 0, emp7.getCommissionRate(), emp7.getGrossSales(), 0);
    }

    // Method to print the employee details in a table format
    private static void printEmployee(Employee emp, double weeklySalary, double wage, double hoursWorked, double comRate, double grossSalary, double baseSalary) {
        System.out.printf("%-12s%-12s%-15s", emp.getFirstName(), emp.getLastName(), emp.getSocialSecurityNumber());
        
        if (weeklySalary > 0) {
            System.out.printf("%-15s", String.format("$%,.0f", weeklySalary));
        } else {
            System.out.printf("%-15s", "");
        }

        if (wage > 0) {
            System.out.printf("%-8s", String.format("$%,.0f", wage));
        } else {
            System.out.printf("%-8s", "");
        }

        if (hoursWorked > 0) {
            System.out.printf("%-14s", String.format("%.0f", hoursWorked));
        } else {
            System.out.printf("%-14s", "");
        }

        if (comRate > 0) {
            System.out.printf("%-10s", String.format("%.0f%%", comRate));
        } else {
            System.out.printf("%-10s", "");
        }

        if (grossSalary > 0) {
            System.out.printf("%-15s", String.format("$%,.0f", grossSalary));
        } else {
            System.out.printf("%-15s", "");
        }

        if (baseSalary > 0) {
            System.out.printf("%-15s", String.format("$%,.0f", baseSalary));
        } else {
            System.out.printf("%-15s", "");
        }

        System.out.printf("%-12s\n", "");
    }
}
