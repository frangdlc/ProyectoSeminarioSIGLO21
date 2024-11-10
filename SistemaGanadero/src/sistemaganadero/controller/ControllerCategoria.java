/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.util.List;
import sistemaganadero.dao.ICategoriaDAO;
import sistemaganadero.dao.ISubcategoriaDAO;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;
import sistemaganadero.dao.CategoriaDAO;

/**
 * Esta clase actúa como controlador en el patrón MVC (Modelo-Vista-Controlador) para gestionar a lógica relacionada con las categorías y subcategorías. 
 * Se encarga de interactuar con la capa de acceso a datos para realizar operaciones CRUD sobre las categorías 
 * y para obtener subcategorías asociadas a una categoría específica.
 * @author Francisco de la Cruz v1.0
 */
public class ControllerCategoria {
    private ICategoriaDAO categoriaDAO;
    private ISubcategoriaDAO subcategoriaDAO;
    
    public ControllerCategoria(ICategoriaDAO categoriaDAO, ISubcategoriaDAO subcategoriaDAO) {
        this.categoriaDAO = categoriaDAO;
        this.subcategoriaDAO = subcategoriaDAO;
    }
    public ControllerCategoria() {
    }
    
    public ControllerCategoria(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
/**
* Este método crea una nueva categoría con un ID único, nombre y descripción, y la agrega
* a la lista de categorías utilizando el DAO correspondiente.
* 
* @param nombre Nombre de la nueva categoría.
* @param descripcion Descripción de la nueva categoría.
*/
    public void agregarCategoria(String nombre, String descripcion) {
        Categoria nuevaCategoria = new Categoria(nombre, descripcion);
        categoriaDAO.agregarCategoria(nuevaCategoria);
    }
    
/** 
* Este método actualiza el nombre y la descripción de una categoría existente en función
* del ID proporcionado.
* 
* @param id ID de la categoría a modificar.
* @param nuevoNombre Nuevo nombre para la categoría.
* @param nuevaDescripcion Nueva descripción para la categoría.
*/
    public void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion) {
        categoriaDAO.modificarCategoria(id, nuevoNombre, nuevaDescripcion);
    }
    
/**
* Elimina una categoría.
* 
* Este método elimina una categoría existente en función del ID proporcionado.
* @param id ID de la categoría a eliminar.
*/
    public void eliminarCategoria(int id) {
        categoriaDAO.eliminarCategoria(id);
    }

/**
* Obtiene una lista de todas las categorías.
* 
* Este método devuelve una lista de todas las categorías disponibles utilizando el DAO correspondiente.
* @return List<Categoria> Lista de categorías.
*/    
    public List<Categoria> obtenerCategorias() {
        return categoriaDAO.obtenerCategorias();
    }

/**
* Obtiene una categoría por su ID.
* 
* Este método busca y devuelve la categoría correspondiente al ID proporcionado.
* 
* @param id ID de la categoría a buscar.
* @return Categoria La categoría correspondiente al ID, o null si no se encuentra.
*/
public Categoria obtenerCategoriaPorId(int id) {
    return categoriaDAO.obtenerCategoriaPorId(id);
}

/**
* Obtiene una lista de subcategorías asociadas a una categoría específica.
* Este método utiliza el DAO de subcategorías para recuperar las subcategorías que pertenecen a la categoría proporcionada.
* 
* @param categoria La categoría para la cual se desean obtener las subcategorías.
* @return List<Subcategoria> Lista de subcategorías asociadas a la categoría especificada.
*/
    public List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria) {
        return subcategoriaDAO.obtenerSubcategoriasPorCategoria(categoria);
    }
}
