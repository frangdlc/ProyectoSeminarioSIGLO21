/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.modelo.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.ConexionBD;
import java.util.ArrayList;
import java.util.Calendar;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Rol;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Subcategoria;

/**
 *
 * @author Usuario
 */
public class MovimientoDAO implements IMovimientoDAO {
    private List<Movimiento> movimientos = new ArrayList<>();

    /**
     * Obtiene todos los movimientos simulados.
     * 
     * @return List<Movimiento> Lista de todos los movimientos disponibles.
     */
    public List<Movimiento> obtenerMovimientos() {
        return movimientos;
    }
    
    /**
     * Obtiene movimientos filtrados por fechas y establecimiento.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @param establecimiento Establecimiento para filtrar los movimientos.
     * @return List<Movimiento> Lista de movimientos que cumplen con los criterios de búsqueda.
     */
      
@Override
public List<Mortandad> obtenerMovimientosMortandad(Date desde, Date hasta, Establecimiento establecimiento) {
    List<Mortandad> mortandades = new ArrayList<>();
        
    String sql = "SELECT m.id AS movimiento_id, m.fecha, m.cantidad, " +
                 "mort.causa, mort.numero_trazabilidad, " +
                 "subcat.nombre AS subcategoria_nombre, cat.nombre AS categoria_nombre " +
                 "FROM movimientos m " +
                 "JOIN mortandades mort ON m.id = mort.movimiento_id " +
                 "JOIN subcategorias subcat ON m.subcategoria_id = subcat.id " +
                 "JOIN categorias cat ON subcat.categoria_id = cat.id " +
                 "WHERE m.establecimiento_id = ? AND m.fecha BETWEEN ? AND ?";
    
    Connection con = null;

    try {
        con = ConexionBD.getConnection();
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, establecimiento.getId());
        stmt.setDate(2, new java.sql.Date(desde.getTime()));
        stmt.setDate(3, new java.sql.Date(hasta.getTime()));
        
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int movimientoId = rs.getInt("movimiento_id");
                Date fecha = rs.getDate("fecha");
                int cantidad = rs.getInt("cantidad");
                String causa = rs.getString("causa");
                String numeroTrazabilidad = rs.getString("numero_trazabilidad");
                String subcategoriaNombre = rs.getString("subcategoria_nombre");
                String categoriaNombre = rs.getString("categoria_nombre");

                Categoria categoria = new Categoria(categoriaNombre, "");
                Subcategoria subcategoria = new Subcategoria(subcategoriaNombre, categoria);
                Movimiento movimiento = new Movimiento(movimientoId, cantidad, fecha, null, subcategoria);
                Mortandad mortandad = new Mortandad(movimientoId, causa, numeroTrazabilidad, movimiento, cantidad, fecha, null, subcategoria);
                
                mortandades.add(mortandad);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(MovimientoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    Collections.sort(mortandades, Comparator.comparing(Mortandad::getFecha));

    return mortandades;
}
}
