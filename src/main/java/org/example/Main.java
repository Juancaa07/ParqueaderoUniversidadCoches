package org.example;

import org.example.dao.*;
import org.example.model.Persona;
import org.example.model.Vehiculo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PersonaDAO personaDAO = new PersonaDAOImpl();
        VehiculoDAO vehiculoDAO = new VehiculoDAOImpl();
        ActivosVehiculoDAO activosDAO = new ActivosVehiculoDAOImpl();

        int opcion;

        do {

            System.out.println("............ SISTEMA MATRICULAS ............");
            System.out.println("1. Registrar Persona ");
            System.out.println("2. Ver Personas ");
            System.out.println("3. Registrar Vehiculo ");
            System.out.println("4. Ver Vehiculos registrados ");
            System.out.println("5. Entrada Vehiculo ");
            System.out.println("6. Salida Vehiculo ");
            System.out.println("7. Ver Vehiculos Dentro ");
            System.out.println("8. Salir ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.println("Documento: ");
                    String documento = sc.nextLine();

                    Persona persona = new Persona(
                            id,
                            nombre,
                            apellido,
                            documento
                    );

                    personaDAO.insertar(persona);

                    break;

                case 2:

                    for (Persona p : personaDAO.obtenerTodos()) {
                        System.out.println(p);
                    }

                    break;

                case 3:

                    System.out.println("Placa: ");
                    String placa = sc.nextLine();
                    System.out.println("Tipo Vehiculo: " );
                    String tipo = sc.nextLine();
                    System.out.println("ID Persona: ");
                    int personaId = sc.nextInt();

                    Vehiculo vehiculo = new Vehiculo(
                            placa,
                            tipo,
                            personaId
                    );

                    vehiculoDAO.insertar(vehiculo);

                    break;

                case 4:

                    for (Vehiculo v : vehiculoDAO.obtenerTodos()) {
                        System.out.println(v);
                    }

                    break;

                case 5:

                    System.out.println("Placa ingreso: ");
                    String placaIngreso = sc.nextLine();
                    activosDAO.entradaVehiculo(placaIngreso);

                    break;

                case 6:

                    System.out.println("Placa salida: ");
                    String placaSalida = sc.nextLine();
                    activosDAO.salidaVehiculo(placaSalida);

                    break;

                case 7:

                    activosDAO.mostrarVehiculosDentro();

                    break;

                case 8:

                    System.out.println("Saliendo.....");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 8);

        sc.close();
    }
}