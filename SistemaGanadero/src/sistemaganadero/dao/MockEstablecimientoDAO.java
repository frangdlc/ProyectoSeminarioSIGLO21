/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;
import java.util.ArrayList;
import java.util.List;
import sistemaganadero.modelo.Establecimiento;

/**
 * Esta clase simula la implementación de la interfaz IEstablecimientoDAO para propósitos de prueba.
 * Proporciona una lista en memoria de establecimientos y métodos para gestionar esos establecimientos sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class MockEstablecimientoDAO implements IEstablecimientoDAO {
    private List<Establecimiento> establecimientos;

    public MockEstablecimientoDAO() {
        establecimientos = new ArrayList<>();
        
        // Agregar datos simulados de establecimientos
        establecimientos.add(new Establecimiento(1, "La Grande del Sud", 1000));
        establecimientos.add(new Establecimiento(2, "Los Pirulos", 600));
    }

    /**
     * Obtiene todos los establecimientos simulados.
     * 
     * @return List<Establecimiento> Lista de todos los establecimientos disponibles.
     */
    public List<Establecimiento> obtenerEstablecimientos() {
        return establecimientos;
    }
    /**
     * Obtiene un establecimiento por su ID.
     * 
     * @param id ID del establecimiento a buscar.
     * @return Establecimiento El establecimiento correspondiente al ID, o null si no se encuentra.
     */
    public Establecimiento obtenerEstablecimiento(int id) {
        for (Establecimiento establecimiento : establecimientos) {
            if (establecimiento.getId() == id) {
                return establecimiento;
            }
        }
        return null; // Retorna null si no se encuentra el establecimiento con el ID dado
    }
}
