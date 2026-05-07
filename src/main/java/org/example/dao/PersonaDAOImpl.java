package org.example.dao;

import org.example.model.Persona;
import org.example.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOImpl implements PersonaDAO {

    @Override
    public void insertar(Persona persona) {

        String sql = "INSERT INTO Persona VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, persona.getId());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido1());
            ps.setString(4, persona.getApellido2());
            ps.setString(5, persona.getDni());

            ps.executeUpdate();

            System.out.println("Persona añadida correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Persona persona) {

        String sql = "UPDATE Persona SET nombre=?, apellido1=?, apellido2=?, dni=? WHERE id=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido1());
            ps.setString(3, persona.getApellido2());
            ps.setString(4, persona.getDni());
            ps.setInt(5, persona.getId());
            ps.executeUpdate();

            System.out.println("Persona editada correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        String sql = "DELETE FROM Persona WHERE id=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Persona eliminada");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Persona buscarPorId(int id) {

        String sql = "SELECT * FROM Persona WHERE id=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("dni")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Persona> obtenerTodos() {

        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT * FROM Persona";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Persona p = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("dni")
                );

                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}