/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

/**
 * Esta clase representa una subcategoría dentro de una categoría más amplia. 
 * Cada subcategoría tiene un identificador único, un nombre y está asociada a una categoría.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Subcategoria {
    
    private int id;
    private String nombre;
    private Categoria categoria;

    public Subcategoria(int id, String nombre, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }
    

    public Subcategoria() {
    }
    
    public Subcategoria(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
