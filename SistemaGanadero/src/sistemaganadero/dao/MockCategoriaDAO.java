/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.util.ArrayList;
import java.util.List;
import sistemaganadero.modelo.Categoria;

/**
 * Esta clase simula la implementación de la interfaz ICategoriaDAO para propósitos de prueba.
 * Proporciona una lista en memoria de categorías y métodos para gestionar esas categorías sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class MockCategoriaDAO implements ICategoriaDAO {
    private List<Categoria> categorias;

    public MockCategoriaDAO() {
        categorias = new ArrayList<>();

        // Agregar categorías simuladas
        categorias.add(new Categoria(1, "Toros", "descripcion Toros"));
        categorias.add(new Categoria(2, "Vacas", "descripcion Vacas"));
        categorias.add(new Categoria(3, "Novillos", "descripcion Novillos"));
    }

    /**
     * Obtiene todas las categorías.
     * 
     * @return List<Categoria> Lista de todas las categorías disponibles.
     */
    public List<Categoria> obtenerCategorias() {
        return categorias;
    }

    /**
     * Agrega una nueva categoría.
     * 
     * @param categoria La categoría que se desea agregar.
     */
    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    /**
     * Modifica una categoría existente.
     * 
     * @param id ID de la categoría a modificar.
     * @param nuevoNombre Nuevo nombre para la categoría.
     * @param nuevaDescripcion Nueva descripción para la categoría.
     */
    public void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                categoria.setNombre(nuevoNombre);
                categoria.setDescripcion(nuevaDescripcion);
                break;
            }
        }
    }

    /**
     * Elimina una categoría.
     * 
     * @param id ID de la categoría que se desea eliminar.
     */
    public void eliminarCategoria(int id) {
        categorias.removeIf(categoria -> categoria.getId() == id);
    }
    
    /**
     * Obtiene una categoría por su ID.
     * 
     * @param id ID de la categoría a buscar.
     * @return Categoria La categoría correspondiente al ID, o null si no se encuentra.
     */
    public Categoria obtenerCategoriaPorId(int id) {
    for (Categoria categoria : categorias) {
        if (categoria.getId() == id) {
            return categoria;
        }
    }
    return null; // Si no se encuentra la categoría
    }
}
