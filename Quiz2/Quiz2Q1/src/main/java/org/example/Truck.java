package org.example;

public class Truck extends Vehicle {

    public Truck(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck Brand: " + getBrand() + ", Year: " + getYear());
    }
}
