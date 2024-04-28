package org.example.domain;

import java.util.List;
import java.util.Random;

public class Customer implements Runnable{
    private int customerId;
    private List<Item> shoppingCart;
    private CashRegister cashRegister;

    public Customer(int customerId, List<Item> shoppingCart) {
        this.customerId = customerId;
        this.shoppingCart = shoppingCart;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Item> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void run() {
        double totalPurchase = 0.0;

        for (Item item : shoppingCart) {
            double itemPrice = item.getPrice();
            totalPurchase += itemPrice;

            try {
                Thread.sleep(getRandomProcessingTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cashRegister.serveCustomer(this, totalPurchase);
    }
    private long getRandomProcessingTime() {
        Random random = new Random();
        return random.nextInt(2000) + 1000; // Entre 1 y 3 segundos
    }
}
