package org.example;

import org.example.AbsractDriver.*;
import org.example.enums.PizzaSize;
import org.example.enums.PizzaTopping;

/**
 *
 * @author harshitha
 */
public class Main {

    public static void main(String[] args) {

        // Q1.1 -> Create a driver program to create three pizzas
        // one of each size with 3, 6, and 9 toppings to your liking and eat() all of them
        pizzaHutWithAllSizes(new PizzaHut());

        //Q1.2 -> Create the following pizzas and eat() all of them:
        //Pizza Hut - Large pizza with 3 toppings, Small pizza with 2 toppings
        //Little Caesars - Medium pizza with 8 toppings, Small pizza with 6 toppings
        //Dominos - Small pizza with 1 topping, Large pizza with 3 toppings

        pizzaHutWithSmallAndLargeSizes(new PizzaHut());
        littleCaesarsWithSmallAndMediumSizes(new LittleCaesars());
        dominosWithSmallAndLarge(new Dominos());
    }

    static void dominosWithSmallAndLarge(PizzaChain dominos) {
        Pizza smallPizza = dominos.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.CHICKEN)
                .build();

        Pizza largePizza = dominos.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.BACON)
                .addTopping(PizzaTopping.TOMATO_AND_BASIL)
                .build();

        smallPizza.eat();
        largePizza.eat();
    }

    static void littleCaesarsWithSmallAndMediumSizes(PizzaChain littleCaesars) {
        Pizza mediumPizza = littleCaesars.pizzaBuilder(PizzaSize.MEDIUM)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.TOMATO_AND_BASIL)
                .addTopping(PizzaTopping.PEPPERONI)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.HAM)
                .addTopping(PizzaTopping.SPINACH)
                .addTopping(PizzaTopping.ONIONS)
                .build();

        Pizza smallPizza = littleCaesars.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.TOMATO_AND_BASIL)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.PEPPERONI)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.HAM)
                .build();

        mediumPizza.eat();
        smallPizza.eat();
    }


    static void pizzaHutWithSmallAndLargeSizes(PizzaChain pizzaHut) {
        Pizza smallPizza = pizzaHut.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.ONIONS)
                .build();

        Pizza largePizza = pizzaHut.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.TOMATO_AND_BASIL)
                .addTopping(PizzaTopping.PEPPERONI)
                .addTopping(PizzaTopping.SAUSAGE)
                .build();

        largePizza.eat();
        smallPizza.eat();
    }

    public static void pizzaHutWithAllSizes(PizzaChain pizzaHut){

        Pizza smallPizza = pizzaHut.pizzaBuilder(PizzaSize.SMALL)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.PEPPERS)
                .build();

        Pizza mediumPizza = pizzaHut.pizzaBuilder(PizzaSize.MEDIUM)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.TOMATO_AND_BASIL)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.PEPPERONI)
                .addTopping(PizzaTopping.ONIONS)
                .addTopping(PizzaTopping.HAM)
                .build();

        Pizza largePizza = pizzaHut.pizzaBuilder(PizzaSize.LARGE)
                .addTopping(PizzaTopping.CHICKEN)
                .addTopping(PizzaTopping.EXTRA_CHEESE)
                .addTopping(PizzaTopping.TOMATO_AND_BASIL)
                .addTopping(PizzaTopping.PEPPERONI)
                .addTopping(PizzaTopping.OLIVES)
                .addTopping(PizzaTopping.HAM)
                .addTopping(PizzaTopping.SPINACH)
                .addTopping(PizzaTopping.SPICY_PORK)
                .addTopping(PizzaTopping.ONIONS)
                .build();

        smallPizza.eat();
        mediumPizza.eat();
        largePizza.eat();
    }
}