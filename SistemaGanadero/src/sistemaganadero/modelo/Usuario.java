/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta clase representa al usuario, que puede contener establecimientos. 
 * Cada establecimiento tiene un identificador único, un nombre, una cantidad de hectáreas, y listas de potreros y usuarios asociados.
 * Incluye métodos getter y setter para cada atributo.
 * @author Francisco de la Cruz v1.0
 */
public class Usuario {

	// Atributos
    	private int id;
	private String cuil;
	private String email;
	private String password;
        private char sexo;
        private String nombre;
        protected String apellido;
        private Date fechaNacimiento;
        private Boolean activo ;
        private Rol rol ;
        private List<Establecimiento> establecimientos;

    public Usuario(String cuil, String email, String password, char sexo, String nombre, String apellido, Date fechaNacimiento, Boolean activo, Rol rol) {
        this.cuil = cuil;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
        this.rol = rol;
    }

    public Usuario(int id, String cuil, String email, String password, char sexo, String nombre, String apellido, Date fechaNacimiento, Boolean activo, Rol rol) {
        this.id = id;
        this.cuil = cuil;
        this.email = email;
        this.password = password;
        this.sexo = sexo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = activo;
        this.rol = rol;
    }

        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }



}
