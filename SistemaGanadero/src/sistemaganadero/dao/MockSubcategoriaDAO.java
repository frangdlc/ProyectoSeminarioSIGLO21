/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;
import sistemaganadero.modelo.Subcategoria;

import java.util.ArrayList;
import java.util.List;
import sistemaganadero.modelo.Categoria;

/**
 * Esta clase simula la implementación de la interfaz ISubcategoriaDAO para propósitos de prueba.
 * Proporciona una lista en memoria de subcategorías y métodos para gestionar esas subcategorías sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class MockSubcategoriaDAO implements ISubcategoriaDAO {
    private List<Subcategoria> subcategorias;

    public MockSubcategoriaDAO(ICategoriaDAO mockCategoriaDAO) {
        subcategorias = new ArrayList<>();

        // Asociar subcategorías a las categorías simuladas
        subcategorias.add(new Subcategoria(1, "Servicio", mockCategoriaDAO.obtenerCategoriaPorId(1)));
        subcategorias.add(new Subcategoria(2, "Venta", mockCategoriaDAO.obtenerCategoriaPorId(1)));
        // Asociar subcategorías a las categorías simuladas
        subcategorias.add(new Subcategoria(1, "Servicio", mockCategoriaDAO.obtenerCategoriaPorId(2)));
        subcategorias.add(new Subcategoria(2, "Venta", mockCategoriaDAO.obtenerCategoriaPorId(2)));
        subcategorias.add(new Subcategoria(3, "Cría", mockCategoriaDAO.obtenerCategoriaPorId(2)));        
        // Asociar subcategorías a las categorías simuladas
        subcategorias.add(new Subcategoria(1, "1-2", mockCategoriaDAO.obtenerCategoriaPorId(3)));
        subcategorias.add(new Subcategoria(2, "Venta", mockCategoriaDAO.obtenerCategoriaPorId(3)));
    }

    /**
     * Obtiene subcategorías asociadas a una categoría específica.
     * 
     * @param categoria La categoría para la cual se desean obtener las subcategorías.
     * @return List<Subcategoria> Lista de subcategorías que pertenecen a la categoría especificada.
     */
    public List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria) {
        List<Subcategoria> resultado = new ArrayList<>();
        for (Subcategoria subcategoria : subcategorias) {
            if (subcategoria.getCategoria().getId() == categoria.getId()) {
                resultado.add(subcategoria);
            }
        }
        return resultado;
    }
    
    /**
     * Obtiene una subcategoría por su ID.
     * 
     * @param id ID de la subcategoría a buscar.
     * @return Subcategoria La subcategoría correspondiente al ID, o null si no se encuentra.
     */
    public Subcategoria obtenerSubcategoria(int id) {
        for (Subcategoria subcategoria : subcategorias) {
            if (subcategoria.getId() == id) {
                return subcategoria;
            }
        }
        return null; // Retorna null si no se encuentra el subcategoria con el ID dado
    }
}
