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

    public Mortandad(int movimiento_id, String causa, String numeroTrazabilidad, int id, int cantidad, Date fecha, Establecimiento establecimiento, Subcategoria subcategoria) {
        super(movimiento_id, cantidad, fecha, establecimiento, subcategoria);
        this.id = id;
        this.causa = causa;
        this.numeroTrazabilidad = numeroTrazabilidad;
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
