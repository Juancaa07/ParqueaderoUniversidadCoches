package org.example.dao;
import org.example.model.coche;
import java.util.List;

public interface cocheDAO {

    void insertar(coche coche);
    void editar(coche coche);
    void eliminar(String matricula);

    coche buscarPorMatricula(String matricula);

    List<coche> obtenerTodos();

}
