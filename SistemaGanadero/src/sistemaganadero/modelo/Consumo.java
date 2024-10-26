/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.Date;

/**
 * Esta clase representa un consumo, que es un tipo de movimiento.
 * Cada consumo tiene un identificador único y una descripción.
 * Extiende la clase Movimiento, que contiene información común a todos los movimientos.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Consumo extends Movimiento{
    private int id;
    private String descripcion;

    public Consumo(int movilidad_id, String descripcion, int id, int cantidad, Date fecha, Establecimiento establecimiento, Subcategoria subcategoria) {
        super(movilidad_id, cantidad, fecha, establecimiento, subcategoria);
        this.id = id;
        this.descripcion = descripcion;
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
