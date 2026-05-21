package org.example.dao;

import org.example.util.ConexionBD;
import java.sql.*;

public class ActivosVehiculoDAOImpl implements ActivosVehiculoDAO {

    @Override
    public void entradaVehiculo(String placa) {

        String sql = "INSERT INTO ActivosVehiculo VALUES (?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, placa);

            ps.setTimestamp(2,
                    new Timestamp(System.currentTimeMillis()));

            ps.executeUpdate();

            System.out.println("Vehiculo ingresado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salidaVehiculo(String placa) {

        String sql = "DELETE FROM ActivosVehiculo WHERE placa=?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, placa);

            ps.executeUpdate();

            System.out.println("Vehiculo retirado");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mostrarVehiculosDentro() {

        String sql = """
                SELECT 
                v.placa,
                v.tipoVehiculo,
                p.nombre,
                p.apellido,
                p.documento,
                a.horaEntrada
                
                FROM ActivosVehiculo a
                
                JOIN Vehiculo v
                ON a.placa = v.placa
                
                JOIN Persona p
                ON v.persona_id = p.id
                """;

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                System.out.println(
                        "PLACA: " + rs.getString("placa") +
                                " | TIPO: " + rs.getString("tipoVehiculo") +
                                " | DUEÑO: " + rs.getString("nombre") +
                                " " + rs.getString("apellido") +
                                " | DOCUMENTO: " + rs.getString("documento") +
                                " | ENTRADA: " + rs.getTimestamp("horaEntrada")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
