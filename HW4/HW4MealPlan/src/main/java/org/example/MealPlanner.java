package org.example;

import org.example.enums.*;
import org.example.factory.dietPlans.*;
import org.example.factory.Macronutrients;
import org.example.model.Customer;
import org.example.model.Meal;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MealPlanner {

    private final Random random;

    public MealPlanner() {
        this.random = new Random();
    }

    public Meal generateMealForCustomer(Customer customer) {
        DietPlan dietPlan = customer.getDietPlan();
        Macronutrients factory = getFactoryForDiet(dietPlan);

        if (factory == null) {
            System.out.println("No suitable diet plan found for " + customer.getName());
            return null;
        }

        List<Carbs> carbs = factory.createCarbs();
        List<Protein> protein = factory.createProtein();
        List<Fats> fats = factory.createFats();

        // If any of the food groups are empty, return null
        if (carbs.isEmpty() || protein.isEmpty() || fats.isEmpty()) {
            return null;
        }

        List<Carbs> selectedCarbList = Collections.singletonList((Carbs) getRandomItem(carbs));
        List<Protein> selectedProteinList = Collections.singletonList((Protein) getRandomItem(protein));
        List<Fats> selectedFatList = Collections.singletonList((Fats) getRandomItem(fats));

        return new Meal(selectedCarbList, selectedProteinList, selectedFatList);
    }

    public Macronutrients getFactoryForDiet(DietPlan dietPlan) {
        if (dietPlan == null) {
            System.out.println("No diet plan provided.");
            return null;
        }
        switch (dietPlan) {
            case NO_RESTRICTION -> {
                return NoRestriction.getInstance();
            }
            case PALEO -> {
                return Paleo.getInstance();
            }
            case VEGAN -> {
                return Vegan.getInstance();
            }
            case NUT_ALLERGY -> {
                return NutAllergy.getInstance();
            }
            default -> {
                return null;
            }
        }
    }

    private Object getRandomItem(List<?> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

    private void displayMeal(Customer customer, Meal meal) {
        if (meal != null) {
            System.out.println("--------------------------------");
            System.out.println("Meal for " + customer.getName() + ":");
            System.out.println("    Meal type: "+ customer.getDietPlan());
            System.out.println("        Carbs: " + meal.getCarbs());
            System.out.println("        Protein: " + meal.getProtein());
            System.out.println("        Fats: " + meal.getFats());
        } else {
            System.out.println("Unable to generate a meal for " + customer.getName());
        }
    }

    public void generateAndDisplayMeal(Customer customer) {
        // Generate a meal for the customer
        Meal meal = this.generateMealForCustomer(customer);

        // Display the generated meal
        this.displayMeal(customer, meal);
    }
}