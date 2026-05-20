package org.example.dao;

import org.example.model.Persona;
import java.util.List;

public interface PersonaDAO {

    void insertar(Persona persona);
    void editar(Persona persona);
    void eliminar(int id);

    Persona buscarPorId(int id);

    List<Persona> obtenerTodos();
}
