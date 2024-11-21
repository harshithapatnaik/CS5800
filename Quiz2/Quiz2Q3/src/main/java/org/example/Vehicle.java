package org.example;

public class Vehicle implements Observer {
    private final String name;
    private final DrivingBehavior behavior;

    public Vehicle(String name, DrivingBehavior behavior) {
        this.name = name;
        this.behavior = behavior;
    }

    @Override
    public void update(String color) {
        behavior.reactToLight(name, color);
    }
}