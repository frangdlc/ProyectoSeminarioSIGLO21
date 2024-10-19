/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Establecimiento {
    private int id;
    private String nombre;
    private int cantidadHectares; 
    private List<Potrero> potreros;
    private List<Usuario> usuarios;

    public Establecimiento(int id, String nombre, int cantidadHectares, List<Potrero> potreros, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectares = cantidadHectares;
        this.potreros = potreros;
        this.usuarios = new ArrayList<>();
    }

    public Establecimiento(int id, String nombre, int cantidadHectares, List<Potrero> potreros) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectares = cantidadHectares;
        this.potreros =  new ArrayList<>();
    }

    public Establecimiento(int id, String nombre, int cantidadHectares) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadHectares = cantidadHectares;
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

    public int getCantidadHectares() {
        return cantidadHectares;
    }

    public void setCantidadHectares(int cantidadHectares) {
        this.cantidadHectares = cantidadHectares;
    }
    
}
