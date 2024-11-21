package org.example;

public class NormalBehavior implements DrivingBehavior {
    @Override
    public void reactToLight(String vehicleType, String color) {
        String action = switch (color) {
            case "RED" -> "Stop";
            case "YELLOW" -> "Slow";
            case "GREEN" -> "Go";
            default -> "";
        };
        System.out.println(vehicleType + " behavior: " + action);
    }
}
