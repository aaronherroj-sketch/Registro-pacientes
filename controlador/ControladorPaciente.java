package controlador;

import modelo.Paciente;
import modelo.RepositorioPaciente;
import vista.VistaRegistroPaciente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ControladorPaciente {
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final VistaRegistroPaciente vista;
    private final RepositorioPaciente repositorio;

    public ControladorPaciente(VistaRegistroPaciente vista, RepositorioPaciente repositorio) {
        this.vista = vista;
        this.repositorio = repositorio;

        this.vista.agregarEscuchaGuardar(evento -> guardarPaciente());
        this.vista.agregarEscuchaCancelar(evento -> vista.limpiar());
        this.vista.agregarEscuchaFocoFecha(this::calcularEdad);
    }

    private void calcularEdad() {
        try {
            LocalDate fecha = LocalDate.parse(vista.obtenerFechaNacimiento(), FORMATO_FECHA);
            Paciente temporal = new Paciente();
            temporal.establecerFechaNacimiento(fecha);
            vista.establecerEdad(temporal.obtenerEdad() + " años");
        } catch (DateTimeParseException excepcion) {
            vista.establecerEdad("");
        }
    }

    private void guardarPaciente() {
        // Validación de campos obligatorios
        if (vista.obtenerNumeroDocumento().isEmpty() || vista.obtenerNombres().isEmpty()
                || vista.obtenerApellidos().isEmpty() || vista.obtenerFechaNacimiento().isEmpty()
                || vista.obtenerTelefonoCelular().isEmpty() || vista.obtenerDireccion().isEmpty()) {
            vista.mostrarError("Complete todos los campos obligatorios (*).");
            return;
        }

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(vista.obtenerFechaNacimiento(), FORMATO_FECHA);
        } catch (DateTimeParseException excepcion) {
            vista.mostrarError("La fecha debe tener el formato dd/MM/yyyy.");
            return;
        }

        if (repositorio.existe(vista.obtenerNumeroDocumento())) {
            vista.mostrarError("Ya existe un paciente con ese número de documento.");
            return;
        }

        // Se construye el modelo con los datos de la vista
        Paciente paciente = new Paciente();
        paciente.establecerTipoDocumento(vista.obtenerTipoDocumento());
        paciente.establecerNumeroDocumento(vista.obtenerNumeroDocumento());
        paciente.establecerNombres(vista.obtenerNombres());
        paciente.establecerApellidos(vista.obtenerApellidos());
        paciente.establecerFechaNacimiento(fecha);
        paciente.establecerGenero(vista.obtenerGenero());
        paciente.establecerTelefonoFijo(vista.obtenerTelefonoFijo());
        paciente.establecerTelefonoCelular(vista.obtenerTelefonoCelular());
        paciente.establecerCorreo(vista.obtenerCorreo());
        paciente.establecerDireccion(vista.obtenerDireccion());
        paciente.establecerEps(vista.obtenerEps());
        paciente.establecerRegimen(vista.obtenerRegimen());
        paciente.establecerOcupacion(vista.obtenerOcupacion());
        paciente.establecerEstadoCivil(vista.obtenerEstadoCivil());
        paciente.establecerCondicionMedica(vista.obtenerCondicionMedica());
        paciente.establecerObservaciones(vista.obtenerObservaciones());

        repositorio.guardar(paciente);
        vista.mostrarMensaje("Paciente guardado: " + paciente.obtenerNombres() + " " + paciente.obtenerApellidos());
        vista.limpiar();
    }
}
