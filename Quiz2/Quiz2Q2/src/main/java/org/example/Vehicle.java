package org.example;

public class Vehicle implements Observer {
    private final String name;

    public Vehicle(String name) {
        this.name = name;
    }

    @Override
    public void update(String color) {
        System.out.println(name + " notified: Traffic light changed to " + color);
    }
}