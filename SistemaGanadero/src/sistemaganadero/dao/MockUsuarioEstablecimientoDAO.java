/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Esta clase simula la implementación de la interfaz IUsuarioEstablecimientoDAO para propósitos de prueba.
 * Proporciona una representación en memoria de las relaciones entre usuarios y establecimientos, utilizando una estructura de datos que simula una relación muchos a muchos.
 * @author Francisco de la Cruz v1.0
 */
public class MockUsuarioEstablecimientoDAO implements IUsuarioEstablecimientoDAO{
       // Simula la relación muchos a muchos: usuario_id -> lista de establecimiento_id
    private Map<Integer, List<Integer>> usuarioEstablecimientos;

    public MockUsuarioEstablecimientoDAO() {
        this.usuarioEstablecimientos = new HashMap<>();

        // Simulo algunas relaciones de ejemplo
        agregarRelacion(1, 1); 
        agregarRelacion(2, 2); 
        agregarRelacion(3, 2);
        agregarRelacion(4, 1);
        agregarRelacion(5, 1);
        agregarRelacion(6, 2);
        agregarRelacion(7, 2);
        agregarRelacion(8, 2);
        agregarRelacion(8, 1);
    }

    /**
     * Agrega una relación entre un usuario y un establecimiento.
     * 
     * @param usuarioId ID del usuario.
     * @param establecimientoId ID del establecimiento.
     */
    public void agregarRelacion(int usuarioId, int establecimientoId) {
        usuarioEstablecimientos.putIfAbsent(usuarioId, new ArrayList<>());
        usuarioEstablecimientos.get(usuarioId).add(establecimientoId);
    }

    /**
     * Elimina una relación entre un usuario y un establecimiento.
     * 
     * @param usuarioId ID del usuario.
     * @param establecimientoId ID del establecimiento.
     */
    public void eliminarRelacion(int usuarioId, int establecimientoId) {
        if (usuarioEstablecimientos.containsKey(usuarioId)) {
            usuarioEstablecimientos.get(usuarioId).remove((Integer) establecimientoId);
        }
    }

    /**
     * Obtiene la lista de establecimientos asociados a un usuario específico.
     * 
     * @param usuarioId ID del usuario.
     * @return List<Integer> Lista de IDs de establecimientos asociados al usuario.
     */
    public List<Integer> obtenerEstablecimientosPorUsuario(int usuarioId) {
        return usuarioEstablecimientos.getOrDefault(usuarioId, new ArrayList<>());
    }
}
