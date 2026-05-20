package org.example.dao;

import org.example.model.Vehiculo;
import org.example.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAOImpl implements VehiculoDAO {

    @Override
    public void insertar(Vehiculo vehiculo) {

        String sql = "INSERT INTO Vehiculo VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getTipoVehiculo());
            ps.setInt(3, vehiculo.getPersonaId());

            ps.executeUpdate();

            System.out.println("Vehiculo registrado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Vehiculo vehiculo) {

        String sql = "UPDATE Vehiculo SET tipoVehiculo=?, persona_id=? WHERE placa=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getTipoVehiculo());
            ps.setInt(2, vehiculo.getPersonaId());
            ps.setString(3, vehiculo.getPlaca());

            ps.executeUpdate();

            System.out.println("Vehiculo editado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String placa) {

        String sql = "DELETE FROM Vehiculo WHERE placa=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, placa);

            ps.executeUpdate();

            System.out.println("Vehiculo eliminado");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Vehiculo buscarPorPlaca(String placa) {

        String sql = "SELECT * FROM Vehiculo WHERE placa=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, placa);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Vehiculo(
                        rs.getString("placa"),
                        rs.getString("tipoVehiculo"),
                        rs.getInt("persona_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Vehiculo> obtenerTodos() {

        List<Vehiculo> lista = new ArrayList<>();

        String sql = "SELECT * FROM Vehiculo";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Vehiculo v = new Vehiculo(
                        rs.getString("placa"),
                        rs.getString("tipoVehiculo"),
                        rs.getInt("persona_id")
                );

                lista.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}