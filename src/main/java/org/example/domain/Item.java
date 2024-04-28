package org.example.domain;

import java.io.Serializable;
import java.util.Random;

public class Item implements Serializable {
    private String name;
    private double price;
    private ItemType type;

    public Item(String name, double price, ItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public static Item generateRandomItem() {
        Random random = new Random();
        String[] itemNames = { "Leche", "Camiseta", "Teléfono", /* ... */ };
        double[] itemPrices = { 2.5, 15.0, 300.0, /* ... */ };
        ItemType[] itemTypes = ItemType.values();

        int randomIndex = random.nextInt(itemNames.length);
        return new Item(itemNames[randomIndex], itemPrices[randomIndex], itemTypes[random.nextInt(itemTypes.length)]);
    }
}
