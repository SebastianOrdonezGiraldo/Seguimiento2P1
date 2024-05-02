package org.example.infraestructure.repository;

import org.example.domain.Cliente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static final String ARCHIVO_CLIENTES = "clientes.dat";

    public void guardarClientesAtendidos(List<Cliente> clientesAtendidos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CLIENTES))) {
            outputStream.writeObject(clientesAtendidos);
        } catch (IOException e) {
            System.out.println("Error al guardar clientes atendidos: " + e.getMessage());
        }
    }

    public List<Cliente> cargarClientesAtendidos() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARCHIVO_CLIENTES))) {
            return (List<Cliente>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar clientes atendidos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}