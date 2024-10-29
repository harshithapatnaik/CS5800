package org.example.factory.dietPlans;

import org.example.enums.*;
import org.example.factory.Macronutrients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NutAllergy implements Macronutrients {
    private static final NutAllergy instance = new NutAllergy();

    private NutAllergy() {}

    public static NutAllergy getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        // Exclude nuts (Pistachio) from carbs
        List<Carbs> allowedCarbs = new ArrayList<>(Arrays.asList(Carbs.values()));
        allowedCarbs.remove(Carbs.PISTACHIO);
        return Collections.unmodifiableList(allowedCarbs);
    }

    @Override
    public List<Protein> createProtein() {
        // Protein choices are unaffected by nut allergies in this context
        return new ArrayList<>(Arrays.asList(Protein.values()));
    }

    @Override
    public List<Fats> createFats() {
        // Exclude nuts (Peanuts) from fats
        List<Fats> allowedFats = new ArrayList<>(Arrays.asList(Fats.values()));
        allowedFats.remove(Fats.PEANUTS);
        return Collections.unmodifiableList(allowedFats);
    }
}