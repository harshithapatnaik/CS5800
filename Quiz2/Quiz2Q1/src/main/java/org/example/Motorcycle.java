package org.example;

public class Motorcycle extends Vehicle {

    public Motorcycle(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle Brand: " + getBrand() + ", Year: " + getYear());
    }
}
