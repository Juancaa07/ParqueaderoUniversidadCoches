package org.example.dao;

import org.example.model.Vehiculo;
import java.util.List;

public interface VehiculoDAO {

    void insertar(Vehiculo vehiculo);
    void editar(Vehiculo vehiculo);
    void eliminar(String placa);

    Vehiculo buscarPorPlaca(String placa);

    List<Vehiculo> obtenerTodos();
}
