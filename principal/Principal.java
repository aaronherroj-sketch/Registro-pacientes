package principal;

import controlador.ControladorPaciente;
import modelo.RepositorioPaciente;
import vista.VistaRegistroPaciente;

import javax.swing.SwingUtilities;

public class Principal {
    public static void main(String[] argumentos) {
        SwingUtilities.invokeLater(() -> {
            VistaRegistroPaciente vista = new VistaRegistroPaciente();
            RepositorioPaciente repositorio = new RepositorioPaciente();
            new ControladorPaciente(vista, repositorio);
            vista.setVisible(true);
        });
    }
}
