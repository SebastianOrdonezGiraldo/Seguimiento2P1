package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SuperMercado {
    private static final int NUM_CAJAS = 3;
    private static final int NUM_CLIENTES = 20;
    private static BlockingQueue<Cliente> colaClientes = new LinkedBlockingQueue<>();
    private static List<CajaRegistradora> cajas = new ArrayList<>();

}
