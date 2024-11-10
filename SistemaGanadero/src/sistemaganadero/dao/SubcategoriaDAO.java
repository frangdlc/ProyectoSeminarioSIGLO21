/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.sql.Connection;
import java.util.ArrayList;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;
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
public class SubcategoriaDAO implements ISubcategoriaDAO {
    private List<Subcategoria> subcategorias;

    public SubcategoriaDAO() {
        subcategorias = new ArrayList<>();
    }

@Override
public List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria) {
    List<Subcategoria> subcategorias = new ArrayList<>();
    String sql = "SELECT id, nombre FROM subcategorias WHERE categoria_id = ?";
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    try {
        con = ConexionBD.getConnection();
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, categoria.getId());

        resultSet = stmt.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            Subcategoria subcategoria = new Subcategoria(id, nombre, categoria);
            subcategorias.add(subcategoria);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return subcategorias;
}
    

    @Override
    public Subcategoria obtenerSubcategoria(int id) {
        return null;
    }
}
