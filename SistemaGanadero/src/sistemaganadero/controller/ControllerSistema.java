/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.util.List;
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
    private List<Usuario> usuarios;
    private IUsuarioEstablecimientoDAO usuarioEstablecimientoDAO;

    public ControllerSistema(List<Usuario> usuarios, IUsuarioEstablecimientoDAO usuarioEstablecimientoDAO) {
        this.usuarios = usuarios;
        this.usuarioEstablecimientoDAO = usuarioEstablecimientoDAO;
    }
    
    public ControllerSistema() {

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
        for (Usuario usuario : usuarios) {
            if ((usuario.getNombre().equals(usuarioInput) || usuario.getEmail().equals(usuarioInput)) &&
                    usuario.getPassword().equals(passwordInput)) {
                return usuario;
            }
        }
        return null;
    }

    
/**
* Permite al usuario seleccionar un establecimiento.
* 
* Este método utiliza la vista de establecimiento para permitir que el usuario actual seleccione uno de los establecimientos asociados a su cuenta.
* 
* @param usuarioActual El usuario que está intentando seleccionar un establecimiento.
* @param viewEstablecimiento La vista que proporciona la interfaz para seleccionar un establecimiento.
* @return Establecimiento seleccionado por el usuario; puede ser null si no se selecciona ninguno.
*/
    public Establecimiento seleccionarEstablecimiento(Usuario usuarioActual, ViewEstablecimiento viewEstablecimiento) {
        return viewEstablecimiento.seleccionarEstablecimiento(usuarioActual.getId(), usuarioEstablecimientoDAO);
    }
}