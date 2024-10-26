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
* Obtiene una lista de establecimientos asociados a un usuario específico.
* 
* Este método utiliza el DAO de usuario-establecimiento para recuperar los IDs de los establecimientos asociados al usuario, 
* y luego utiliza el DAO de establecimiento para obtener los detalles de cada establecimiento.
* 
* @param usuarioId ID del usuario para el cual se desea obtener los establecimientos.
* @param usuarioEstablecimientoDAO Interfaz para acceder a la relación entre usuarios y establecimientos.
* @return List<Establecimiento> Lista de establecimientos asociados al usuario especificado.
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