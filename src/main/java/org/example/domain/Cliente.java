package org.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cliente implements Serializable {
    private List<Productos> carrito;
    private long tiempoLlegada;
    private double totalCompra;

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
    public void setCarrito(List<Productos> carrito) {
        this.carrito = carrito;
    }
    public void setTiempoLlegada(long tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }
    public double getTotalCompra() {
        double total = 0;
        for (Productos producto : carrito) {
            total += producto.getPrecio(); // Suponiendo que Productos tiene un método getPrecio()
        }
        return total;
    }


}
