/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;

/**
 * Esta interfaz define los métodos necesarios para la gestión de subcategorías en la capa de acceso a datos. 
 * Proporciona operaciones para obtener información sobre las subcategorías asociadas a una categoría específica.
 * @author Francisco de la Cruz v1.0
 */
public interface ISubcategoriaDAO {
    
    /**
     * Obtiene una lista de subcategorías asociadas a una categoría específica.
     * 
     * @param categoria La categoría de la cual se desean obtener las subcategorías.
     * @return List<Subcategoria> Lista de subcategorías asociadas a la categoría proporcionada.
     */
    List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria);

    /**
     * Obtiene una subcategoría por su ID.
     * 
     * @param id ID de la subcategoría a buscar.
     * @return Subcategoria La subcategoría correspondiente al ID, o null si no se encuentra.
     */
    Subcategoria obtenerSubcategoria(int id);
}
