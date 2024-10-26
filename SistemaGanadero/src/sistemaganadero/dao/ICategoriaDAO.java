/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Categoria;

/**
 * Esta interfaz define los métodos necesarios para la gestión de categorías en la capa de acceso a datos. 
 * Proporciona operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para las categorías.
 * @author Francisco de la Cruz v1.0
 */
public interface ICategoriaDAO {
    /**
     * Obtiene una lista de todas las categorías.
     * 
     * @return List<Categoria> Lista de categorías disponibles.
     */
    List<Categoria> obtenerCategorias();
    
    /**
     * Obtiene una categoría por su ID.
     * 
     * @param id ID de la categoría a buscar.
     * @return Categoria La categoría correspondiente al ID, o null si no se encuentra.
     */
    Categoria obtenerCategoriaPorId(int id);
    
    /**
     * Agrega una nueva categoría.
     * 
     * Este método permite agregar una nueva categoría a la base de datos.
     * 
     * @param categoria La categoría a agregar.
     */
    void agregarCategoria(Categoria categoria);
    
    /**
     * Modifica una categoría existente.
     * 
     * Este método actualiza el nombre y la descripción de una categoría existente en función
     * del ID proporcionado.
     * 
     * @param id ID de la categoría a modificar.
     * @param nuevoNombre Nuevo nombre para la categoría.
     * @param nuevaDescripcion Nueva descripción para la categoría.
     */
    void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion);
    
    /**
     * Elimina una categoría.
     * 
     * Este método elimina una categoría existente en función del ID proporcionado.
     * 
     * @param id ID de la categoría a eliminar.
     */
    void eliminarCategoria(int id);
}
