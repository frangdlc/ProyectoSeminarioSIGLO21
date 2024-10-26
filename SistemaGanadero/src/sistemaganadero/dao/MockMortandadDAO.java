/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.modelo.Movimiento;

/**
 * Esta clase simula la implementación de la interfaz IMortandadDAO para propósitos de prueba.
 * Proporciona una lista en memoria de mortandades y métodos para gestionar esas mortandades sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class MockMortandadDAO implements IMortandadDAO {
    private List<Mortandad> mortandades = new ArrayList<>();

    public MockMortandadDAO(IMovimientoDAO mockMovimientoDAO) {
        // Relacionar las mortandades con los movimientos
        Movimiento movimiento1 = mockMovimientoDAO.obtenerMovimientos().get(0);
        Movimiento movimiento2 = mockMovimientoDAO.obtenerMovimientos().get(1);
        Movimiento movimiento3 = mockMovimientoDAO.obtenerMovimientos().get(2);
        Movimiento movimiento4 = mockMovimientoDAO.obtenerMovimientos().get(3);

        // Simular algunas mortandades ya cargadas
        mortandades.add(new Mortandad(movimiento1.getId(), "Enfermedad", "123ABC",  movimiento1, movimiento1.getCantidad(), movimiento1.getFecha(), movimiento1.getEstablecimiento(), movimiento1.getSubcategoria()));
        mortandades.add(new Mortandad(movimiento2.getId(), "Accidente", "456DEF",  movimiento2, movimiento2.getCantidad(), movimiento2.getFecha(), movimiento2.getEstablecimiento(), movimiento2.getSubcategoria()));
        mortandades.add(new Mortandad(movimiento3.getId(), "Enfermedad", "789GHI",  movimiento3, movimiento3.getCantidad(), movimiento3.getFecha(), movimiento3.getEstablecimiento(), movimiento3.getSubcategoria()));
        mortandades.add(new Mortandad(movimiento4.getId(), "Predador", "012JKL",  movimiento4, movimiento4.getCantidad(), movimiento4.getFecha(), movimiento4.getEstablecimiento(), movimiento4.getSubcategoria()));
    }

    /**
     * Obtiene todas las mortandades simuladas.
     * 
     * @return List<Mortandad> Lista de todas las mortandades disponibles.
     */
    public List<Mortandad> obtenerMortandades() {
        return mortandades;
    }

    /**
     * Obtiene mortandades filtradas por fechas y establecimiento.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @param establecimiento Establecimiento para filtrar las mortandades.
     * @return List<Mortandad> Lista de mortandades que cumplen con los criterios de búsqueda.
     */
    public List<Mortandad> obtenerMortandadesPorFechasYEstablecimiento(Date desde, Date hasta, Establecimiento establecimiento) {
        List<Mortandad> resultados = new ArrayList<>();
        for (Mortandad mortandad : mortandades) {
            if (!mortandad.getFecha().before(desde) && !mortandad.getFecha().after(hasta) &&
                mortandad.getEstablecimiento().getId() == establecimiento.getId()) {
                resultados.add(mortandad);
            }
        }
        return resultados;
    }
}
