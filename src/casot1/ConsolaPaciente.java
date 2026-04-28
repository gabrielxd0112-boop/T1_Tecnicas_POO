/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casot1;

import java.util.Scanner;

/**
 *
 * @author UCC20432
 */
public class ConsolaPaciente {
     private Scanner scanner;

    public ConsolaPaciente() {
        scanner = new Scanner(System.in);
    }

    public Paciente leerPaciente() {

        Paciente p = new Paciente();

        System.out.print("Ingrese ID del paciente: ");
        p.setIdPaciente(leerEntero());

        System.out.print("Ingrese nombre completo: ");
        p.setNombreCompleto(scanner.nextLine());
        
         System.out.print("Ingrese tipo de documento (DNI/CARNET/PASAPORTE): ");
        p.setTipoDocumento(scanner.nextLine());

        System.out.print("Ingrese número de documento: ");
        p.setNumeroDocumento(scanner.nextLine());

        System.out.print("Ingrese fecha de nacimiento (Ejm: 01/07/2007): ");
        p.setFechaNacimiento(scanner.nextLine());

        System.out.print("Ingrese tipo de sangre (ej: O+, A-, AB+): ");
        p.setTipoSangre(scanner.nextLine());

        System.out.print("Ingrese teléfono (9 dígitos): ");
        p.setTelefono(scanner.nextLine());

        System.out.print("Ingrese correo: ");
        p.setCorreo(scanner.nextLine());

        leerAlergias(p);

        return p;
    }
    public void leerAlergias(Paciente p) {

        System.out.println("Ingrese alergias O si no tiene coloque NINGUNA y (escriba FIN para terminar):");

        while (true) {
            System.out.print("Alergia: ");
            String alergia = scanner.nextLine();

            if (alergia.equalsIgnoreCase("FIN")) {
                break;
            }

            p.agregarAlergia(alergia);
        }
    }
    public int leerEntero() {
        while (true) {
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                return numero;
            } catch (NumberFormatException e) {
                System.out.print("Error: debe ingresar un número entero. Intente otra vez: ");
            }
        }
    }
    
}
