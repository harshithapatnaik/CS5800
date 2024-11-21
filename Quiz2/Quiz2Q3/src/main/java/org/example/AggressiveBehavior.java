package org.example;

public class AggressiveBehavior implements DrivingBehavior {
    @Override
    public void reactToLight(String vehicleType, String color) {
        String action = switch (color) {
            case "RED" -> "Slam brake";
            case "YELLOW" -> "Faster";
            case "GREEN" -> "Need4Speed";
            default -> "";
        };
        System.out.println(vehicleType + " behavior: " + action);
    }
}