package org.example.factory.dietPlans;

import org.example.enums.*;
import org.example.factory.Macronutrients;

import java.util.List;

public class NoRestriction implements Macronutrients {
    private static final NoRestriction instance = new NoRestriction();

    private NoRestriction() {}

    public static NoRestriction getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        return List.of(Carbs.values());
    }

    @Override
    public List<Protein> createProtein() {
        return List.of(Protein.values());
    }

    @Override
    public List<Fats> createFats() {
        return List.of(Fats.values());
    }
}