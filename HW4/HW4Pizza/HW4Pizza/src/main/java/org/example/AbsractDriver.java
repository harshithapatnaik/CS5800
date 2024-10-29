package org.example;

import org.example.enums.PizzaChainName;
import org.example.enums.PizzaSize;

/**
 *
 * @author harshitha
 */
public abstract class AbsractDriver implements PizzaChain {
    public static class PizzaHut implements PizzaChain {

        public PizzaHut(){

        }

        @Override
        public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
            return new Pizza.PizzaBuilder(size, PizzaChainName.PIZZA_HUT);
        }
    }

    public static class Dominos implements PizzaChain {

        public Dominos() {

        }

        @Override
        public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
            return new Pizza.PizzaBuilder(size, PizzaChainName.DOMINOS);
        }
    }

    public static class LittleCaesars implements PizzaChain {

        public LittleCaesars(){

        }

        @Override
        public Pizza.PizzaBuilder pizzaBuilder(PizzaSize size) {
            return new Pizza.PizzaBuilder(size, PizzaChainName.LITTLE_CAESARS);
        }
    }

}