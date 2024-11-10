/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un establecimiento que puede contener potreros y usuarios. 
 * Cada establecimiento tiene un identificador único, un nombre, una cantidad de hectáreas, y listas de potreros y usuarios asociados.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Establecimiento {
    private int id;
    private String nombre;
    private int cantidadHectareas; 
    private List<Potrero> potreros;
    private List<Usuario> usuarios;

    public Establecimiento(int id, String nombre, int cantidadHectareas, List<Potrero> potreros, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectareas = cantidadHectareas;
        this.potreros = potreros;
        this.usuarios = new ArrayList<>();
    }

    public Establecimiento(int id, String nombre, int cantidadHectareas, List<Potrero> potreros) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectareas = cantidadHectareas;
        this.potreros =  new ArrayList<>();
    }

    public Establecimiento(int id, String nombre, int cantidadHectareas) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectareas = cantidadHectareas;
    }

    public Establecimiento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public List<Potrero> getPotreros() {
        return potreros;
    }

    public void setPotreros(List<Potrero> potreros) {
        this.potreros = potreros;
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
    
}
