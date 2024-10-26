/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IUsuarioEstablecimientoDAO {
    void agregarRelacion(int usuarioId, int establecimientoId);
    void eliminarRelacion(int usuarioId, int establecimientoId);
    List<Integer> obtenerEstablecimientosPorUsuario(int usuarioId);
}
