package org.example;

import org.example.dao.*;
import org.example.model.Persona;
import org.example.model.coche;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PersonaDAO personaDAO = new PersonaDAOImpl();
        cocheDAO cocheDAO = new cocheDAOImpl();

        int menuPrincipal;

        do {

            System.out.println("........... MENU PRINCIPAL ..............");
            System.out.println("1. Menu Persona ");
            System.out.println("2. Menu Coche ");
            System.out.println("3. Salir ");

            menuPrincipal = sc.nextInt();
            sc.nextLine();

            switch (menuPrincipal) {

                case 1:

                    int opcionPersona;

                    do {

                        System.out.println("................. MENU PERSONA ................");
                        System.out.println("1. Registrar ");
                        System.out.println("2. Editar ");
                        System.out.println("3. Eliminar" );
                        System.out.println("4. Buscar ");
                        System.out.println("5. Listar todas ");
                        System.out.println("6. Volver ");

                        opcionPersona = sc.nextInt();
                        sc.nextLine();

                        switch (opcionPersona) {

                            case 1:

                                System.out.println("ID: ");
                                int id = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Nombre: ");
                                String nombre = sc.nextLine();

                                System.out.println("Apellido1: ");
                                String apellido1 = sc.nextLine();

                                System.out.println("Apellido2: ");
                                String apellido2 = sc.nextLine();

                                System.out.println("DNI: ");
                                String dni = sc.nextLine();

                                Persona nueva = new Persona(
                                        id,
                                        nombre,
                                        apellido1,
                                        apellido2,
                                        dni
                                );

                                personaDAO.insertar(nueva);
                                break;

                            case 2:

                                System.out.println("ID a editar: ");
                                int idEditar = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Nuevo nombre: ");
                                String nuevoNombre = sc.nextLine();

                                System.out.println("Nuevo apellido1: ");
                                String nuevoApellido1 = sc.nextLine();

                                System.out.println("Nuevo apellido2: ");
                                String nuevoApellido2 = sc.nextLine();

                                System.out.println("Nuevo DNI: " );
                                String nuevoDni = sc.nextLine();

                                Persona editada = new Persona(
                                        idEditar,
                                        nuevoNombre,
                                        nuevoApellido1,
                                        nuevoApellido2,
                                        nuevoDni
                                );

                                personaDAO.editar(editada);
                                break;

                            case 3:

                                System.out.println("ID a eliminar: ");
                                int eliminar = sc.nextInt();

                                personaDAO.eliminar(eliminar);
                                break;

                            case 4:

                                System.out.println("ID a buscar: ");
                                int buscar = sc.nextInt();

                                Persona encontrada = personaDAO.buscarPorId(buscar);

                                if (encontrada != null) {
                                    System.out.println(encontrada);
                                } else {
                                    System.out.println("Persona no encontrada ");
                                }
                                break;

                            case 5:

                                List<Persona> personas = personaDAO.obtenerTodos();

                                for (Persona p : personas) {
                                    System.out.println(p);
                                }
                                break;

                            case 6:
                                System.out.println("Volviendo...");
                                break;

                            default:
                                System.out.println("Opcion invalida");
                        }

                    } while (opcionPersona != 6);
                    break;

                case 2:

                    int opcionCoche;

                    do {

                        System.out.println("................. MENU COCHE ................");
                        System.out.println("1. Registrar");
                        System.out.println("2. Editar");
                        System.out.println("3. Eliminar");
                        System.out.println("4. Buscar");
                        System.out.println("5. Listar todos");
                        System.out.println("6. Volver");

                        opcionCoche = sc.nextInt();
                        sc.nextLine();

                        switch (opcionCoche) {

                            case 1:

                                System.out.println("Matricula: ");
                                String matricula = sc.nextLine();

                                System.out.println("Marca: ");
                                String marca = sc.nextLine();

                                System.out.println("Modelo: ");
                                String modelo = sc.nextLine();

                                System.out.println("Caballos: ");
                                int caballos = sc.nextInt();

                                System.out.println("ID Persona: ");
                                int personaid = sc.nextInt();

                                coche nuevoCoche = new coche(
                                        matricula,
                                        marca,
                                        modelo,
                                        caballos,
                                        personaid
                                );

                                cocheDAO.insertar(nuevoCoche);

                                break;

                            case 2:

                                System.out.println("Matricula a editar: ");
                                String matEditar = sc.nextLine();

                                System.out.println("Nueva marca: ");
                                String nuevaMarca = sc.nextLine();

                                System.out.println("Nuevo modelo: ");
                                String nuevoModelo = sc.nextLine();

                                System.out.println("Nuevos caballos: ");
                                int nuevosCaballos = sc.nextInt();

                                System.out.println("Nuevo ID Persona: " );
                                int nuevoId = sc.nextInt();

                                coche cocheEditado = new coche(
                                        matEditar,
                                        nuevaMarca,
                                        nuevoModelo,
                                        nuevosCaballos,
                                        nuevoId
                                );

                                cocheDAO.editar(cocheEditado);

                                break;

                            case 3:

                                System.out.println("Matricula a eliminar: ");
                                String eliminarMat = sc.nextLine();

                                cocheDAO.eliminar(eliminarMat);
                                break;

                            case 4:

                                System.out.println("Matricula a buscar: ");
                                String buscarMat = sc.nextLine();
                                coche encontrado = cocheDAO.buscarPorMatricula(buscarMat);

                                if (encontrado != null) {
                                    System.out.println(encontrado);
                                } else {
                                    System.out.println("Coche no encontrado ");
                                }
                                break;

                            case 5:

                                List<coche> coches = cocheDAO.obtenerTodos();

                                for (coche c : coches) {
                                    System.out.println(c);
                                }
                                break;

                            case 6:
                                System.out.println("Volviendo.....");
                                break;

                            default:
                                System.out.println("Opcion invalida" );
                        }

                    } while (opcionCoche != 6);
                    break;

                case 3:

                    System.out.println("Saliendo.......");
                    break;

                default:

                    System.out.println("Opcion invalida ");
            }

        } while (menuPrincipal != 3);
    }
}