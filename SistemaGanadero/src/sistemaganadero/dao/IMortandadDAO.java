/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.sql.Date;
import java.util.List;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Establecimiento;

/**
 * Esta interfaz define los métodos necesarios para la gestión de mortandades en la capa de acceso a datos. 
 * Proporciona operaciones para obtener información sobre las mortandades registradas.
 * @author Francisco de la Cruz v1.0
 */
public interface IMortandadDAO {
    /**
     * Obtiene una lista de todas las mortandades registradas.
     * 
     * @return List<Mortandad> Lista de mortandades disponibles.
     */
    List<Mortandad> obtenerMortandades();
    
    /**
     * Obtiene una lista de mortandades filtradas por un rango de fechas y un establecimiento específico.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @param establecimiento El establecimiento del cual se desean obtener las mortandades.
     * @return List<Mortandad> Lista de mortandades que cumplen con los criterios especificados.
     */
    List<Mortandad> obtenerMortandadesPorFechasYEstablecimiento(Date desde, Date hasta, Establecimiento establecimiento);
}
