package org.example.aplication;

import org.example.aplication.service.CajaRegistradoraServicioImpl;
import org.example.aplication.service.ClienteServicioImpl;
import org.example.domain.Cliente;
import org.example.domain.CajaRegistradora;
import org.example.infraestructure.repository.ClienteRepository;
import org.example.infraestructure.repository.ProductoRepositorioImpl;
import org.example.interfaces.CajaRegistradoraServicio;
import org.example.interfaces.ClienteServicio;
import org.example.interfaces.ProductoRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private static final int NUM_CAJAS = 3;
    private static final int NUM_CLIENTES = 20;
    private static BlockingQueue<Cliente> colaClientes = new LinkedBlockingQueue<>();
    private static ProductoRepository productoRepositorio = new ProductoRepositorioImpl();
    private static ClienteServicio clienteServicio = new ClienteServicioImpl(new ProductoRepositorioImpl());
    private static ClienteRepository clienteRepositorio = new ClienteRepository();
    private static List<CajaRegistradoraServicio> cajas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static List<CajaRegistradoraServicio> cajas2 = new ArrayList<>();

    public static void main(String[] args) {
        CajaRegistradoraServicioImpl cajaServicio = new CajaRegistradoraServicioImpl(colaClientes, productoRepositorio);
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            ejecutarOpcion(opcion);
        } while (opcion != 3);
    }

    private static void mostrarMenu() {
        System.out.println("===== Supermercado =====");
        System.out.println("1. Iniciar simulación");
        System.out.println("2. Mostrar estadísticas");
        System.out.println("3. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                inicializarCajas();
                generarClientes();
                iniciarSimulacion();
                break;
            case 2:
                mostrarEstadisticas();
                break;
            case 3:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    private static void inicializarCajas() {
        for (int i = 0; i < NUM_CAJAS; i++) {
            CajaRegistradoraServicio caja = new CajaRegistradoraServicioImpl(colaClientes, productoRepositorio);
            cajas.add(caja);
            caja.iniciar();
        }
    }



    private static void generarClientes() {
        for (int i = 0; i < NUM_CLIENTES; i++) {
            colaClientes.add(clienteServicio.crearCliente());
        }
    }

    private static void iniciarSimulacion() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("datos.dat"))) {
            objectOutputStream.writeObject(clienteRepositorio.cargarClientesAtendidos());

        } catch (IOException e) {
            System.out.println("Error al guardar los datos en datos.dat: " + e.getMessage());
        }
    }




    private static void mostrarEstadisticas() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("datos.dat"));
            List<Cliente> clientesAtendidos = (List<Cliente>) objectInputStream.readObject();
            if (clientesAtendidos != null && !clientesAtendidos.isEmpty()) {
                double ventasTotal = 0;
                int clientesTotales = clientesAtendidos.size();
                for (Cliente cliente : clientesAtendidos) {
                    ventasTotal += cliente.getTotalCompra();
                }
                System.out.println("Clientes atendidos: " + clientesTotales);
                System.out.println("Ventas totales: $" + ventasTotal);
            } else {
                System.out.println("El archivo datos.dat no contiene datos válidos para mostrar estadísticas.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo datos.dat no fue encontrado. No hay estadísticas para mostrar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar las estadísticas desde datos.dat: " + e.getMessage());
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el flujo de entrada: " + e.getMessage());
            }
        }
    }
    }





