package org.example.aplication.service;

import org.example.domain.CajaRegistradora;
import org.example.domain.Cliente;
import org.example.domain.Productos;
import org.example.interfaces.CajaRegistradoraServicio;
import org.example.interfaces.ProductoRepository;

import java.util.concurrent.BlockingQueue;

public class CajaRegistradoraServicioImpl implements CajaRegistradoraServicio {
    private ProductoRepository productoRepository;
    private CajaRegistradora caja;
    private double totalCompra;



    public CajaRegistradoraServicioImpl(BlockingQueue<Cliente> colaClientes, ProductoRepository productoRepositorio) {
        if (colaClientes == null) {
            System.out.println("La cola de clientes es nula.");
        } else if (productoRepositorio == null) {
            System.out.println("El repositorio de productos es nulo.");
        } else {
            this.caja = new CajaRegistradora(colaClientes, productoRepositorio);
        }
    }

    @Override
    public void atenderCliente(Cliente cliente) {

        totalCompra = 0;

        System.out.println("Caja registradora está iniciando su atención a clientes.");
        System.out.println("Caja registradora número " + caja.getId() + " atendiendo a cliente " + cliente.getId() + ", productos del cliente:");
        for (Productos producto : cliente.getCarrito()) {
            double precioProducto = productoRepository.obtenerPrecio(producto);
            totalCompra += precioProducto;
            System.out.println("\t" + producto.getNombre() + "($" + precioProducto + ")");
            // Simular tiempo de procesamiento
            try {
                Thread.sleep(500); // 500 milisegundos (0.5 segundos) de tiempo de procesamiento por producto
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
        if (caja != null) {
            Thread thread = new Thread(caja);
            thread.start();
        } else {
            System.out.println("La caja registradora no ha sido inicializada correctamente.");
        }
    }


    @Override
    public void detener() {
        System.out.println("La caja registradora ha detenido su atención a clientes.");

    }


}
