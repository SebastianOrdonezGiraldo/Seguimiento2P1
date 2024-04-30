package org.example.infraestructure.repository;

import org.example.domain.Cliente;

import java.io.*;
import java.util.List;

public class CustomerRepository {
    private static final String CUSTOMER_FILE_PATH = "customers.dat";

    public void saveCustomers(List<Cliente> clientes) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(CUSTOMER_FILE_PATH))) {
            outputStream.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> loadCustomers() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(CUSTOMER_FILE_PATH))) {
            return (List<Cliente>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
