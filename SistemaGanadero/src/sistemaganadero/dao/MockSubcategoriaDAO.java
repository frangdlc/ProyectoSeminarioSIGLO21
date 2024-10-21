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
 *
 * @author Usuario
 */
public class MockSubcategoriaDAO {
    private List<Subcategoria> subcategorias;

    public MockSubcategoriaDAO(MockCategoriaDAO mockCategoriaDAO) {
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

    // Obtener subcategorías por categoría
    public List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria) {
        List<Subcategoria> resultado = new ArrayList<>();
        for (Subcategoria subcategoria : subcategorias) {
            if (subcategoria.getCategoria().getId() == categoria.getId()) {
                resultado.add(subcategoria);
            }
        }
        return resultado;
    }
    
    public Subcategoria obtenerSubcategoria(int id) {
        for (Subcategoria subcategoria : subcategorias) {
            if (subcategoria.getId() == id) {
                return subcategoria;
            }
        }
        return null; // Retorna null si no se encuentra el subcategoria con el ID dado
    }
}
