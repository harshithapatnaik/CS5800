package q2polymorphism;

/**
 *
 * @author harshitha
 */
class CruiseShip extends Ship {
    private int maxPassengers;

    // Constructor
    public CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt);
        this.maxPassengers = maxPassengers;
    }

    // Getters and Setters
    public int getMaxPassengers() { return maxPassengers; }
    public void setMaxPassengers(int maxPassengers) { this.maxPassengers = maxPassengers; }

    // Override the print function
    @Override
    public void print() {
        System.out.println("Cruise Ship: " + getName() + ", Max Passengers: " + maxPassengers);
    }
}

