/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;

/**
 * Esta interfaz define los métodos necesarios para gestionar las relaciones entre usuarios y establecimientos en la capa de acceso a datos. 
 * Proporciona operaciones para agregar, eliminar y obtener información sobre estas relaciones.
 * @author Francisco de la Cruz v1.0
 */
public interface IUsuarioEstablecimientoDAO {
    
    /**
     * Agrega una relación entre un usuario y un establecimiento.
     * 
     * @param usuarioId ID del usuario al que se le desea asociar el establecimiento.
     * @param establecimientoId ID del establecimiento que se desea asociar al usuario.
     */
    void agregarRelacion(int usuarioId, int establecimientoId);
    
    /**
     * Elimina una relación entre un usuario y un establecimiento.
     * 
     * @param usuarioId ID del usuario cuya relación con el establecimiento se desea eliminar.
     * @param establecimientoId ID del establecimiento cuya relación con el usuario se desea eliminar.
     */
    void eliminarRelacion(int usuarioId, int establecimientoId);
    
    /**
     * Obtiene una lista de IDs de establecimientos asociados a un usuario específico.
     * 
     * @param usuarioId ID del usuario del cual se desean obtener los establecimientos asociados.
     * @return List<Integer> Lista de IDs de establecimientos asociados al usuario.
     */   
    List<Integer> obtenerEstablecimientosPorUsuario(int usuarioId);
}
