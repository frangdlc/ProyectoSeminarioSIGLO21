/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistemaganadero.dao;

import java.sql.Date;
import java.util.List;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public interface IMortandadDAO {
    List<Mortandad> obtenerMortandades();
    List<Mortandad> obtenerMortandadesPorFechasYEstablecimiento(Date desde, Date hasta, Establecimiento establecimiento);
}
