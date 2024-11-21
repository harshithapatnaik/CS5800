package org.example;

public class PassiveBehavior implements DrivingBehavior {
    @Override
    public void reactToLight(String vehicleType, String color) {
        String action = switch (color) {
            case "RED" -> "Stop";
            case "YELLOW" -> "Slower";
            case "GREEN" -> "Go Slow";
            default -> "";
        };
        System.out.println(vehicleType + " behavior: " + action);
    }
}
