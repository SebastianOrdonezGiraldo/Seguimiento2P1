package org.example.infraestructure.repository;

import org.example.domain.Cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ClienteRepository {
    private static final String CLIENT_FILE_PATH = "clientes.dat";

    public void guardarClientesAtendidos(List<Cliente> clientes) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(CLIENT_FILE_PATH))) {
            outputStream.writeObject(clientes);
        }
    }

    public List<Cliente> cargarClientesAtendidos() {
        // Implementación para cargar clientes atendidos si es necesario
        return null;
    }
}
