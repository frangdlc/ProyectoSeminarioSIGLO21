/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.Date;

/**
 * Esta clase representa un movimiento que puede ocurrir en un establecimiento.
 * Cada movimiento tiene un identificador único, una cantidad, una fecha, un establecimiento asociado y una subcategoría.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Movimiento {
    private int id;
    private int cantidad;
    private Date fecha;
    private Establecimiento establecimiento;
    private Subcategoria subcategoria;

    public Movimiento(int id, int cantidad, Date fecha, Establecimiento establecimiento, Subcategoria subcategoria) {
        this.id = id;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.establecimiento = establecimiento;
        this.subcategoria = subcategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    
}
