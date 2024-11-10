/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.sql.Date;
import java.util.List;
import sistemaganadero.dao.IMortandadDAO;
import sistemaganadero.dao.IMovimientoDAO;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.view.ViewMortandad;

/**
 * Esta clase actúa como controlador en el patrón MVC (Modelo-Vista-Controlador) para gestionar la lógica relacionada con informes de mortandad. 
 * Se encarga de interactuar con la capa de acceso a datos para obtener información.
 * @author Francisco de la Cruz v1.0
 */
public class ControllerInforme {
    private IMovimientoDAO movimientoDAO;
    private ControllerInforme informe;

    public ControllerInforme(IMovimientoDAO movimientoDAO) {
        this.movimientoDAO = movimientoDAO;
    }
    
    public ControllerInforme() {
    }
    
/**
* Obtiene una lista de mortandades en un establecimiento dentro de un rango de fechas.
* 
* Este método utiliza el DAO de mortandad para recuperar los registros de mortandad que se encuentran entre las fechas especificadas para un establecimiento determinado.
* 
* @param desde Fecha de inicio del rango (inclusive).
* @param hasta Fecha de fin del rango (inclusive).
* @param establecimiento El establecimiento para el cual se desea obtener los datos de mortandad.
* @return List<Mortandad> Lista de mortandades que cumplen con los criterios especificados.
*/
    public void mostrarInformeMortandad(Establecimiento establecimiento) {
        ViewMortandad viewMortandad = new ViewMortandad(this);
        viewMortandad.mostrarInformeMortandad(establecimiento);
    }

    public List<Mortandad> obtenerMovimientosMortandad(Date desde, Date hasta, Establecimiento establecimiento) {
        if (desde.after(hasta)) {
            throw new IllegalArgumentException("La fecha 'desde' no puede ser mayor que la fecha 'hasta'.");
        }
        return movimientoDAO.obtenerMovimientosMortandad(desde, hasta, establecimiento);
    }
}
