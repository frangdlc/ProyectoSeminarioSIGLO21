/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa una categoría que puede contener subcategorías.
 * Cada categoría tiene un identificador único, un nombre, una descripción y una lista de subcategorías asociadas.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private List<Subcategoria> subcategorias;

    public Categoria(int id, String nombre, String descripcion, List<Subcategoria> subcategorias) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subcategorias =  new ArrayList<>();
    }
    
    // Llamada al constructor principal
    public Categoria(int id, String nombre, String descripcion) {
        this(id, nombre, descripcion, new ArrayList<>());
    }

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
