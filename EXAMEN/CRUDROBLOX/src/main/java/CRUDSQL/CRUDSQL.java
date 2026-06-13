/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUDSQL;



import Controlador.RobloxControlador;
import Modelo.ConexionBD;
import Modelo.RobloxDAO;
import Vista.ProductoVista;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CRUDSQL {

    public static void main(String[] args) throws Exception {

        // conexión a BD
        if (!ConexionBD.probarConexion()) {
            JOptionPane.showMessageDialog(null,
                    "No se pudo conectar a la BD roblox_db");
            return;
        }

        // ? Lanzar interfaz gráfica
        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.out.println("Error L&F: " + e.getMessage());
            }

            //  MODELO (DAO)
            RobloxDAO modelo = new RobloxDAO();

            // Vista
            ProductoVista vista = new ProductoVista();

            //  CONTROLADOR
            new RobloxControlador(modelo, vista);

            // MOSTRAR INTERFAZ
            vista.setVisible(true);
        });
    }
}