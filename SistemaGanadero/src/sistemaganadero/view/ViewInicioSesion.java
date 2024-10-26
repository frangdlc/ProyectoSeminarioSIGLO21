/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.Scanner;
import sistemaganadero.controller.ControllerSistema;
import sistemaganadero.modelo.Usuario;

/**
 *Esta clase se encarga de gestionar la vista para el inicio de sesión de un usuario en el sistema. 
 * Su función principal es permitir que un usuario ingrese su nombre de usuario o correo electrónico y su contraseña para acceder a la aplicación.
 * @author Francisco de la Cruz v1.0
 */
public class ViewInicioSesion {
    
    private ControllerSistema controllerSistema;

    public ViewInicioSesion(ControllerSistema controllerSistema) {
        this.controllerSistema = controllerSistema;
    }
    
/**
 * Este método solicita al usuario que ingrese su nombre de usuario o correo electrónico 
 * y su contraseña. Si las credenciales son correctas, se devuelve un objeto Usuario 
 * que representa al usuario autenticado. Si el usuario decide salir (ingresando 'S' o 's'), 
 * se devuelve null.
 *
 * @return Usuario - El objeto Usuario autenticado si el inicio de sesión es exitoso, 
 *                   o null si el usuario elige salir del proceso.
 */
    public Usuario iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        Usuario usuarioActual = null;
        
        while (usuarioActual == null) {
            System.out.print("Ingrese usuario (nombre o correo) o 'S' para salir: ");
            String usuarioInput = sc.nextLine();
            if (usuarioInput.equalsIgnoreCase("S")) {
                return null;
            }

            System.out.print("Ingrese contraseña o 'S' para salir: ");
            String passwordInput = sc.nextLine();
            if (passwordInput.equalsIgnoreCase("S")) {
                return null;
            }

            usuarioActual = controllerSistema.validarLogin(usuarioInput, passwordInput);
            if (usuarioActual == null) {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }

        return usuarioActual;
    }
}
