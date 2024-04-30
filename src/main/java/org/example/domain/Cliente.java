package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente {
    private List<Productos> carrito;
    private long tiempoLlegada;

public Cliente() {
    carrito = new ArrayList<Productos>();
    tiempoLlegada = System.currentTimeMillis();
    generarCarrito();
}

private void generarCarrito() {
    Random rand  = new Random();
    int numProductos = rand.nextInt(6) + 5;
    for (int i = 0; i < numProductos; i++) {
        carrito.add(Productos.values()[rand.nextInt(Productos.values().length)]);
    }
    }
    public List<Productos> getCarrito() {
        return carrito;
    }

    public long getTiempoLlegada() {
        return tiempoLlegada;
    }
}
