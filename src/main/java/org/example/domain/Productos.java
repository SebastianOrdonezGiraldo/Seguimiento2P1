package org.example.domain;

public enum Productos {
    LECHE(2.5),
    PAN(1.0),
    HUEVOS(3.0),
    CARNE(10.0),
    VERDURAS(2.0);

    private double precio;

    Productos(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}
