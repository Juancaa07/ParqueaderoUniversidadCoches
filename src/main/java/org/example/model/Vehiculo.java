package org.example.model;

public class Vehiculo {

    private String placa;
    private String tipoVehiculo;
    private int personaId;

    public Vehiculo() {
    }


    public Vehiculo(String placa, String tipoVehiculo, int personaId) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.personaId = personaId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", personaId=" + personaId +
                '}';
    }

}