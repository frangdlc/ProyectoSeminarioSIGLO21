/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.util.ArrayList;
import java.util.List;
import sistemaganadero.dao.IEstablecimientoDAO;
import sistemaganadero.dao.IUsuarioEstablecimientoDAO;
import sistemaganadero.modelo.Establecimiento;

/**
 * Esta clase actúa como controlador en el patrón MVC (Modelo-Vista-Controlador) para gestionar la lógica relacionada con los establecimientos. 
 * Se encarga de interactuar con la capa de acceso a datos para obtener información.
 * @author Francisco de la Cruz v1.0
 */
public class ControllerEstablecimiento {
    private IEstablecimientoDAO establecimientoDAO;

    public ControllerEstablecimiento(IEstablecimientoDAO establecimientoDAO) {
        this.establecimientoDAO = establecimientoDAO;
    }
    public ControllerEstablecimiento() {
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