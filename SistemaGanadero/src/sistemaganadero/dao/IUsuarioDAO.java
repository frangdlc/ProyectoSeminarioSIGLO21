/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Usuario;

/**
 * Esta interfaz define los métodos necesarios para la gestión de usuarios en la capa de acceso a datos. 
 * Proporciona operaciones para obtener información sobre los usuarios registrados en el sistema.
 * @author Francisco de la Cruz v1.0
 */
public interface IUsuarioDAO {
    /**
     * Obtiene una lista de todos los usuarios registrados.
     * 
     * @return List<Usuario> Lista de usuarios disponibles en el sistema.
     */
        List<Usuario> obtenerUsuarios();
}
