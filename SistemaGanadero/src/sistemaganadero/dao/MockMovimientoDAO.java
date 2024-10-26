/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;
import sistemaganadero.modelo.Movimiento;
import sistemaganadero.modelo.Establecimiento;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 * Esta clase simula la implementación de la interfaz IMovimientoDAO para propósitos de prueba.
 * Proporciona una lista en memoria de movimientos y métodos para gestionar esos movimientos sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class MockMovimientoDAO implements IMovimientoDAO {
    private List<Movimiento> movimientos = new ArrayList<>();

    public MockMovimientoDAO(IEstablecimientoDAO mockEstablecimientoDAO, ISubcategoriaDAO mockSubcategoriaDAO) {
        // Simular algunos movimientos ya cargados
        movimientos.add(new Movimiento(1, 10, Date.valueOf("2024-01-01"), mockEstablecimientoDAO.obtenerEstablecimiento(1), mockSubcategoriaDAO.obtenerSubcategoria(1)));
        movimientos.add(new Movimiento(2, 15, Date.valueOf("2024-02-01"), mockEstablecimientoDAO.obtenerEstablecimiento(1), mockSubcategoriaDAO.obtenerSubcategoria(2)));
        movimientos.add(new Movimiento(3, 8, Date.valueOf("2024-03-15"), mockEstablecimientoDAO.obtenerEstablecimiento(2), mockSubcategoriaDAO.obtenerSubcategoria(1)));
        movimientos.add(new Movimiento(4, 20, Date.valueOf("2024-04-10"), mockEstablecimientoDAO.obtenerEstablecimiento(2), mockSubcategoriaDAO.obtenerSubcategoria(3)));
    }
    
    /**
     * Obtiene todos los movimientos simulados.
     * 
     * @return List<Movimiento> Lista de todos los movimientos disponibles.
     */
    public List<Movimiento> obtenerMovimientos() {
        return movimientos;
    }
    
    /**
     * Obtiene movimientos filtrados por fechas y establecimiento.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @param establecimiento Establecimiento para filtrar los movimientos.
     * @return List<Movimiento> Lista de movimientos que cumplen con los criterios de búsqueda.
     */
    public List<Movimiento> obtenerMovimientosPorFechasYEstablecimiento(Date desde, Date hasta, Establecimiento establecimiento) {
        List<Movimiento> resultados = new ArrayList<>();
        for (Movimiento movimiento : movimientos) {
            if (!movimiento.getFecha().before(desde) && !movimiento.getFecha().after(hasta) &&
                movimiento.getEstablecimiento().getId() == establecimiento.getId()) {
                resultados.add(movimiento);
            }
        }
        return resultados;
    }
}
