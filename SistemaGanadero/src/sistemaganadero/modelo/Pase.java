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
public class Pase extends Movimiento{
    private int id;
    private String descripcion;
    private Subcategoria subcategoria_origen;
    private Subcategoria subcategoria_destino;

    public Pase(int movimiento_id, String descripcion, Subcategoria subcategoria_origen, Subcategoria subcategoria_destino, int id, int cantidad, Date fecha, Establecimiento establecimiento, Subcategoria subcategoria) {
        super(movimiento_id, cantidad, fecha, establecimiento, subcategoria);
        this.id = id;
        this.descripcion = descripcion;
        this.subcategoria_origen = subcategoria_origen;
        this.subcategoria_destino = subcategoria_destino;
    }

    public Subcategoria getSubcategoria_origen() {
        return subcategoria_origen;
    }

    public void setSubcategoria_origen(Subcategoria subcategoria_origen) {
        this.subcategoria_origen = subcategoria_origen;
    }

    public Subcategoria getSubcategoria_destino() {
        return subcategoria_destino;
    }

    public void setSubcategoria_destino(Subcategoria subcategoria_destino) {
        this.subcategoria_destino = subcategoria_destino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
