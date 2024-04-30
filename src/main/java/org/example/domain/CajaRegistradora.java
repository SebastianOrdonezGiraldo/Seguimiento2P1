package org.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CajaRegistradora implements Runnable, Serializable {
    private static int contadorCajas = 0;
    private int idCaja;
    private BlockingQueue<Cliente> colaClientes;
    private List<Cliente> clientesAtendidos;
    private double ventasTotal;

    public CajaRegistradora(BlockingQueue<Cliente> colaClientes) {
        this.idCaja = ++contadorCajas;
        this.colaClientes = colaClientes;
        this.clientesAtendidos = new ArrayList<>();
        this.ventasTotal = 0;
    }

    public void run() {
        while (true) {
            try {
                Cliente cliente = colaClientes.take();
                atenderCliente(cliente);
            } catch (InterruptedException e) {
                System.out.println("Error en la caja " + idCaja);
                e.printStackTrace();
            }
        }
    }
    private void atenderCliente(Cliente cliente) {
        try {
            double totalCompra = 0;
            for (Productos producto : cliente.getCarrito()) {
                Thread.sleep(100); // Simular tiempo de procesamiento
                totalCompra += calcularPrecio(producto); // Asignar precios aleatorios
            }
            ventasTotal += totalCompra;
            clientesAtendidos.add(cliente);
            System.out.println("Caja " + idCaja + ": Cliente atendido. Venta total: $" + totalCompra);
        } catch (InterruptedException e) {
            System.out.println("Error al atender al cliente en la caja " + idCaja);
            e.printStackTrace();
        }
    }

    private double calcularPrecio(Productos producto) {
        Random rand = new Random();
        switch (producto) {
            case LECHE:
                return 2.5 + rand.nextDouble() * 0.5;
            case PAN:
                return 1.0 + rand.nextDouble() * 0.5;
            case HUEVOS:
                return 3.0 + rand.nextDouble();
            case CARNE:
                return 10.0 + rand.nextDouble() * 5.0;
            case VERDURAS:
                return 2.0 + rand.nextDouble();
            default:
                return 0.0;
        }
    }
    public void actualizarVentasTotal(double montoVenta) {
        ventasTotal += montoVenta;
    }
    public int getClientesAtendidos() {
        return clientesAtendidos.size();
    }


    public double getVentasTotal() {
        return ventasTotal;
    }
}
