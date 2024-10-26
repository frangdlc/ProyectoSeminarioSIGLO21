/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.util.List;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public interface IEstablecimientoDAO {
    List<Establecimiento> obtenerEstablecimientos();
    Establecimiento obtenerEstablecimiento(int id);
}
