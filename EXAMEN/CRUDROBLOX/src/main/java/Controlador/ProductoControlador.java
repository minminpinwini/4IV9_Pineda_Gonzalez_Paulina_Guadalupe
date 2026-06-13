package Controlador;

import Modelo.*;
import Vista.ProductoVista;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProductoControlador {

    private ProductoDAO dao;
    private ProductoVista vista;

    public ProductoControlador(ProductoDAO dao, ProductoVista vista) {
        this.dao  = dao;
        this.vista = vista;
        eventos();
        cargarTabla();
    }

    private void eventos() {
        vista.getBtnAgregar()   .addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar()  .addActionListener(e -> eliminar());
        vista.getBtnBuscar()    .addActionListener(e -> buscar());
        vista.getBtnLimpiar()   .addActionListener(e -> vista.limpiarFormulario());

        
        vista.getCmbTipoProducto().addActionListener(e -> {
            String tipo = (String) vista.getCmbTipoProducto().getSelectedItem();
            vista.getCardLayout().show(vista.getPanelCamposEspecificos(), tipo);
        });

        vista.getTablaProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { seleccionar(); }
        });
    }

    // ================= CREATE =================
    private void agregar() {
        try {
            Producto p = construir();
            if (p == null) return;
            dao.agregar(p);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Registro agregado correctamente");
        } catch (Exception e) {
            vista.mostrarError(e.getMessage());
        }
    }

    // ================= UPDATE =================
    private void actualizar() {
        try {
            Producto p = construir();
            if (p == null) return;
            dao.actualizar(p);
            cargarTabla();
            vista.mostrarMensaje("Registro actualizado");
        } catch (Exception e) {
            vista.mostrarError(e.getMessage());
        }
    }

    // ================= DELETE =================
    private void eliminar() {
        try {
            int id = Integer.parseInt(vista.getTxtId().getText().trim());
            dao.eliminar(id);
            cargarTabla();
            vista.mostrarMensaje("Registro eliminado");
        } catch (NumberFormatException e) {
            vista.mostrarError("Ingresa un ID numérico válido");
        } catch (Exception e) {
            vista.mostrarError("Error al eliminar: " + e.getMessage());
        }
    }

    // ================= SEARCH =================
    private void buscar() {
        try {
            int id = Integer.parseInt(vista.getTxtId().getText().trim());
            Producto p = dao.buscarPorId(id);
            if (p != null) {
                cargarFormulario(p);
            } else {
                vista.mostrarError("No encontrado");
            }
        } catch (NumberFormatException e) {
            vista.mostrarError("Ingresa un ID numérico válido");
        } catch (Exception e) {
            vista.mostrarError("Error búsqueda: " + e.getMessage());
        }
    }

    // ================= TABLA =================
    private void cargarTabla() {
        try {
            DefaultTableModel m = vista.getModeloTabla();
            m.setRowCount(0);
            List<Producto> lista = dao.listarTodos();

            for (Producto p : lista) {
                if (p instanceof Usuario) {
                    Usuario u = (Usuario) p;
                    m.addRow(new Object[]{ u.getId(), u.getNombre(), "Nivel: " + u.getNivel(), "USUARIO" });

                } else if (p instanceof Juego) {
                    Juego j = (Juego) p;
                    m.addRow(new Object[]{ j.getId(), j.getNombre(), "Rating: " + j.getRating(), "JUEGO" });

                } else if (p instanceof Accesorio) {
                    Accesorio a = (Accesorio) p;
                    m.addRow(new Object[]{ a.getId(), a.getNombre(), a.getRareza(), "ACCESORIO" });
                }
            }
        } catch (Exception e) {
            vista.mostrarError("Error cargando tabla: " + e.getMessage());
        }
    }

    // ================= CONSTRUIR OBJETO =================
    private Producto construir() {
        try {
            String idTexto = vista.getTxtId().getText().trim();
            int    id      = idTexto.isEmpty() ? 0 : Integer.parseInt(idTexto);
            String nombre  = vista.getTxtNombre().getText().trim();
            String tipo    = (String) vista.getCmbTipoProducto().getSelectedItem();

            if (nombre.isEmpty()) {
                vista.mostrarError("El nombre no puede estar vacío");
                return null;
            }

            switch (tipo) {

                case "USUARIO":
                    return new Usuario(
                            id, nombre,
                            Integer.parseInt(vista.getTxtNivel().getText().trim()),
                            vista.getTxtPais().getText().trim(),
                            vista.getChkPremium().isSelected(),
                            Integer.parseInt(vista.getTxtHoras().getText().trim())
                    );

                case "JUEGO":
                    return new Juego(
                            id, nombre,
                            vista.getTxtDesarrollador().getText().trim(),
                            Long.parseLong(vista.getTxtVisitas().getText().trim()),
                            Double.parseDouble(vista.getTxtRating().getText().trim()),
                            vista.getTxtGenero().getText().trim()
                    );

                case "ACCESORIO":
                     return new Accesorio(
                            id,
                            Integer.parseInt(vista.getTxtUsuarioIdAcc().getText().trim()),
                            nombre,
                            vista.getTxtRareza().getText().trim(),
                            vista.getTxtColor().getText().trim(),
                            vista.getTxtTipoAccesorio().getText().trim(),
                            Double.parseDouble(vista.getTxtPrecio().getText().trim())
                    );

                default:
                    vista.mostrarError("Tipo no reconocido: " + tipo);
                    return null;
            }

        } catch (NumberFormatException e) {
            vista.mostrarError("Verifica que los campos numéricos sean válidos");
            return null;
        } catch (Exception e) {
            vista.mostrarError("Datos inválidos: " + e.getMessage());
            return null;
        }
    }

    // ================= CARGAR FORMULARIO =================
    private void cargarFormulario(Producto p) {
        vista.getTxtId()    .setText(String.valueOf(p.getId()));
        vista.getTxtNombre().setText(p.getNombre());

        if (p instanceof Usuario) {
            Usuario u = (Usuario) p;
            vista.getCmbTipoProducto().setSelectedItem("USUARIO");
            vista.getCardLayout().show(vista.getPanelCamposEspecificos(), "USUARIO");
            vista.getTxtNivel().setText(String.valueOf(u.getNivel()));
            vista.getTxtPais() .setText(u.getPais());
            vista.getChkPremium().setSelected(u.isPremium());
            vista.getTxtHoras().setText(String.valueOf(u.getHorasJugadas()));

        } else if (p instanceof Juego) {
            Juego j = (Juego) p;
            vista.getCmbTipoProducto().setSelectedItem("JUEGO");
            vista.getCardLayout().show(vista.getPanelCamposEspecificos(), "JUEGO");
            vista.getTxtDesarrollador().setText(j.getDesarrollador());
            vista.getTxtVisitas()      .setText(String.valueOf(j.getVisitas()));
            vista.getTxtRating()       .setText(String.valueOf(j.getRating()));
            vista.getTxtGenero()       .setText(j.getGenero());

        } else if (p instanceof Accesorio) {
            Accesorio a = (Accesorio) p;
            vista.getCmbTipoProducto().setSelectedItem("ACCESORIO");
            vista.getCardLayout().show(vista.getPanelCamposEspecificos(), "ACCESORIO");
            
            vista.getTxtUsuarioIdAcc()  .setText(String.valueOf(a.getUsuarioId()));
            vista.getTxtRareza()        .setText(a.getRareza());
            vista.getTxtColor()         .setText(a.getColor());
            vista.getTxtTipoAccesorio() .setText(a.getTipo());
            vista.getTxtPrecio()        .setText(String.valueOf(a.getPrecio()));
        }
    }

    // ================= SELECCIONAR FILA =================
    private void seleccionar() {
        int fila = vista.getTablaProductos().getSelectedRow();
        if (fila == -1) return;
        vista.getTxtId()    .setText(String.valueOf(vista.getModeloTabla().getValueAt(fila, 0)));
        vista.getTxtNombre().setText(String.valueOf(vista.getModeloTabla().getValueAt(fila, 1)));
    }
}
