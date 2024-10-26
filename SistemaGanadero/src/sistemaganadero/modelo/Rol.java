/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa un rol en el sistema. Cada rol tiene un identificador único y un nombre que lo describe.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Rol {
    
    private Integer id;
    private String nombre;

    public Rol(Integer id, String nombreRol) {
        super();
        this.id = id;
        this.nombre = nombreRol;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreRol) {
        this.nombre = nombreRol;
    }

}
