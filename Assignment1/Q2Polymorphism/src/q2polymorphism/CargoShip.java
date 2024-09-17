package q2polymorphism;

/**
 *
 * @author harshitha
 */
class CargoShip extends Ship {
    private int cargoCapacity;

    // Constructor
    public CargoShip(String name, String yearBuilt, int cargoCapacity) {
        super(name, yearBuilt);
        this.cargoCapacity = cargoCapacity;
    }

    // Getters and Setters
    public int getCargoCapacity() { return cargoCapacity; }
    public void setCargoCapacity(int cargoCapacity) { this.cargoCapacity = cargoCapacity; }

    // Override the print function
    @Override
    public void print() {
        System.out.println("Cargo Ship: " + getName() + ", Cargo Capacity: " + cargoCapacity + " tons");
    }
}

