package com.grupo2bbva.ecommerce.dtos;

public class TicketDTOApplication {
    private String numeroTarjeta;
    private int cantCuotas;
    private String direccionEntrega;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public TicketDTOApplication() {}

    public TicketDTOApplication(String numeroTarjeta, int cantCuotas, String direccionEntrega) {
        this.numeroTarjeta = numeroTarjeta;
        this.cantCuotas = cantCuotas;
        this.direccionEntrega = direccionEntrega;
    }
}
