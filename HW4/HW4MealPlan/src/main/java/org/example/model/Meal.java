package org.example.model;

import org.example.enums.*;
import java.util.List;

public class Meal {
    private List<Carbs> carbs;
    private List<Protein> protein;
    private List<Fats> fats;

    public Meal(List<Carbs> carbs, List<Protein> protein, List<Fats> fats) {
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
    }

    public List<Carbs> getCarbs() {
        return carbs;
    }

    public void setCarbs(List<Carbs> carbs) {
        this.carbs = carbs;
    }

    public List<Protein> getProtein() {
        return protein;
    }

    public void setProtein(List<Protein> protein) {
        this.protein = protein;
    }

    public List<Fats> getFats() {
        return fats;
    }

    public void setFats(List<Fats> fats) {
        this.fats = fats;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "carbs=" + carbs +
                ", protein=" + protein +
                ", fats=" + fats +
                '}';
    }
}