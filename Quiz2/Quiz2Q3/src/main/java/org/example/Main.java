package org.example;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.addObserver(new Vehicle("Car", new NormalBehavior()));
        trafficLight.addObserver(new Vehicle("Motorcycle", new AggressiveBehavior()));
        trafficLight.addObserver(new Vehicle("Truck", new PassiveBehavior()));

        trafficLight.start();
    }
}