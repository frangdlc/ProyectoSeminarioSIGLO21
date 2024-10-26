/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.Scanner;
import sistemaganadero.controller.ControllerSistema;
import sistemaganadero.modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class ViewInicioSesion {
    
    private ControllerSistema controllerSistema;

    public ViewInicioSesion(ControllerSistema controllerSistema) {
        this.controllerSistema = controllerSistema;
    }

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
