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
public class Paciente {
    private int idPaciente;
    private String nombreCompleto;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String tipoSangre;
    private String telefono;
    private String correo;
    private ArrayList<String> alergias;

    public Paciente() {
        alergias =new ArrayList<>();
    }

    public Paciente(String nombreCompleto, String tipoDocumento, String numeroDocumento, ArrayList<String> alergias) {
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.alergias = alergias;
    }

    public Paciente(int idPaciente, String nombreCompleto, String tipoDocumento, String numeroDocumento, String fechaNacimiento, String tipoSangre, String telefono, String correo, ArrayList<String> alergias) {
        this.idPaciente = idPaciente;
        this.nombreCompleto = nombreCompleto;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.telefono = telefono;
        this.correo = correo;
        this.alergias = alergias;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }
    public void agregarAlergia(String alergia) {
        if (alergia != null && !alergia.trim().isEmpty()) {
            alergias.add(alergia);
        }
    }

    public String listarAlergias() {
        if (alergias.isEmpty()) {
            return "Ninguna";
        }

        String texto = "";
        for (String a : alergias) {
            texto += a + ", ";
        }

        return texto.substring(0, texto.length() - 2);
    }
     public void validarDocumento() throws ValidacionExcepcion {

        if (tipoDocumento == null || tipoDocumento.trim().isEmpty()) {
            throw new ValidacionExcepcion("El tipo de documento no puede estar vacío.");
        }

        if (numeroDocumento == null || numeroDocumento.trim().isEmpty()) {
            throw new ValidacionExcepcion("El número de documento no puede estar vacío.");
        }

        if (tipoDocumento.equalsIgnoreCase("DNI")) {
            if (!numeroDocumento.matches("\\d{8}")) {
                throw new ValidacionExcepcion("El DNI debe tener exactamente 8 dígitos.");
            }
        } else if (tipoDocumento.equalsIgnoreCase("CARNET")) {
            if (numeroDocumento.length() < 9 || numeroDocumento.length() > 12) {
                throw new ValidacionExcepcion("El Carnet debe tener entre 9 y 12 caracteres.");
            }
        } else if (tipoDocumento.equalsIgnoreCase("PASAPORTE")) {
            if (numeroDocumento.length() < 6) {
                throw new ValidacionExcepcion("El Pasaporte debe tener mínimo 6 caracteres.");
            }
        } else {
            throw new ValidacionExcepcion("Tipo de documento inválido (use DNI, CARNET o PASAPORTE).");
        }
    }

    public void validarTelefono() throws ValidacionExcepcion {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new ValidacionExcepcion("El teléfono no puede estar vacío.");
        }

        if (!telefono.matches("\\d{9}")) {
            throw new ValidacionExcepcion("El teléfono debe tener exactamente 9 dígitos.");
        }
    }

    public void validarCorreo() throws ValidacionExcepcion {
        if (correo == null || correo.trim().isEmpty()) {
            throw new ValidacionExcepcion("El correo no puede estar vacío.");
        }

        if (!correo.contains("@") || !correo.contains(".")) {
            throw new ValidacionExcepcion("El correo debe contener '@' y '.'.");
        }

        if (correo.endsWith(".con")) {
            throw new ValidacionExcepcion("El correo no puede terminar en '.con'. Debe ser '.com'.");
        }
    }

    public void validarDatosMedicos() throws ValidacionExcepcion {
        if (tipoSangre == null || tipoSangre.trim().isEmpty()) {
            throw new ValidacionExcepcion("El tipo de sangre es obligatorio.");
        }

        if (alergias.isEmpty()) {
            throw new ValidacionExcepcion("Debe registrar al menos una alergia.");
        }
    }

    public void validarPacienteCompleto() throws ValidacionExcepcion {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new ValidacionExcepcion("El nombre completo no puede estar vacío.");
        }

        validarDocumento();
        validarTelefono();
        validarCorreo();
        validarDatosMedicos();
    }
    @Override
    public String toString() {
    return "ID: " + idPaciente
            + "\nNombre: " + nombreCompleto
            + "\nDocumento: " + tipoDocumento + " - " + numeroDocumento
            + "\nFecha Nacimiento: " + fechaNacimiento
            + "\nTipo Sangre: " + tipoSangre
            + "\nTeléfono: " + telefono
            + "\nCorreo: " + correo
            + "\nAlergias: " + listarAlergias();
    }
}
