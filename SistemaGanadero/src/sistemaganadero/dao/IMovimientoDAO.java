/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.sql.Date;
import java.util.List;
import sistemaganadero.modelo.Movimiento;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.modelo.Mortandad;

/**
 * Esta interfaz define los métodos necesarios para la gestión de movimientos en la capa de acceso a datos. 
 * Proporciona operaciones para obtener información sobre los movimientos registrados.
 * @author Francisco de la Cruz v1.0
 */
public interface IMovimientoDAO {
    /**
     * Obtiene una lista de todos los movimientos registrados.
     * 
     * @return List<Movimiento> Lista de movimientos disponibles.
     */
    List<Movimiento> obtenerMovimientos();
    
    /**
     * Obtiene una lista de movimientos filtrados por un rango de fechas y un establecimiento específico.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @param establecimiento El establecimiento del cual se desean obtener los movimientos.
     * @return List<Movimiento> Lista de movimientos que cumplen con los criterios especificados.
     */
    List<Mortandad> obtenerMovimientosMortandad(Date desde, Date hasta, Establecimiento establecimiento);
}
