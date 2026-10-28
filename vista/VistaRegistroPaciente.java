package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

//Registra paciente
public class VistaRegistroPaciente extends JFrame {

    // Datos personales
    private final JComboBox<String> cmbTipoDocumento = new JComboBox<>(
            new String[]{"Cédula de ciudadanía", "Tarjeta de identidad", "Cédula de extranjería", "Pasaporte"});
    private final JTextField txtNumeroDocumento = new JTextField(15);
    private final JTextField txtNombres = new JTextField(15);
    private final JTextField txtApellidos = new JTextField(15);
    private final JTextField txtFechaNacimiento = new JTextField(10);
    private final JTextField txtEdad = new JTextField(6);
    private final JComboBox<String> cmbGenero = new JComboBox<>(
            new String[]{"Masculino", "Femenino", "Otro"});

    // Contacto
    private final JTextField txtTelefonoFijo = new JTextField(15);
    private final JTextField txtTelefonoCelular = new JTextField(15);
    private final JTextField txtCorreo = new JTextField(15);
    private final JTextField txtDireccion = new JTextField(15);

    // Adicional
    private final JComboBox<String> cmbEps = new JComboBox<>(
            new String[]{"Nueva EPS", "Sanitas", "Sura", "Compensar", "Famisanar"});
    private final JComboBox<String> cmbRegimen = new JComboBox<>(
            new String[]{"Contributivo", "Subsidiado", "Especial"});
    private final JTextField txtOcupacion = new JTextField(15);
    private final JComboBox<String> cmbEstadoCivil = new JComboBox<>(
            new String[]{"Soltero(a)", "Casado(a)", "Unión libre", "Divorciado(a)", "Viudo(a)"});
    private final JComboBox<String> cmbCondicionMedica = new JComboBox<>(new String[]{"No", "Sí"});
    private final JTextArea txtObservaciones = new JTextArea(3, 15);

    private final JButton botonCancelar = new JButton("Cancelar");
    private final JButton botonGuardar = new JButton("Guardar paciente");

    public VistaRegistroPaciente() {
        super("Registrar paciente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtEdad.setEditable(false);

        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.Y_AXIS));
        contenido.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Registrar paciente");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));
        JLabel subtitulo = new JLabel("Complete la información del paciente para continuar con el proceso de atención.");
        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        contenido.add(titulo);
        contenido.add(subtitulo);
        contenido.add(Box.createVerticalStrut(10));

        contenido.add(crearPanelDatosPersonales());
        contenido.add(crearPanelContacto());
        contenido.add(crearPanelAdicional());
        contenido.add(crearPanelBotones());

        setContentPane(contenido);
        pack();
        setLocationRelativeTo(null);
    }

    // paneles

    private JPanel crearPanelDatosPersonales() {
        JPanel panel = nuevoPanel("Datos personales");
        agregarCampo(panel, 0, 0, "Tipo de documento *", cmbTipoDocumento);
        agregarCampo(panel, 1, 0, "Número de documento *", txtNumeroDocumento);
        agregarCampo(panel, 0, 1, "Nombres *", txtNombres);
        agregarCampo(panel, 1, 1, "Apellidos *", txtApellidos);
        agregarCampo(panel, 0, 2, "Fecha de nacimiento * (dd/MM/yyyy)", txtFechaNacimiento);
        agregarCampo(panel, 1, 2, "Edad", txtEdad);
        agregarCampo(panel, 2, 2, "Género *", cmbGenero);
        return panel;
    }

    private JPanel crearPanelContacto() {
        JPanel panel = nuevoPanel("Información de contacto");
        agregarCampo(panel, 0, 0, "Teléfono fijo", txtTelefonoFijo);
        agregarCampo(panel, 1, 0, "Teléfono celular *", txtTelefonoCelular);
        agregarCampo(panel, 0, 1, "Correo electrónico", txtCorreo);
        agregarCampo(panel, 1, 1, "Dirección de residencia *", txtDireccion);
        return panel;
    }

    private JPanel crearPanelAdicional() {
        JPanel panel = nuevoPanel("Información adicional");
        agregarCampo(panel, 0, 0, "EPS *", cmbEps);
        agregarCampo(panel, 1, 0, "Régimen", cmbRegimen);
        agregarCampo(panel, 0, 1, "Ocupación", txtOcupacion);
        agregarCampo(panel, 1, 1, "Estado civil", cmbEstadoCivil);
        agregarCampo(panel, 0, 2, "¿Tiene alguna condición médica relevante?", cmbCondicionMedica);
        agregarCampo(panel, 1, 2, "Observaciones", new JScrollPane(txtObservaciones));
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(botonCancelar);
        panel.add(botonGuardar);
        return panel;
    }

    private JPanel nuevoPanel(String titulo) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panel;
    }

    //etiqueta con su campo debajo, en la celda (columna, fila)
    private void agregarCampo(JPanel panel, int columna, int fila, String etiqueta, JComponent campo) {
        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.gridx = columna;
        restricciones.gridy = fila;
        restricciones.insets = new Insets(2, 5, 2, 5);
        restricciones.fill = GridBagConstraints.HORIZONTAL;
        restricciones.weightx = 1;

        JPanel celda = new JPanel(new BorderLayout(0, 2));
        celda.add(new JLabel(etiqueta), BorderLayout.NORTH);
        celda.add(campo, BorderLayout.CENTER);
        panel.add(celda, restricciones);
    }

    // métodos que usa el controlador

    public String obtenerTipoDocumento() { return (String) cmbTipoDocumento.getSelectedItem(); }
    public String obtenerNumeroDocumento() { return txtNumeroDocumento.getText().trim(); }
    public String obtenerNombres() { return txtNombres.getText().trim(); }
    public String obtenerApellidos() { return txtApellidos.getText().trim(); }
    public String obtenerFechaNacimiento() { return txtFechaNacimiento.getText().trim(); }
    public String obtenerGenero() { return (String) cmbGenero.getSelectedItem(); }
    public String obtenerTelefonoFijo() { return txtTelefonoFijo.getText().trim(); }
    public String obtenerTelefonoCelular() { return txtTelefonoCelular.getText().trim(); }
    public String obtenerCorreo() { return txtCorreo.getText().trim(); }
    public String obtenerDireccion() { return txtDireccion.getText().trim(); }
    public String obtenerEps() { return (String) cmbEps.getSelectedItem(); }
    public String obtenerRegimen() { return (String) cmbRegimen.getSelectedItem(); }
    public String obtenerOcupacion() { return txtOcupacion.getText().trim(); }
    public String obtenerEstadoCivil() { return (String) cmbEstadoCivil.getSelectedItem(); }
    public String obtenerCondicionMedica() { return (String) cmbCondicionMedica.getSelectedItem(); }
    public String obtenerObservaciones() { return txtObservaciones.getText().trim(); }

    public void establecerEdad(String texto) { txtEdad.setText(texto); }

    public void limpiar() {
        txtNumeroDocumento.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaNacimiento.setText("");
        txtEdad.setText("");
        txtTelefonoFijo.setText("");
        txtTelefonoCelular.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtOcupacion.setText("");
        txtObservaciones.setText("");
        cmbTipoDocumento.setSelectedIndex(0);
        cmbGenero.setSelectedIndex(0);
        cmbEps.setSelectedIndex(0);
        cmbRegimen.setSelectedIndex(0);
        cmbEstadoCivil.setSelectedIndex(0);
        cmbCondicionMedica.setSelectedIndex(0);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // escucha de eventos

    public void agregarEscuchaGuardar(ActionListener escucha) { botonGuardar.addActionListener(escucha); }
    public void agregarEscuchaCancelar(ActionListener escucha) { botonCancelar.addActionListener(escucha); }

    /** Se ejecuta cuando el campo de fecha pierde el foco (para calcular la edad). */
    public void agregarEscuchaFocoFecha(Runnable accion) {
        txtFechaNacimiento.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent evento) {
                accion.run();
            }
        });
    }
}
