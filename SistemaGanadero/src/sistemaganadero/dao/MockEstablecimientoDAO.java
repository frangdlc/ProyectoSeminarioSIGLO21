/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;
import java.util.ArrayList;
import java.util.List;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public class MockEstablecimientoDAO implements IEstablecimientoDAO {
    private List<Establecimiento> establecimientos;

    public MockEstablecimientoDAO() {
        establecimientos = new ArrayList<>();
        
        // Agregar datos simulados de establecimientos
        establecimientos.add(new Establecimiento(1, "La Grande del Sud", 1000));
        establecimientos.add(new Establecimiento(2, "Los Pirulos", 600));
    }

    // Método para obtener todos los establecimientos simulados
    public List<Establecimiento> obtenerEstablecimientos() {
        return establecimientos;
    }
    
        public Establecimiento obtenerEstablecimiento(int id) {
        for (Establecimiento establecimiento : establecimientos) {
            if (establecimiento.getId() == id) {
                return establecimiento;
            }
        }
        return null; // Retorna null si no se encuentra el establecimiento con el ID dado
    }
}
