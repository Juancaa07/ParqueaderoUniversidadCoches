package org.example.model;

import java.sql.Timestamp;

public class ActivosVehiculo {

    private String placa;
    private Timestamp horaEntrada;

    public ActivosVehiculo() {
    }

    public ActivosVehiculo(String placa, Timestamp horaEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    
}
