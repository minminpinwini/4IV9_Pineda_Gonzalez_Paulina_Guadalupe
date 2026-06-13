package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductoVista extends JFrame {

    // --- Tabla ---
    private JTable tablaProductos;
    private DefaultTableModel modeloTabla;

    // --- Campos comunes ---
    private JTextField txtId, txtNombre;
    private JComboBox<String> cmbTipoProducto;

    // --- USUARIOS ---
    private JTextField txtNivel, txtPais, txtHoras;
    private JCheckBox chkPremium;

    // --- JUEGOS ---
    private JTextField txtUsuarioIdJuego, txtDesarrollador, txtVisitas, txtRating, txtGenero;

    // --- ACCESORIOS ---
    private JTextField txtUsuarioIdAcc, txtRareza, txtColor, txtTipoAccesorio, txtPrecio;

    // --- Botones ---
    private JButton btnAgregar, btnActualizar, btnEliminar, btnBuscar, btnLimpiar;

    // --- CardLayout ---
    private JPanel panelCamposEspecificos;
    private CardLayout cardLayout;

    public ProductoVista() {
        setTitle("CRUD Roblox - Usuarios / Juegos / Accesorios");
        setSize(950, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        init();
    }

    private void init() {
       
        setLayout(new BorderLayout(10, 10));

        // ================= TITULO (NORTE) =================
        JLabel titulo = new JLabel("Sistema Roblox CRUD", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        add(titulo, BorderLayout.NORTH);

        // ================= TABLA (CENTRO) =================
      
        modeloTabla = new DefaultTableModel();

        tablaProductos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProductos);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Registros en la Base de Datos"));
        add(scrollTabla, BorderLayout.CENTER);

        // ================= PANEL DE CONTROL INFERIOR (SUR) =================
        JPanel panelInferiorForm = new JPanel(new BorderLayout(5, 5));
        panelInferiorForm.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        // ---- DATOS GENERALES ----
        JPanel panelBase = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panelBase.setBorder(BorderFactory.createTitledBorder("Datos Generales"));

        panelBase.add(new JLabel("Tipo:"));
        cmbTipoProducto = new JComboBox<>(new String[]{"USUARIO", "JUEGO", "ACCESORIO"});
        panelBase.add(cmbTipoProducto);

        panelBase.add(new JLabel("ID:"));
        txtId = new JTextField(6);
        panelBase.add(txtId);

        panelBase.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(25);
        panelBase.add(txtNombre);

        panelInferiorForm.add(panelBase, BorderLayout.NORTH);

        // ================= CAMPOS ESPECÍFICOS (CardLayout - CENTRO) =================
        cardLayout = new CardLayout();
        panelCamposEspecificos = new JPanel(cardLayout);
        panelCamposEspecificos.setBorder(BorderFactory.createTitledBorder("Atributos Específicos"));

        // ---- USUARIO ----
        JPanel usuario = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        usuario.add(new JLabel("Nivel:")); txtNivel = new JTextField(6); usuario.add(txtNivel);
        usuario.add(new JLabel("País:")); txtPais = new JTextField(10); usuario.add(txtPais);
        usuario.add(new JLabel("Horas:")); txtHoras = new JTextField(6); usuario.add(txtHoras);
        usuario.add(new JLabel("Premium:")); chkPremium = new JCheckBox(); usuario.add(chkPremium);
        panelCamposEspecificos.add(usuario, "USUARIO");

        // ---- JUEGO ----
        JPanel juego = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 10));
        juego.add(new JLabel("User ID:")); txtUsuarioIdJuego = new JTextField(6); juego.add(txtUsuarioIdJuego);
        juego.add(new JLabel("Dev:")); txtDesarrollador = new JTextField(10); juego.add(txtDesarrollador);
        juego.add(new JLabel("Visitas:")); txtVisitas = new JTextField(8); juego.add(txtVisitas);
        juego.add(new JLabel("Rating:")); txtRating = new JTextField(5); juego.add(txtRating);
        juego.add(new JLabel("Género:")); txtGenero = new JTextField(10); juego.add(txtGenero);
        panelCamposEspecificos.add(juego, "JUEGO");

        // ---- ACCESORIO ----
        JPanel acc = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 10));
        acc.add(new JLabel("User ID:")); txtUsuarioIdAcc = new JTextField(6); acc.add(txtUsuarioIdAcc);
        acc.add(new JLabel("Rareza:")); txtRareza = new JTextField(10); acc.add(txtRareza);
        acc.add(new JLabel("Color:")); txtColor = new JTextField(8); acc.add(txtColor);
        acc.add(new JLabel("Tipo:")); txtTipoAccesorio = new JTextField(10); acc.add(txtTipoAccesorio);
        acc.add(new JLabel("Precio:")); txtPrecio = new JTextField(6); acc.add(txtPrecio);
        panelCamposEspecificos.add(acc, "ACCESORIO");

        panelInferiorForm.add(panelCamposEspecificos, BorderLayout.CENTER);

        // ================= BOTONES (SUR) =================
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnLimpiar);

        panelInferiorForm.add(panelBotones, BorderLayout.SOUTH);

    
        add(panelInferiorForm, BorderLayout.SOUTH);

        // ================= EVENTO LOCAL PARA DINAMISMO INTERNO =================
        
        cmbTipoProducto.addActionListener(e -> {
            String seleccion = (String) cmbTipoProducto.getSelectedItem();
            cardLayout.show(panelCamposEspecificos, seleccion);
            configurarColumnasTabla(seleccion);
        });

        // Configuración inicial por defecto al abrir el programa
        configurarColumnasTabla("USUARIO");
    }

    
    public void configurarColumnasTabla(String tipo) {
        if ("USUARIO".equals(tipo)) {
            modeloTabla.setColumnIdentifiers(new String[]{
                "ID", "Nombre", "Nivel", "País", "Horas Jugadas", "Premium", "Tipo"
            });
        } else if ("JUEGO".equals(tipo)) {
            modeloTabla.setColumnIdentifiers(new String[]{
                "ID", "Nombre", "User ID", "Creador/Dev", "Visitas", "Rating", "Género", "Tipo"
            });
        } else if ("ACCESORIO".equals(tipo)) {
            modeloTabla.setColumnIdentifiers(new String[]{
                "ID", "Nombre", "User ID", "Rareza", "Color", "Subtipo", "Precio", "Tipo"
            });
        }
    }

    // ================= GETTERS =================
    public JTable getTablaProductos() { return tablaProductos; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    public JTextField getTxtId() { return txtId; }
    public JTextField getTxtNombre() { return txtNombre; }
    public JComboBox<String> getCmbTipoProducto() { return cmbTipoProducto; }

    public JTextField getTxtNivel() { return txtNivel; }
    public JTextField getTxtPais() { return txtPais; }
    public JTextField getTxtHoras() { return txtHoras; }
    public JCheckBox getChkPremium() { return chkPremium; }

    public JTextField getTxtUsuarioIdJuego() { return txtUsuarioIdJuego; }
    public JTextField getTxtDesarrollador() { return txtDesarrollador; }
    public JTextField getTxtVisitas() { return txtVisitas; }
    public JTextField getTxtRating() { return txtRating; }
    public JTextField getTxtGenero() { return txtGenero; }

    public JTextField getTxtUsuarioIdAcc() { return txtUsuarioIdAcc; }
    public JTextField getTxtRareza() { return txtRareza; }
    public JTextField getTxtColor() { return txtColor; }
    public JTextField getTxtTipoAccesorio() { return txtTipoAccesorio; }
    public JTextField getTxtPrecio() { return txtPrecio; }

    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }

    public CardLayout getCardLayout() { return cardLayout; }
    public JPanel getPanelCamposEspecificos() { return panelCamposEspecificos; }

    // ================= UTILIDADES =================
    public void mostrarMensaje(String m) {
        JOptionPane.showMessageDialog(this, m);
    }

    public void mostrarError(String m) {
        JOptionPane.showMessageDialog(this, m, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");

        txtNivel.setText("");
        txtPais.setText("");
        txtHoras.setText("");
        chkPremium.setSelected(false);

        txtUsuarioIdJuego.setText("");
        txtDesarrollador.setText("");
        txtVisitas.setText("");
        txtRating.setText("");
        txtGenero.setText("");

        txtUsuarioIdAcc.setText("");
        txtRareza.setText("");
        txtColor.setText("");
        txtTipoAccesorio.setText("");
        txtPrecio.setText("");

        tablaProductos.clearSelection();
    }
}