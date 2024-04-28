package org.example.domain;

public class CashRegister {
    private int registerId;
    private int customersServed;
    private double totalSales;

    public CashRegister(int registerId, int customersServed, double totalSales) {
        this.registerId = registerId;
        this.customersServed = customersServed;
        this.totalSales = totalSales;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public int getCustomersServed() {
        return customersServed;
    }

    public void setCustomersServed(int customersServed) {
        this.customersServed = customersServed;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public synchronized void serveCustomer(Customer customer, double purchaseAmount) {
        customersServed++;
        totalSales += purchaseAmount;
        System.out.println("Cajero " + registerId + " atendió al cliente " + customer.getCustomerId());
    }
}
