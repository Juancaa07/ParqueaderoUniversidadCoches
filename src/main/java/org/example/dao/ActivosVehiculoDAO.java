package org.example.dao;
public interface ActivosVehiculoDAO {

    void entradaVehiculo(String placa);
    void salidaVehiculo(String placa);
    void mostrarVehiculosDentro();
}
