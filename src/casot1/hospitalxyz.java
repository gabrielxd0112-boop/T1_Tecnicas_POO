/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casot1;

import java.util.Scanner;

/**
 *
 * @author UCC20432
 */
public class hospitalxyz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        PacienteControlador controlador = new PacienteControlador();
        ConsolaPaciente consola = new ConsolaPaciente();

        int opcion;

        do {
            System.out.println("\n ---------- HOSPITAL REGIONAL XYZ --------");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Buscar paciente por documento");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        try {
                            Paciente nuevo = consola.leerPaciente();
                            nuevo.validarPacienteCompleto();
                            if (controlador.existeDocumento(nuevo.getNumeroDocumento())) {
                                throw new ValidacionExcepcion("Ya existe un paciente con ese documento.");
                            }

                            controlador.agregarPaciente(nuevo);
                            System.out.println("Paciente registrado correctamente.");

                        } catch (ValidacionExcepcion e) {
                            System.out.println("ERROR: " + e.getMessage());
                        }
                        break;

                    case 2:
                        controlador.listarPacientes();
                        break;

                    case 3:
                        System.out.print("Ingrese número de documento a buscar: ");
                        String doc = sc.nextLine();

                        Paciente encontrado = controlador.buscarPorDocumento(doc);

                        if (encontrado == null) {
                            System.out.println("Paciente no encontrado.");
                        } else {
                            System.out.println("Paciente encontrado:");
                            System.out.println("----------------------------------");
                            System.out.println(encontrado.toString());
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                opcion = 0;
                System.out.println("Error: ingrese un número válido.");
            }

        } while (opcion != 4);
    
    }
}
