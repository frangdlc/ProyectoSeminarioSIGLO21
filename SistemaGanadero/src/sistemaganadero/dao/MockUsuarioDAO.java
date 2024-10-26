/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.dao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Rol;

import java.util.List;

/**
 * Esta clase simula la implementación de la interfaz IUsuarioDAO para propósitos de prueba.
 * Proporciona una lista en memoria de usuarios y métodos para gestionar esos usuarios sin tener una base de datos real.
 * @author Francisco de la Cruz v1.0
 */
public class MockUsuarioDAO implements IUsuarioDAO{
        private List<Usuario> usuarios;

    public MockUsuarioDAO() {
        usuarios = new ArrayList<>();
        
        // Crear roles para los usuarios
        Rol roleAdmin = new Rol(1, "Dueño");
        Rol roleUser = new Rol(2, "Administrador");

        // Crear distintas fechas de nacimiento
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1996, Calendar.JANUARY, 29);
        Date fechaNacimiento1 = cal1.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.set(1985, Calendar.MARCH, 15);
        Date fechaNacimiento2 = cal2.getTime();

        Calendar cal3 = Calendar.getInstance();
        cal3.set(1990, Calendar.JULY, 22);
        Date fechaNacimiento3 = cal3.getTime();

        Calendar cal4 = Calendar.getInstance();
        cal4.set(1988, Calendar.DECEMBER, 5);
        Date fechaNacimiento4 = cal4.getTime();

        Calendar cal5 = Calendar.getInstance();
        cal5.set(1975, Calendar.MAY, 10);
        Date fechaNacimiento5 = cal5.getTime();

        Calendar cal6 = Calendar.getInstance();
        cal6.set(1992, Calendar.SEPTEMBER, 18);
        Date fechaNacimiento6 = cal6.getTime();

        Calendar cal7 = Calendar.getInstance();
        cal7.set(1980, Calendar.FEBRUARY, 28);
        Date fechaNacimiento7 = cal7.getTime();

        Calendar cal8 = Calendar.getInstance();
        cal8.set(1993, Calendar.JUNE, 12);
        Date fechaNacimiento8 = cal8.getTime();

        //3 dueños
        usuarios.add(new Usuario(1,"20123456789", "duenio1@example.com", "1234", "12345678", 'M', "Juan", "Pérez", fechaNacimiento1, true, roleAdmin));
        usuarios.add(new Usuario(2,"20123456788", "duenio2@example.com", "5678", "87654321", 'F', "Ana", "Gomez", fechaNacimiento2, true, roleAdmin));
        usuarios.add(new Usuario(3,"20123456787", "duenio3@example.com", "9101", "34561234", 'M', "Carlos", "Ramirez", fechaNacimiento3, true, roleAdmin));

        //5 administradores
        usuarios.add(new Usuario(4,"20876543219", "admin1@example.com", "4321", "98765432", 'M', "Jose", "Lopez", fechaNacimiento4, true, roleUser));
        usuarios.add(new Usuario(5,"20876543218", "admin2@example.com", "5678", "87654321", 'F', "Maria", "Fernandez", fechaNacimiento5, true, roleUser));
        usuarios.add(new Usuario(6,"20876543217", "admin3@example.com", "6789", "76543210", 'M', "Luis", "Martinez", fechaNacimiento6, true, roleUser));
        usuarios.add(new Usuario(7,"20876543216", "admin4@example.com", "7890", "65432109", 'F', "Laura", "Rodriguez", fechaNacimiento7, true, roleUser));
        usuarios.add(new Usuario(8,"20876543215", "admin5@example.com", "8901", "54321098", 'M', "Pedro", "Gonzalez", fechaNacimiento8, true, roleUser));   
    }

    /**
     * Obtiene todos los usuarios simulados.
     * 
     * @return List<Usuario> Lista de todos los usuarios disponibles.
     */
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
