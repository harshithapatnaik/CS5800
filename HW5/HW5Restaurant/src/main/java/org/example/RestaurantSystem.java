package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RestaurantSystem {
    private final Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(String name, double discountRate) {
        customers.put(name, new Customer(name, discountRate));
    }

    public void addItemToCustomerOrder(String customerName, FoodItem item) {
        Customer customer = customers.get(customerName);
        if (customer != null) {
            customer.addItemToOrder(item);
        } else {
            System.out.println("Customer not found!");
        }
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
