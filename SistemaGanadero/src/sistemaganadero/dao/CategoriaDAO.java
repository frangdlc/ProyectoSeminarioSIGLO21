/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;
import java.sql.PreparedStatement;
import sistemaganadero.modelo.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import conexion.ConexionBD;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CategoriaDAO implements ICategoriaDAO {
 private List<Categoria> categorias;

    public CategoriaDAO() {
        categorias = new ArrayList<>();
    }
    
@Override
public List<Categoria> obtenerCategorias() {
    List<Categoria> categorias = new ArrayList<>();

    Connection con = null;
    
    try {
        // Establecemos la conexión a la base de datos
        con = ConexionBD.getConnection();
        
        // Creamos el PreparedStatement para la consulta SQL
        String sql = "SELECT id, nombre, descripcion FROM categorias";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        // Ejecutamos la consulta
        ResultSet rs = stmt.executeQuery();
        
        // Iteramos sobre el resultado y llenamos la lista de categorías
        while (rs.next()) {
            // Creamos un objeto Categoria y lo llenamos con los datos de la base de datos
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNombre(rs.getString("nombre"));
            categoria.setDescripcion(rs.getString("descripcion"));
            
            // Añadimos la categoría a la lista
            categorias.add(categoria);
        }

        // Cerramos los recursos
        rs.close();
        stmt.close();

    } catch (SQLException e) {
        System.out.println("Error al obtener las categorías: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return categorias;
}

@Override
public Categoria obtenerCategoriaPorId(int id) {
    Connection con = null;
    Categoria categoria = null; // Inicializamos la categoría a null

    try {
        // Establecemos la conexión a la base de datos
        con = ConexionBD.getConnection();
        
        // Creamos el PreparedStatement para la consulta SQL
        String sql = "SELECT id, nombre, descripcion FROM categorias WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id); // Establecemos el ID en el PreparedStatement
        
        // Ejecutamos la consulta
        ResultSet rs = stmt.executeQuery();
        
        // Si hay resultados, creamos la categoría
        if (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNombre(rs.getString("nombre"));
            categoria.setDescripcion(rs.getString("descripcion"));
        }

        // Cerramos los recursos
        rs.close();
        stmt.close();

    } catch (SQLException e) {
        System.out.println("Error al obtener la categoría: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception ex) {
        Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (con != null) {
                con.close(); // Aseguramos que la conexión se cierra
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    return categoria; // Devolvemos la categoría encontrada o null si no se encontró
}
@Override
public void agregarCategoria(Categoria categoria) {
    Connection con = null; // Inicializamos la conexión como null
    
    try {
        if (categoriaExiste(categoria.getNombre())) {
            System.out.println("Error: La categoría '" + categoria.getNombre() + "' ya existe.");
            return; // Salir del método si la categoría ya existe
        }
    } catch (Exception ex) {
        System.out.println("Error al verificar la existencia de la categoría: " + ex.getMessage());
        Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        return; // Salir en caso de excepción en la verificación
    }

    try {
        // Establecemos la conexión a la base de datos
        con = ConexionBD.getConnection();

        String sql = "INSERT INTO categorias (nombre, descripcion) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, categoria.getNombre());
        stmt.setString(2, categoria.getDescripcion());

        int rowsInserted = stmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Categoría agregada correctamente.");
        } else {
            System.out.println("No se pudo agregar la categoría.");
        }
    } catch (SQLException e) {
        System.out.println("Error al agregar la categoría: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception ex) {
        System.out.println("Error inesperado: " + ex.getMessage());
        Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (con != null) {
                con.close(); // Cerramos la conexión
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
@Override
public void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion) {
    Connection con = null;
    try {
        // Establecer la conexión
        con = ConexionBD.getConnection();
        
        String sql = "UPDATE categorias SET nombre = ?, descripcion = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, nuevoNombre);
        stmt.setString(2, nuevaDescripcion);
        stmt.setInt(3, id);
        
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("La categoría ha sido actualizada correctamente en la base de datos.");
        } else {
            System.out.println("No se encontró la categoría con el ID especificado.");
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar la categoría: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception ex) {
         Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
        try {
            if (con != null) {
                con.close(); // Cerrar la conexión
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

@Override
public void eliminarCategoria(int id) {
    Connection con = null;
    PreparedStatement stmtCheckSubcategoria = null;
    PreparedStatement stmtDeleteCategoria = null;

    try {
        // Obtener la conexión a la base de datos
        con = ConexionBD.getConnection();

        // Desactivar el autocommit para manejar la transacción
        con.setAutoCommit(false);

        // Verificar si existen registros de movimientos asociados a las subcategorías de esta categoría
        String sqlCheckSubcategoria = "SELECT COUNT(*) FROM movimientos WHERE subcategoria_id IN (SELECT id FROM subcategorias WHERE categoria_id = ?)";
        stmtCheckSubcategoria = con.prepareStatement(sqlCheckSubcategoria);
        stmtCheckSubcategoria.setInt(1, id);
        
        ResultSet rs = stmtCheckSubcategoria.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("No se puede eliminar la categoría porque tiene subcategorías en uso.");
            con.rollback(); // Deshacer cualquier cambio realizado
            return; // Salir del método sin eliminar
        }

        // Luego, eliminar la categoría (las subcategorías se eliminarán automáticamente)
        String sqlDeleteCategoria = "DELETE FROM categorias WHERE id = ?";
        stmtDeleteCategoria = con.prepareStatement(sqlDeleteCategoria);
        stmtDeleteCategoria.setInt(1, id);
        int rowsDeleted = stmtDeleteCategoria.executeUpdate();

        // Confirmar la transacción si todo fue exitoso
        con.commit();

        if (rowsDeleted > 0) {
            System.out.println("Categoría eliminada exitosamente, junto con sus subcategorías.");
        } else {
            System.out.println("No se encontró la categoría con el ID especificado.");
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar la categoría: " + e.getMessage());
        e.printStackTrace();
        try {
            // Realizar rollback si hay algún error
            if (con != null) con.rollback();
            System.out.println("Se deshicieron los cambios debido a un error.");
        } catch (SQLException rollbackEx) {
            System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
        }
    } catch (Exception ex) {
         Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
     } finally {
        // Cerrar los recursos
        try {
            if (stmtCheckSubcategoria != null) stmtCheckSubcategoria.close();
            if (stmtDeleteCategoria != null) stmtDeleteCategoria.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar los recursos: " + e.getMessage());
        }
    }
}
    
    public boolean categoriaExiste(String nombre) throws Exception {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        con = (Connection) ConexionBD.getConnection();
        String sql = "SELECT COUNT(*) FROM categorias WHERE nombre = ?";
        stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, nombre);
        
        rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Devuelve true si existe
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar la existencia de la categoría: " + e.getMessage());
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar los recursos: " + e.getMessage());
        }
    }
    return false; // Devuelve false si no se encontró
}
    
}
