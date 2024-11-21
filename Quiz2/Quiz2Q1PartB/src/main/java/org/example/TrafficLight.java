package org.example;

import java.util.Random;

public class TrafficLight {
    enum Color {
        RED, GREEN, YELLOW
    }

    private Color currentColor;
    private final Random random;

    public TrafficLight() {
        this.currentColor = Color.RED;
        this.random = new Random();
    }

    public void changeColor() {
        switch (currentColor) {
            case RED -> currentColor = Color.GREEN;
            case GREEN -> currentColor = Color.YELLOW;
            case YELLOW -> currentColor = Color.RED;
        }
        System.out.println("Traffic Light changed to: " + currentColor);
    }

    public void start() {
        while (true) {
            changeColor();
            try {
                Thread.sleep(1000 + random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}