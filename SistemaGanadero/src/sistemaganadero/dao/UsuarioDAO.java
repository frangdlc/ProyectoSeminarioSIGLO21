/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import conexion.ConexionBD;
import java.util.ArrayList;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Rol;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase simula la implementación de la interfaz IUsuarioDAO para propósitos de prueba.
 * Proporciona una lista en memoria de usuarios y métodos para gestionar esos usuarios sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class UsuarioDAO implements IUsuarioDAO {
    private List<Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new ArrayList<>();
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }


    @Override
    public Usuario autenticarUsuario(String usuarioInput, String passwordInput) {
        Connection con = null;
        Usuario usuario = null;

        try {
            con = (Connection) ConexionBD.getConnection();
            String query = "SELECT * FROM usuarios WHERE (email = ? OR nombre = ?) AND password = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setString(1, usuarioInput);
            stmt.setString(2, usuarioInput);
            stmt.setString(3, passwordInput);
            
            ResultSet rs = (ResultSet) stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                    rs.getInt("id"),
                    rs.getString("cuil"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("sexo").charAt(0),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getBoolean("activo"),
                    obtenerRolPorId(rs.getInt("rol_id"))
                );
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }

     public Rol obtenerRolPorId(int rolId) throws Exception {
        Rol rol = null;
        Connection con = null;

        try {
            con = (Connection) ConexionBD.getConnection();
            String query = "SELECT * FROM roles WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            stmt.setInt(1, rolId);
            ResultSet rs = (ResultSet) stmt.executeQuery();

            if (rs.next()) {
                rol = new Rol(
                    rs.getInt("id"),
                    rs.getString("nombre")
                );
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rol;
    }
}