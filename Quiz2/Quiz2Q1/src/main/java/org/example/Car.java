package org.example;

public class Car extends Vehicle {

    public Car(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Brand: " + getBrand() + ", Year: " + getYear() );
    }
}

