package org.example.aplication.service;

import org.example.domain.Cliente;
import org.example.domain.CajaRegistradora;
import org.example.domain.Productos;
import org.example.interfaces.CajaRegistradoraServicio;
import org.example.interfaces.ProductoRepository;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CajaRegistradoraServicioImpl implements CajaRegistradoraServicio {
    private ProductoRepository productoRepository;
    private BlockingQueue<Cliente> colaClientes;
    private CajaRegistradora caja;

    public CajaRegistradoraServicioImpl(BlockingQueue<Cliente> colaClientes, ProductoRepository productoRepository) {
        this.colaClientes = colaClientes;
        this.productoRepository = productoRepository;
    }
    @Override
    public void atenderCliente(Cliente cliente) {
        double totalCompra = 0;
        for (Productos producto : cliente.getCarrito()) {
            double precioProducto = productoRepository.obtenerPrecio(producto);
            totalCompra += precioProducto;
            System.out.println("Atendiendo producto: " + producto + ", Precio: $" + precioProducto);
            // Simular tiempo de procesamiento
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total de la compra: $" + totalCompra);
        caja.actualizarVentasTotal(totalCompra);
    }

    @Override
    public int getClientesAtendidos() {
        return 0;
    }

    @Override
    public double getVentasTotal() {
        return 0;
    }

    public void setCaja(CajaRegistradora caja) {
        this.caja = caja;
    }


    @Override
    public void iniciar() {
        System.out.println("La caja registradora está iniciando su atención a clientes.");


    }

    @Override
    public void detener() {
        System.out.println("La caja registradora ha detenido su atención a clientes.");

    }

}
