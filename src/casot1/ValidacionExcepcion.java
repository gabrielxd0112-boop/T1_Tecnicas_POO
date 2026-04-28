/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casot1;

/**
 *
 * @author UCC20432
 */
public class ValidacionExcepcion extends Exception {

    public ValidacionExcepcion() {
        super("Error de validación.");
    }

    public ValidacionExcepcion(String mensaje) {
        super(mensaje);
    }
}
