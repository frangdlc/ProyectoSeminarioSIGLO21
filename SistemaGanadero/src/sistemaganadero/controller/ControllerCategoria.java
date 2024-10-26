/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.util.List;
import sistemaganadero.dao.ICategoriaDAO;
import sistemaganadero.dao.ISubcategoriaDAO;
import sistemaganadero.dao.MockCategoriaDAO;
import sistemaganadero.dao.MockSubcategoriaDAO;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;

/**
 *
 * @author Usuario
 */
public class ControllerCategoria {
    private ICategoriaDAO mockCategoriaDAO;
    private ISubcategoriaDAO mockSubcategoriaDAO;
    
    public ControllerCategoria() {
    }
    
    public ControllerCategoria(ICategoriaDAO mockCategoriaDAO, ISubcategoriaDAO mockSubcategoriaDAO) {
        this.mockCategoriaDAO = mockCategoriaDAO;
        this.mockSubcategoriaDAO = mockSubcategoriaDAO;
    }

    public void agregarCategoria(String nombre, String descripcion) {
        int idNuevo = mockCategoriaDAO.obtenerCategorias().size() + 1;
        mockCategoriaDAO.agregarCategoria(new Categoria(idNuevo, nombre, descripcion));
    }

    public void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion) {
        mockCategoriaDAO.modificarCategoria(id, nuevoNombre, nuevaDescripcion);
    }

    public void eliminarCategoria(int id) {
        mockCategoriaDAO.eliminarCategoria(id);
    }

    public List<Categoria> obtenerCategorias() {
        return mockCategoriaDAO.obtenerCategorias();
    }

    public Categoria obtenerCategoriaPorId(int id) {
        for (Categoria categoria : mockCategoriaDAO.obtenerCategorias()) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria) {
        return mockSubcategoriaDAO.obtenerSubcategoriasPorCategoria(categoria);
    }
}
