package Controlador;

import Modelo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // =========================
    // CREATE
    // =========================
    public void agregar(Producto p) throws Exception {

        if (p instanceof Usuario) {
            Usuario u = (Usuario) p;
            String sql = "INSERT INTO usuarios (id, nombre, nivel, pais, premium, horas_jugadas) "
                       + "VALUES (?,?,?,?,?,?)";

            try (Connection conn = ConexionBD.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, u.getId());
                ps.setString(2, u.getNombre());
                ps.setInt(3, u.getNivel());
                ps.setString(4, u.getPais());
                ps.setBoolean(5, u.isPremium());
                ps.setInt(6, u.getHorasJugadas());
                ps.executeUpdate();
            }

        } else if (p instanceof Juego) {
            Juego j = (Juego) p;
            String sql = "INSERT INTO juegos (id, nombre, desarrollador, visitas, rating, genero) "
                       + "VALUES (?,?,?,?,?,?)";

            try (Connection conn = ConexionBD.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, j.getId());
                ps.setString(2, j.getNombre());
                ps.setString(3, j.getDesarrollador());
                ps.setLong(4, j.getVisitas());
                ps.setDouble(5, j.getRating());
                ps.setString(6, j.getGenero());
                ps.executeUpdate();
            }

        } else if (p instanceof Accesorio) {
            Accesorio a = (Accesorio) p;
            String sql = "INSERT INTO accesorios (id, usuario_id, nombre, rareza, color, tipo, precio) "
                       + "VALUES (?,?,?,?,?,?,?)";

            try (Connection conn = ConexionBD.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setInt(1, a.getId());
                ps.setInt(2, a.getUsuarioId());
                ps.setString(3, a.getNombre());
                ps.setString(4, a.getRareza());
                ps.setString(5, a.getColor());
                ps.setString(6, a.getTipo());
                ps.setDouble(7, a.getPrecio());
                ps.executeUpdate();
            }
        }
    }

    // =========================
    // READ ALL
    // =========================
    public List<Producto> listarTodos() throws Exception {

        List<Producto> lista = new ArrayList<>();

        // USUARIOS
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("nivel"),
                        rs.getString("pais"),
                        rs.getBoolean("premium"),
                        rs.getInt("horas_jugadas")
                ));
            }
        }

        // JUEGOS
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM juegos");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Juego(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("desarrollador"),
                        rs.getLong("visitas"),
                        rs.getDouble("rating"),
                        rs.getString("genero")
                ));
            }
        }

        // ACCESORIOS
        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM accesorios");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Accesorio(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getString("nombre"),
                        rs.getString("rareza"),
                        rs.getString("color"),
                        rs.getString("tipo"),
                        rs.getDouble("precio")
                ));
            }
        }

        return lista;
    }

    
    public Producto buscarPorId(int id) throws Exception {

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"), rs.getString("nombre"),
                        rs.getInt("nivel"), rs.getString("pais"),
                        rs.getBoolean("premium"), rs.getInt("horas_jugadas")
                );
            }
        }

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM juegos WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Juego(
                        rs.getInt("id"), rs.getString("nombre"),
                        rs.getString("desarrollador"), rs.getLong("visitas"),
                        rs.getDouble("rating"), rs.getString("genero")
                );
            }
        }

        try (Connection conn = ConexionBD.getConexion();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM accesorios WHERE id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Accesorio(
                        rs.getInt("id"), rs.getInt("usuario_id"),
                        rs.getString("nombre"), rs.getString("rareza"),
                        rs.getString("color"), rs.getString("tipo"),
                        rs.getDouble("precio")
                );
            }
        }

        return null;
    }

    // =========================
    // DELETE
    // =========================
    public void eliminar(int id) throws Exception {
        try (Connection conn = ConexionBD.getConexion()) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM usuarios WHERE id=?")) {
                ps.setInt(1, id); ps.executeUpdate();
            }
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM juegos WHERE id=?")) {
                ps.setInt(1, id); ps.executeUpdate();
            }
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM accesorios WHERE id=?")) {
                ps.setInt(1, id); ps.executeUpdate();
            }
        }
    }

    // =========================
    // UPDATE
    // =========================
    public void actualizar(Producto p) throws Exception {

        if (p instanceof Usuario) {
            Usuario u = (Usuario) p;
            String sql = "UPDATE usuarios SET nombre=?, nivel=?, pais=?, premium=?, horas_jugadas=? WHERE id=?";
            try (Connection conn = ConexionBD.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, u.getNombre());
                ps.setInt(2, u.getNivel());
                ps.setString(3, u.getPais());
                ps.setBoolean(4, u.isPremium());
                ps.setInt(5, u.getHorasJugadas());
                ps.setInt(6, u.getId());
                ps.executeUpdate();
            }

        } else if (p instanceof Juego) {
            Juego j = (Juego) p;
            String sql = "UPDATE juegos SET nombre=?, desarrollador=?, visitas=?, rating=?, genero=? WHERE id=?";
            try (Connection conn = ConexionBD.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, j.getNombre());
                ps.setString(2, j.getDesarrollador());
                ps.setLong(3, j.getVisitas());
                ps.setDouble(4, j.getRating());
                ps.setString(5, j.getGenero());
                ps.setInt(6, j.getId());
                ps.executeUpdate();
            }

        } else if (p instanceof Accesorio) {
            Accesorio a = (Accesorio) p;
            String sql = "UPDATE accesorios SET nombre=?, rareza=?, color=?, tipo=?, precio=? WHERE id=?";
            try (Connection conn = ConexionBD.getConexion();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, a.getNombre());
                ps.setString(2, a.getRareza());
                ps.setString(3, a.getColor());
                ps.setString(4, a.getTipo());
                ps.setDouble(5, a.getPrecio());
                ps.setInt(6, a.getId());
                ps.executeUpdate();
            }
        }
    }
}
