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
 *
 * @author Usuario
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
    
    public Usuario validarLogin(String usuarioInput, String passwordInput) {
        for (Usuario usuario : usuarios) {
            if ((usuario.getNombre().equals(usuarioInput) || usuario.getEmail().equals(usuarioInput)) &&
                    usuario.getPassword().equals(passwordInput)) {
                return usuario;
            }
        }
        return null;
    }

    public Establecimiento seleccionarEstablecimiento(Usuario usuarioActual, ViewEstablecimiento viewEstablecimiento) {
        return viewEstablecimiento.seleccionarEstablecimiento(usuarioActual.getId(), usuarioEstablecimientoDAO);
    }
}