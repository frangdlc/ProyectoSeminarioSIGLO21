/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;
import java.sql.SQLException;
import java.util.List;
import sistemaganadero.modelo.Usuario;

/**
 * Esta interfaz define los métodos necesarios para la gestión de usuarios en la capa de acceso a datos. 
 * Proporciona operaciones para obtener información sobre los usuarios registrados en el sistema.
 * @author Francisco de la Cruz v1.0
 */
public interface IUsuarioDAO {
    /**
     * Obtiene una lista de todos los usuarios registrados.
     * 
     * @return List<Usuario> Lista de usuarios disponibles en el sistema.
     */
    List<Usuario> obtenerUsuarios();
    
    /**
     * Autentica a un usuario dado su nombre de usuario o correo electrónico y contraseña.
     * 
     * @param usuarioInput Nombre de usuario o correo electrónico.
     * @param passwordInput Contraseña del usuario.
     * @return Usuario autenticado si las credenciales son válidas; de lo contrario, retorna null.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    Usuario autenticarUsuario(String usuarioInput, String passwordInput) throws SQLException;
}