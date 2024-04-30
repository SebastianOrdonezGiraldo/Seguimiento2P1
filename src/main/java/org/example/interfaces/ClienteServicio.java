package org.example.interfaces;

import org.example.domain.Cliente;
import org.example.domain.Productos;

public interface ClienteServicio {
    Cliente crearCliente();
    double obtenerPrecio(Productos producto);
}
