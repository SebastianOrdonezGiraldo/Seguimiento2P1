package org.example.aplication.service;

import org.example.domain.Cliente;
import org.example.domain.Productos;
import org.example.interfaces.ClienteServicio;
import org.example.interfaces.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteServicioImpl implements ClienteServicio {
    private ProductoRepository productoRepository;

    public ClienteServicioImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Cliente crearCliente() {
        Cliente cliente = new Cliente();
        llenarCarrito(cliente);
        return cliente;
    }

    @Override
    public double obtenerPrecio(Productos producto) {
        return 0;
    }

    private void llenarCarrito(Cliente cliente) {
        Random rand = new Random();
        int numProductos = rand.nextInt(6) + 5; // Entre 5 y 10 productos
        List<Productos> carrito = new ArrayList<>();
        for (int i = 0; i < numProductos; i++) {
            Productos producto = generarProductoAleatorio();
            carrito.add(producto);
        }
        cliente.setCarrito(carrito);
    }

    private Productos generarProductoAleatorio() {
        Random rand = new Random();
        return Productos.values()[rand.nextInt(Productos.values().length)];
    }
}
