/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import sistemaganadero.modelo.Establecimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Rol;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Usuario
 */
public class EstablecimientoDAO implements IEstablecimientoDAO {

    @Override
    public List<Establecimiento> obtenerEstablecimientos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Establecimiento obtenerEstablecimiento(int id) {
        Establecimiento establecimiento = null;
        Connection con = null;

        String query = "SELECT id, nombre, cantidad_hectareas FROM establecimientos WHERE id = ?";

        try  {
            con = (Connection) ConexionBD.getConnection();
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    establecimiento = new Establecimiento(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("cantidad_hectareas")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(EstablecimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return establecimiento;
    }
    
}
