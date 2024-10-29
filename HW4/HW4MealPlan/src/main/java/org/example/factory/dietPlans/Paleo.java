package org.example.factory.dietPlans;

import org.example.enums.*;
import org.example.factory.Macronutrients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Paleo implements Macronutrients {
    private static final Paleo instance = new Paleo();

    private Paleo() {}

    public static Paleo getInstance() {
        return instance;
    }

    @Override
    public List<Carbs> createCarbs() {
        // Paleo diet restricts carbs to only Pistachio
        return Collections.singletonList(Carbs.PISTACHIO);
    }

    @Override
    public List<Protein> createProtein() {
        // Paleo diet allows all protein sources except Tofu
        List<Protein> allowedProteins = new ArrayList<>(Arrays.asList(Protein.values()));
        allowedProteins.remove(Protein.TOFU);
        return Collections.unmodifiableList(allowedProteins);
    }

    @Override
    public List<Fats> createFats() {
        // Paleo diet allow all fats except Sour Cream
        List<Fats> allowedFats = new ArrayList<>(Arrays.asList(Fats.values()));
        allowedFats.remove(Fats.SOUR_CREAM);
        return Collections.unmodifiableList(allowedFats);
    }
}