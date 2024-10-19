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
public class Venta extends Movimiento{
    private int id;
    private String origen;
    private double peso;
    private String numeroDte;
    private String numeroTrazabilidad;

    public Venta(int movimiento_id, String origen, double peso, String numeroDte, String numeroTrazabilidad, int id, int cantidad, Date fecha, Establecimiento establecimiento, Subcategoria subcategoria) {
        super(movimiento_id, cantidad, fecha, establecimiento, subcategoria);
        this.id = id;
        this.origen = origen;
        this.peso = peso;
        this.numeroDte = numeroDte;
        this.numeroTrazabilidad = numeroTrazabilidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNumeroDte() {
        return numeroDte;
    }

    public void setNumeroDte(String numeroDte) {
        this.numeroDte = numeroDte;
    }

    public String getNumeroTrazabilidad() {
        return numeroTrazabilidad;
    }

    public void setNumeroTrazabilidad(String numeroTrazabilidad) {
        this.numeroTrazabilidad = numeroTrazabilidad;
    }
    
    
}
