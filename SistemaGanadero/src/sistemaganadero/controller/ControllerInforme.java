/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.controller;

import java.sql.Date;
import java.util.List;
import sistemaganadero.dao.IMortandadDAO;
import sistemaganadero.dao.MockMortandadDAO;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public class ControllerInforme {
    private IMortandadDAO mortandadDAO;

    public ControllerInforme(IMortandadDAO mortandadDAO) {
        this.mortandadDAO = mortandadDAO;
    }
    
    public ControllerInforme() {
    }
    
    public List<Mortandad> obtenerMortandadesPorFechasYEstablecimiento(Date desde, Date hasta, Establecimiento establecimiento) {
        return mortandadDAO.obtenerMortandadesPorFechasYEstablecimiento(desde, hasta, establecimiento);
    }
}
