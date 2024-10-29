package org.example.factory.dietPlans;

import org.example.enums.*;
import org.example.factory.Macronutrients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vegan implements Macronutrients {
    private static final Vegan instance = new Vegan();

    private Vegan() {}

    public static Vegan getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        // Vegan diet all carbs except cheese
        List<Carbs> allowedCarbs = new ArrayList<>(Arrays.asList(Carbs.values()));
        allowedCarbs.remove(Carbs.CHEESE);
        return Collections.unmodifiableList(allowedCarbs);
    }

    @Override
    public List<Protein> createProtein() {
        // Vegan diet excludes Fish, Chicken, Beef, and Tuna
        List<Protein> allowedProteins = new ArrayList<>(Arrays.asList(Protein.values()));
        allowedProteins.removeAll(Arrays.asList(Protein.FISH, Protein.CHICKEN, Protein.BEEF));
        return Collections.unmodifiableList(allowedProteins);
    }

    @Override
    public List<Fats> createFats() {
        // Vegan diet excludes Sour cream and Tuna
        List<Fats> allowedFats = new ArrayList<>(Arrays.asList(Fats.values()));
        allowedFats.removeAll(Arrays.asList(Fats.SOUR_CREAM, Fats.TUNA));
        return Collections.unmodifiableList(allowedFats);
    }
}