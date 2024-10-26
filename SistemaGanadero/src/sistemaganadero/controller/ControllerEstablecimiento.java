/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.util.ArrayList;
import java.util.List;
import sistemaganadero.dao.IEstablecimientoDAO;
import sistemaganadero.dao.IUsuarioEstablecimientoDAO;
import sistemaganadero.dao.MockEstablecimientoDAO;
import sistemaganadero.dao.MockUsuarioEstablecimientoDAO;
import sistemaganadero.modelo.Establecimiento;
/**
 *
 * @author Usuario
 */
public class ControllerEstablecimiento {
    private IEstablecimientoDAO establecimientoDAO;

    public ControllerEstablecimiento(IEstablecimientoDAO establecimientoDAO) {
        this.establecimientoDAO = establecimientoDAO;
    }
    public ControllerEstablecimiento() {
    }
    
    public List<Establecimiento> obtenerEstablecimientosPorUsuario(int usuarioId, IUsuarioEstablecimientoDAO usuarioEstablecimientoDAO) {
        List<Integer> idsEstablecimientos = usuarioEstablecimientoDAO.obtenerEstablecimientosPorUsuario(usuarioId);
        List<Establecimiento> establecimientos = new ArrayList<>();
        
        for (Integer id : idsEstablecimientos) {
            Establecimiento est = establecimientoDAO.obtenerEstablecimiento(id);
            if (est != null) {
                establecimientos.add(est);
            }
        }
        return establecimientos;
    }
}