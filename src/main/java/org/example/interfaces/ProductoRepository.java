package org.example.interfaces;

import org.example.domain.Productos;

public interface ProductoRepository {
    double obtenerPrecio(Productos producto);
}
