package org.example;

public class Main {
    public static void main(String[] args) {
        // Part a
        Vehicle car = new Car("Brand A", 2021);
        Vehicle motorcycle = new Motorcycle("Brand B", 2019);
        Vehicle truck = new Truck("Brand C", 2020);

        car.displayInfo();
        motorcycle.displayInfo();
        truck.displayInfo();
    }
}