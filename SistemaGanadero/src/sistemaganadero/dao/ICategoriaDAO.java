/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Categoria;

/**
 *
 * @author Usuario
 */
public interface ICategoriaDAO {
    List<Categoria> obtenerCategorias();
    Categoria obtenerCategoriaPorId(int id);
    void agregarCategoria(Categoria categoria);
    void modificarCategoria(int id, String nuevoNombre, String nuevaDescripcion);
    void eliminarCategoria(int id);
}
