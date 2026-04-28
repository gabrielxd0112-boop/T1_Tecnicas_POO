/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casot1;

import java.util.ArrayList;

/**
 *
 * @author UCC20432
 */
public class PacienteControlador {

    private ArrayList<Paciente> listaPacientes;
    public PacienteControlador() {
        listaPacientes = new ArrayList<>();
    }
    public void agregarPaciente(Paciente p) {
        listaPacientes.add(p);
    }
    public void listarPacientes() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        System.out.println("========= LISTA DE PACIENTES =========");

        for (Paciente p : listaPacientes) {
            System.out.println("----------------------------------");
            System.out.println(p.toString());
        }
    }
    public Paciente buscarPorDocumento(String numeroDocumento) {
        for (Paciente p : listaPacientes) {
            if (p.getNumeroDocumento().equals(numeroDocumento)) {
                return p;
            }
        }
        return null;
    }
    public boolean existeDocumento(String numeroDocumento) {
        return buscarPorDocumento(numeroDocumento) != null;
    }
    public int cantidadPacientes() {
        return listaPacientes.size();
    }
}
