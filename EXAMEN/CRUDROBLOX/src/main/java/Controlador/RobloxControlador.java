package Controlador;

import Modelo.Producto;
import Modelo.RobloxDAO;
import Vista.ProductoVista; // Vinculado a tu vista real


public class RobloxControlador {

    private final RobloxDAO modelo;
    private final ProductoVista vista; // Cambiado a ProductoVista

    public RobloxControlador(RobloxDAO modelo, ProductoVista vista) {
        this.modelo = modelo;
        this.vista  = vista;
        registrarEventos();
        cargarTabla();          // Mostrar datos al arrancar
    }

    // ── Registro de listeners ─────────────────────────────────────────────────
    private void registrarEventos() {
        // Vinculados a los botones reales de ProductoVista
        vista.getBtnLimpiar()   .addActionListener(e -> cargarTabla()); // btnLimpiar actúa como el refrescar/listar
        vista.getBtnAgregar()   .addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar()  .addActionListener(e -> eliminar());
        vista.getBtnBuscar()    .addActionListener(e -> buscar());

        // Evento para cambiar de vista en el CardLayout cuando se cambia el ComboBox
        vista.getCmbTipoProducto().addActionListener(e -> {
            String seleccion = (String) vista.getCmbTipoProducto().getSelectedItem();
            vista.getCardLayout().show(vista.getPanelCamposEspecificos(), seleccion);
        });

        // Al hacer click en una fila, rellena el formulario dinámicamente
        vista.getTablaProductos().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) rellenarFormulario();
        });
    }

    // ── Operaciones CRUD ──────────────────────────────────────────────────────
    private void cargarTabla() {
        vista.getModeloTabla().setRowCount(0);
        for (Producto p : modelo.listar()) {
            // Se adapta al formato de tu tabla: "ID", "Nombre", "Extra", "Tipo"
            vista.getModeloTabla().addRow(new Object[]{
                p.getId(), 
                p.getNombre(), 
                p.getPrecio(), // Nota: Aquí pasamos el atributo que uses como 'Extra' en tu modelo (Nivel/Visitas/Rareza)
                p.getTipo()
            });
        }
    }

    private void agregar() {
        try {
            Producto p = leerFormulario();
            if (modelo.insertar(p)) {
                vista.mostrarMensaje(p.getTipo() + " agregado correctamente.");
                vista.limpiarFormulario();
                cargarTabla();
            } else {
                vista.mostrarMensaje("No se pudo agregar el registro.");
            }
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Verifica que los campos numéricos sean correctos.");
        }
    }

    private void actualizar() {
        try {
            Producto p = leerFormulario();
            if (p.getId() == 0) { vista.mostrarMensaje("Selecciona un registro de la tabla."); return; }
            if (modelo.actualizar(p)) {
                vista.mostrarMensaje("Registro actualizado correctamente.");
                vista.limpiarFormulario();
                cargarTabla();
            } else {
                vista.mostrarMensaje("No se pudo actualizar.");
            }
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Verifica que los campos numéricos sean correctos.");
        }
    }

    private void eliminar() {
        String idTxt = vista.getTxtId().getText().trim();
        if (idTxt.isEmpty()) { vista.mostrarMensaje("Ingresa el ID a eliminar."); return; }
        int id = Integer.parseInt(idTxt);
        if (modelo.eliminar(id)) {
            vista.mostrarMensaje("Registro eliminado de la base de datos.");
            vista.limpiarFormulario();
            cargarTabla();
        } else {
            vista.mostrarMensaje("No se encontró el registro con ID " + id);
        }
    }

    private void buscar() {
        String idTxt = vista.getTxtId().getText().trim();
        if (idTxt.isEmpty()) { vista.mostrarMensaje("Ingresa el ID a buscar."); return; }
        
        Producto p = modelo.buscarPorId(Integer.parseInt(idTxt));
        if (p != null) {
            vista.getTxtNombre().setText(p.getNombre());
            vista.getCmbTipoProducto().setSelectedItem(p.getTipo());
            
            
            vista.getCardLayout().show(vista.getPanelCamposEspecificos(), p.getTipo());
            
            
            String tipo = p.getTipo();
            if ("USUARIO".equals(tipo)) {
                vista.getTxtNivel().setText(String.valueOf(p.getPrecio())); // Mapeado al valor extra
            } else if ("JUEGO".equals(tipo)) {
                vista.getTxtVisitas().setText(String.valueOf(p.getPrecio()));
            } else if ("ACCESORIO".equals(tipo)) {
                vista.getTxtRareza().setText(String.valueOf(p.getPrecio()));
            }
        } else {
            vista.mostrarMensaje("Registro no encontrado.");
        }
    }


    private Producto leerFormulario() {
        int id = vista.getTxtId().getText().trim().isEmpty() ? 0
                : Integer.parseInt(vista.getTxtId().getText().trim());
        String nombre = vista.getTxtNombre().getText().trim();
        String tipo = vista.getCmbTipoProducto().getSelectedItem().toString();
        
       
        double valorExtra = 0; 
        if ("USUARIO".equals(tipo)) {
            valorExtra = vista.getTxtNivel().getText().trim().isEmpty() ? 0 
                         : Double.parseDouble(vista.getTxtNivel().getText().trim());
        } else if ("JUEGO".equals(tipo)) {
            valorExtra = vista.getTxtVisitas().getText().trim().isEmpty() ? 0 
                         : Double.parseDouble(vista.getTxtVisitas().getText().trim());
        } else if ("ACCESORIO".equals(tipo)) {
            valorExtra = vista.getTxtRareza().getText().trim().isEmpty() ? 0 
                         : Double.parseDouble(vista.getTxtRareza().getText().trim());
        }

       
        return new Producto(id, nombre, tipo, valorExtra, 0);
    }

    private void rellenarFormulario() {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila < 0) return;
        var m = vista.getModeloTabla();
        
       
        vista.getTxtId().setText(m.getValueAt(fila, 0).toString());
        vista.getTxtNombre().setText(m.getValueAt(fila, 1).toString());
        
       
        String tipo = m.getValueAt(fila, 3).toString();
        vista.getCmbTipoProducto().setSelectedItem(tipo);
        vista.getCardLayout().show(vista.getPanelCamposEspecificos(), tipo);
        
        
        String extraValor = m.getValueAt(fila, 2).toString();
        if ("USUARIO".equals(tipo)) {
            vista.getTxtNivel().setText(extraValor);
        } else if ("JUEGO".equals(tipo)) {
            vista.getTxtVisitas().setText(extraValor);
        } else if ("ACCESORIO".equals(tipo)) {
            vista.getTxtRareza().setText(extraValor);
        }
    }
}