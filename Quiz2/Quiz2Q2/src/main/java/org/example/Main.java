package org.example;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.addObserver(new Vehicle("Vehicle 1"));
        trafficLight.addObserver(new Vehicle("Vehicle 2"));
        trafficLight.addObserver(new Vehicle("Vehicle 3"));

        trafficLight.start();
    }
}