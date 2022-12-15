package com.grupo2bbva.ecommerce.dtos;

public class TicketDTOApplication {
    private String numeroTarjeta;
    private int cantCuotas;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public TicketDTOApplication() {}

    public TicketDTOApplication(String numeroTarjeta, int cantCuotas) {
        this.numeroTarjeta = numeroTarjeta;
        this.cantCuotas = cantCuotas;
    }
}
