/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.util.ArrayList;
import java.util.List;
import sistemaganadero.modelo.Categoria;

/**
 *
 * @author Usuario
 */
public class MockCategoriaDAO implements ICategoriaDAO {
    private List<Categoria> categorias;

    public MockCategoriaDAO() {
        categorias = new ArrayList<>();

        // Agregamos categorías simuladas
        categorias.add(new Categoria(1, "Toros", "descripcion Toros"));
        categorias.add(new Categoria(2, "Vacas", "descripcion Vacas"));
        categorias.add(new Categoria(3, "Novillos", "descripcion Novillos"));
    }

    // Obtener todas las categorías
    public List<Categoria> obtenerCategorias() {
        return categorias;
    }

    // Agregar una nueva categoría
    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    // Modificar una categoría existente
    public void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                categoria.setNombre(nuevoNombre);
                categoria.setDescripcion(nuevaDescripcion);
                break;
            }
        }
    }

    // Eliminar una categoría
    public void eliminarCategoria(int id) {
        categorias.removeIf(categoria -> categoria.getId() == id);
    }
 
    public Categoria obtenerCategoriaPorId(int id) {
    for (Categoria categoria : categorias) {
        if (categoria.getId() == id) {
            return categoria;
        }
    }
    return null; // Si no se encuentra la categoría
    }
}
