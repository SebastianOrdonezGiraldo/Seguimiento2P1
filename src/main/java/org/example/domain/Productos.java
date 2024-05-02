package org.example.domain;

public enum Productos {
    LECHE("Leche", 2.5),
    PAN("Pan", 1.0),
    HUEVOS("Huevos", 3.0),
    CARNE("Carne", 10.0),
    VERDURAS("Verduras", 2.0);

    private String nombre;
    private double precio;

    Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
