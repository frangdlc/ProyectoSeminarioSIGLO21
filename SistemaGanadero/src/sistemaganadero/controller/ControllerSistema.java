/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sistemaganadero.dao.IUsuarioDAO;
import sistemaganadero.dao.IUsuarioEstablecimientoDAO;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.view.ViewEstablecimiento;

/**
 * Esta clase actúa como controlador en el patrón MVC (Modelo-Vista-Controlador) para gestionar la lógica del sistema ganadero. 
 * Se encarga de validar el inicio de sesión de los usuarios y de permitir la selección de un establecimiento asociado a un usuario.
 * 
 * @author Francisco de la Cruz v1.0
 */
public class ControllerSistema {
    private IUsuarioDAO usuarioDAO;

    public ControllerSistema(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
/**
* Valida el inicio de sesión de un usuario.
* Este método verifica si el nombre de usuario o el correo electrónico ingresado coincide con un usuario en la lista de usuarios y si la contraseña es correcta.
* 
* @param usuarioInput Nombre de usuario o correo electrónico ingresado.
* @param passwordInput Contraseña ingresada.
* @return Usuario si las credenciales son válidas; de lo contrario, retorna null.
*/    

public Usuario validarLogin(String usuarioInput, String passwordInput) {
    try {
        return usuarioDAO.autenticarUsuario(usuarioInput, passwordInput);
    } catch (SQLException e) {
        System.err.println("Error al autenticar usuario: " + e.getMessage());
        return null;
    }
}

}