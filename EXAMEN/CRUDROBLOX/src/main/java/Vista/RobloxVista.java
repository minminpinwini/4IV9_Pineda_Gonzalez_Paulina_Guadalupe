package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class RobloxVista extends JFrame {

    // ── Campos del formulario ────────────────────────────────────────────────
    private JTextField txtId     = new JTextField(5);
    private JTextField txtNombre = new JTextField(15);
    private JTextField txtTipo   = new JTextField(12);
    private JTextField txtPrecio = new JTextField(8);
    private JTextField txtStock  = new JTextField(6);

    // ── Botones CRUD ─────────────────────────────────────────────────────────
    private JButton btnAgregar   = new JButton("Agregar");
    private JButton btnActualizar = new JButton("Actualizar");
    private JButton btnEliminar  = new JButton("Eliminar");
    private JButton btnBuscar    = new JButton("Buscar");
    private JButton btnListar    = new JButton("Listar todos");

    // ── Tabla de resultados ───────────────────────────────────────────────────
    private DefaultTableModel modeloTabla = new DefaultTableModel(
            new String[]{"ID", "Nombre", "Tipo", "Precio", "Stock"}, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };
    private JTable tabla = new JTable(modeloTabla);

    public RobloxVista() {
        super("CRUD Roblox DB");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        setSize(700, 480);
        setLocationRelativeTo(null);
        add(panelFormulario(), BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private JPanel panelFormulario() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6));
        p.setBorder(BorderFactory.createTitledBorder("Producto"));

        p.add(new JLabel("ID:"));     p.add(txtId);
        p.add(new JLabel("Nombre:")); p.add(txtNombre);
        p.add(new JLabel("Tipo:"));   p.add(txtTipo);
        p.add(new JLabel("Precio:")); p.add(txtPrecio);
        p.add(new JLabel("Stock:"));  p.add(txtStock);

        p.add(btnAgregar);
        p.add(btnActualizar);
        p.add(btnEliminar);
        p.add(btnBuscar);
        p.add(btnListar);
        return p;
    }

    // ── Getters para que el Controlador acceda a los componentes ─────────────
    public JTextField getTxtId()      { return txtId; }
    public JTextField getTxtNombre()  { return txtNombre; }
    public JTextField getTxtTipo()    { return txtTipo; }
    public JTextField getTxtPrecio()  { return txtPrecio; }
    public JTextField getTxtStock()   { return txtStock; }

    public JButton getBtnAgregar()    { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnEliminar()   { return btnEliminar; }
    public JButton getBtnBuscar()     { return btnBuscar; }
    public JButton getBtnListar()     { return btnListar; }

    public DefaultTableModel getModeloTabla() { return modeloTabla; }
    public JTable getTabla()           { return tabla; }

   
    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtTipo.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
    }

 
    public void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
}
