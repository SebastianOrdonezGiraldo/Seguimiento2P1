package org.example.interfaces;

import org.example.domain.Cliente;

public interface CajaRegistradoraServicio {
    void atenderCliente(Cliente cliente);
    int getClientesAtendidos();
    double getVentasTotal();
    void iniciar();
    void detener();
}
