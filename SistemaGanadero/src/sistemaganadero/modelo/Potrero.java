/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

/**
 *
 * @author Usuario
 */
public class Potrero {
    private int id;
    private String nombre;
    private int cantidadHectareas;
    private Establecimiento establecimiento; 

    public Potrero(int id, String nombre, int cantidadHectareas, Establecimiento establecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectareas = cantidadHectareas;
        this.establecimiento = establecimiento;
    }

    public Potrero(int id, String nombre, Establecimiento establecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.establecimiento = establecimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadHectareas() {
        return cantidadHectareas;
    }

    public void setCantidadHectareas(int cantidadHectareas) {
        this.cantidadHectareas = cantidadHectareas;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
    
}
