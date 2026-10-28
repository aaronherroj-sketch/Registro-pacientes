package modelo;

import java.util.ArrayList;
import java.util.List;

//almacenamiento//
public class RepositorioPaciente {
    private final List<Paciente> pacientes = new ArrayList<>();

    public boolean existe(String numeroDocumento) {
        for (Paciente paciente : pacientes) {
            if (paciente.obtenerNumeroDocumento().equals(numeroDocumento)) {
                return true;
            }
        }
        return false;
    }

    public void guardar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Paciente> listar() {
        return pacientes;
    }
}
