/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Establecimiento;

/**
 *Esta interfaz define los métodos necesarios para la gestión de establecimientos en la capa de acceso a datos. 
 * Proporciona operaciones para obtener información sobre los establecimientos.
 * @author Francisco de la Cruz v1.0
 */
public interface IEstablecimientoDAO {
    /**
     * Obtiene una lista de todos los establecimientos.
     * 
     * @return List<Establecimiento> Lista de establecimientos disponibles.
     */
    List<Establecimiento> obtenerEstablecimientos();
    
    /**
     * Obtiene un establecimiento por su ID.
     * 
     * @param id ID del establecimiento a buscar.
     * @return Establecimiento El establecimiento correspondiente al ID, o null si no se encuentra.
     */
    Establecimiento obtenerEstablecimiento(int id);
}
