package org.example.dao;

import org.example.model.coche;
import org.example.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cocheDAOImpl implements cocheDAO {

    @Override
    public void insertar(coche coche) {

        String sql = "INSERT INTO coche VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, coche.getMatricula());
            ps.setString(2, coche.getMarca());
            ps.setString(3, coche.getModelo());
            ps.setInt(4, coche.getCaballos());
            ps.setInt(5, coche.getPersonaid());
            ps.executeUpdate();

            System.out.println("Coche añadido correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(coche coche) {

        String sql = "UPDATE coche SET marca=?, modelo=?, caballos=?, personaid=? WHERE matricula=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, coche.getMarca());
            ps.setString(2, coche.getModelo());
            ps.setInt(3, coche.getCaballos());
            ps.setInt(4, coche.getPersonaid());
            ps.setString(5, coche.getMatricula());
            ps.executeUpdate();

            System.out.println("Coche editado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String matricula) {

        String sql = "DELETE FROM coche WHERE matricula=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, matricula);
            ps.executeUpdate();

            System.out.println("Coche eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public coche buscarPorMatricula(String matricula) {

        String sql = "SELECT * FROM coche WHERE matricula=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new coche(
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("caballos"),
                        rs.getInt("personaid")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<coche> obtenerTodos() {

        List<coche> lista = new ArrayList<>();

        String sql = "SELECT * FROM coche";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                coche c = new coche(
                        rs.getString("matricula"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("caballos"),
                        rs.getInt("personaid")
                );

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}