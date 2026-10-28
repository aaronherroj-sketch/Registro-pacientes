package modelo;

import java.time.LocalDate;
import java.time.Period;

//datos de un paciente
public class Paciente {
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String genero;
    private String telefonoFijo;
    private String telefonoCelular;
    private String correo;
    private String direccion;
    private String eps;
    private String regimen;
    private String ocupacion;
    private String estadoCivil;
    private String condicionMedica;
    private String observaciones;

    public Paciente() {
    }

    /** Calcula la edad en años a partir de la fecha de nacimiento. */
    public int obtenerEdad() {
        if (fechaNacimiento == null) return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String obtenerTipoDocumento() { return tipoDocumento; }
    public void establecerTipoDocumento(String valor) { this.tipoDocumento = valor; }

    public String obtenerNumeroDocumento() { return numeroDocumento; }
    public void establecerNumeroDocumento(String valor) { this.numeroDocumento = valor; }

    public String obtenerNombres() { return nombres; }
    public void establecerNombres(String valor) { this.nombres = valor; }

    public String obtenerApellidos() { return apellidos; }
    public void establecerApellidos(String valor) { this.apellidos = valor; }

    public LocalDate obtenerFechaNacimiento() { return fechaNacimiento; }
    public void establecerFechaNacimiento(LocalDate valor) { this.fechaNacimiento = valor; }

    public String obtenerGenero() { return genero; }
    public void establecerGenero(String valor) { this.genero = valor; }

    public String obtenerTelefonoFijo() { return telefonoFijo; }
    public void establecerTelefonoFijo(String valor) { this.telefonoFijo = valor; }

    public String obtenerTelefonoCelular() { return telefonoCelular; }
    public void establecerTelefonoCelular(String valor) { this.telefonoCelular = valor; }

    public String obtenerCorreo() { return correo; }
    public void establecerCorreo(String valor) { this.correo = valor; }

    public String obtenerDireccion() { return direccion; }
    public void establecerDireccion(String valor) { this.direccion = valor; }

    public String obtenerEps() { return eps; }
    public void establecerEps(String valor) { this.eps = valor; }

    public String obtenerRegimen() { return regimen; }
    public void establecerRegimen(String valor) { this.regimen = valor; }

    public String obtenerOcupacion() { return ocupacion; }
    public void establecerOcupacion(String valor) { this.ocupacion = valor; }

    public String obtenerEstadoCivil() { return estadoCivil; }
    public void establecerEstadoCivil(String valor) { this.estadoCivil = valor; }

    public String obtenerCondicionMedica() { return condicionMedica; }
    public void establecerCondicionMedica(String valor) { this.condicionMedica = valor; }

    public String obtenerObservaciones() { return observaciones; }
    public void establecerObservaciones(String valor) { this.observaciones = valor; }
}
