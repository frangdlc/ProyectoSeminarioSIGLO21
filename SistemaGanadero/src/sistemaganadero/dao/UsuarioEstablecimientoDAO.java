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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class UsuarioEstablecimientoDAO implements IUsuarioEstablecimientoDAO{

    @Override
    public void agregarRelacion(int usuarioId, int establecimientoId) {
    }

    @Override
    public void eliminarRelacion(int usuarioId, int establecimientoId) {
    }

    @Override
    public List<Integer> obtenerEstablecimientosPorUsuario(int usuarioId) {
            List<Integer> idsEstablecimientos = new ArrayList<>();
            Connection con = null;

            String query = "SELECT establecimiento_id FROM usuarios_establecimientos WHERE usuario_id = ?";

            try {
                con = (Connection) ConexionBD.getConnection();
                PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);


                stmt.setInt(1, usuarioId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        idsEstablecimientos.add(rs.getInt("establecimiento_id"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception ex) {
            Logger.getLogger(UsuarioEstablecimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return idsEstablecimientos;
    }
    
}
