package q2polymorphism;

/**
 *
 * @author harshitha
 */
class Ship {
    private String name;
    private String yearBuilt;

    // Constructor
    public Ship(String name, String yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getYearBuilt() { return yearBuilt; }

    public void setName(String name) { this.name = name; }
    public void setYearBuilt(String yearBuilt) { this.yearBuilt = yearBuilt; }

    // Print function
    public void print() {
        System.out.println("Ship Name: " + name + ", Year Built: " + yearBuilt);
    }
}

