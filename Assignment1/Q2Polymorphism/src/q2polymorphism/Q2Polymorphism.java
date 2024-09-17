package q2polymorphism;

/**
 *
 * @author harshitha
 */
public class Q2Polymorphism {

    public static void main(String[] args) { 
        
        Ship[] ships = new Ship[3];
        
        // creating one Ship, one CruiseShip, and one CargoShip
        ships[0] = new Ship("HP Ship", "2002");
        ships[1] = new CruiseShip("HP Cruise 212", "2012", 3000);
        ships[2] = new CargoShip("HP Cargo 118", "2023", 20000);
        
        for (Ship ship : ships) {
            ship.print(); // calling print method depending on the class type
        }
    }
}
