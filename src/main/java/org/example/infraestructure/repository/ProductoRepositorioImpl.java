package org.example.infraestructure.repository;

import org.example.domain.Productos;
import org.example.interfaces.ProductoRepository;

import java.util.Random;

public class ProductoRepositorioImpl implements ProductoRepository {
    @Override
    public double obtenerPrecio(Productos producto) {
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
}
}
