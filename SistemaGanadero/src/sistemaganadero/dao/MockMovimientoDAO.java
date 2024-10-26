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
 *
 * @author Usuario
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

    public List<Movimiento> obtenerMovimientos() {
        return movimientos;
    }
    
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
