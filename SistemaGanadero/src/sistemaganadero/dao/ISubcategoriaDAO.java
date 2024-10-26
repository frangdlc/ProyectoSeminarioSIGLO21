/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;

/**
 *
 * @author Usuario
 */
public interface ISubcategoriaDAO {
    List<Subcategoria> obtenerSubcategoriasPorCategoria(Categoria categoria);
    Subcategoria obtenerSubcategoria(int id);
}
