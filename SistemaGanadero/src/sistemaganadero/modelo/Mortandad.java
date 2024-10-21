/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Mortandad extends Movimiento{
    private int id;
    private String causa;
    private String numeroTrazabilidad;
    private Movimiento movimiento; // Relación con Movimiento

    public Mortandad(int id, String causa, String numeroTrazabilidad, Movimiento movimiento, int cantidad, Date fecha, Establecimiento establecimiento, Subcategoria subcategoria) {
        super(id,cantidad, fecha, establecimiento, subcategoria);
        this.id = id;
        this.causa = causa;
        this.numeroTrazabilidad = numeroTrazabilidad;
        this.movimiento = movimiento;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getNumeroTrazabilidad() {
        return numeroTrazabilidad;
    }

    public void setNumeroTrazabilidad(String numeroTrazabilidad) {
        this.numeroTrazabilidad = numeroTrazabilidad;
    }
    
}
