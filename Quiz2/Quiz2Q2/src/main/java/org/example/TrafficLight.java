package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrafficLight {
    enum Color {
        RED, GREEN, YELLOW
    }

    private Color currentColor = Color.RED;
    private final Random random = new Random();
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentColor.name());
        }
    }

    public void changeColor() {
        currentColor = switch (currentColor) {
            case RED -> Color.GREEN;
            case GREEN -> Color.YELLOW;
            case YELLOW -> Color.RED;
        };
        System.out.println("Traffic Light changed to: " + currentColor);
        notifyObservers();
    }

    public void start() {
        while (true) {
            changeColor();
            try {
                Thread.sleep(1000 + random.nextInt(2000)); // Wait for 1-3 seconds randomly
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

