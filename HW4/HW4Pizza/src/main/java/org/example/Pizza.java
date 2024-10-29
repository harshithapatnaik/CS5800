package org.example;

import org.example.enums.PizzaChainName;
import org.example.enums.PizzaSize;
import org.example.enums.PizzaTopping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Pizza {

    final List<PizzaTopping> pizzaToppings;
    final PizzaSize pizzaSize;
    final PizzaChainName pizzaChain;

    private Pizza(PizzaBuilder pizzaBuilder) {
        this.pizzaToppings = pizzaBuilder.pizzaToppings;
        this.pizzaSize = pizzaBuilder.pizzaSize;
        this.pizzaChain = pizzaBuilder.pizzaChain;
    }

    // Add getter methods
    public List<PizzaTopping> getPizzaToppings() {
        return pizzaToppings;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public PizzaChainName getPizzaChain() {
        return pizzaChain;
    }

    public void eat() {
        System.out.println("-----------------------------------");
        System.out.println("Pizza Chain : " + this.pizzaChain.name());
        System.out.println("Pizza Size  : " + this.pizzaSize.name());
        IntStream.rangeClosed(1, pizzaToppings.size()).forEach(index ->
                System.out.println("Pizza Topping " + index + " : " + this.pizzaToppings.get(index - 1).name()));
    }


    public static class PizzaBuilder {
        private List<PizzaTopping> pizzaToppings;
        private PizzaSize pizzaSize;
        private PizzaChainName pizzaChain;

        public PizzaBuilder(PizzaSize pizzaSize, PizzaChainName pizzaChain) {
            this.pizzaSize = pizzaSize;
            this.pizzaToppings = new ArrayList<>();
            this.pizzaChain = pizzaChain;
        }

        public PizzaBuilder addTopping(PizzaTopping pizzaTopping) {
            if (pizzaTopping != null) {
                this.pizzaToppings.add(pizzaTopping);
            }
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
