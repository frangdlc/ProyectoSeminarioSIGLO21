/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaganadero.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Rol;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public class SistemaGanadero {

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        
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

        // Agregar 3 dueños
        usuarios.add(new Usuario("20123456789", "duenio1@example.com", "1234", "12345678", 'M', "Juan", "Pérez", fechaNacimiento1, true, roleAdmin));
        usuarios.add(new Usuario("20123456788", "duenio2@example.com", "5678", "87654321", 'F', "Ana", "Gomez", fechaNacimiento2, true, roleAdmin));
        usuarios.add(new Usuario("20123456787", "duenio3@example.com", "9101", "34561234", 'M', "Carlos", "Ramirez", fechaNacimiento3, true, roleAdmin));

        // Agregar 5 administradores
        usuarios.add(new Usuario("20876543219", "admin1@example.com", "4321", "98765432", 'M', "Jose", "Lopez", fechaNacimiento4, true, roleUser));
        usuarios.add(new Usuario("20876543218", "admin2@example.com", "5678", "87654321", 'F', "Maria", "Fernandez", fechaNacimiento5, true, roleUser));
        usuarios.add(new Usuario("20876543217", "admin3@example.com", "6789", "76543210", 'M', "Luis", "Martinez", fechaNacimiento6, true, roleUser));
        usuarios.add(new Usuario("20876543216", "admin4@example.com", "7890", "65432109", 'F', "Laura", "Rodriguez", fechaNacimiento7, true, roleUser));
        usuarios.add(new Usuario("20876543215", "admin5@example.com", "8901", "54321098", 'M', "Pedro", "Gonzalez", fechaNacimiento8, true, roleUser));
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Inicio de Sesion");

        Usuario usuarioActual = validarLogin(usuarios);

        if (usuarioActual != null) {
            // Mostrar menú o realizar acciones después de iniciar sesión exitosamente
            System.out.println("Bienvenido, " + usuarioActual.getNombre());
            // Continuar con el flujo del sistema...
        } else {
            System.out.println("Saliendo del sistema...");
            return;
        }

        int opcion;
        do {
            opcion = mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    System.out.println("Saliendo del sistema...");
                    break;
                case 2:
                    System.out.println("Opción 2 seleccionada");
                    break;
                case 3:
                    System.out.println("Opción 3 seleccionada");
                    break;
                case 4:
                    System.out.println("Opción 4 seleccionada");
                    break;
                case 5:
                    System.out.println("Opción 5 seleccionada");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 1);
    }

    /**
     * Muestra el menú principal y devuelve una opción entre 1 y 5
     *
     * @return valor entero elegido
     */
    private static int mostrarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("    Menu Principal    ");
        System.out.println("1) SALIR");
        System.out.println("2) Opción 2");
        System.out.println("3) Opción 3");
        System.out.println("4) Opción 4");
        System.out.println("5) Opción 5");
        
        do {
            try {
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Debe ingresar una opción válida entre 1 y 5.");
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un número.");
                sc.nextLine(); // Limpiar el buffer del scanner
                opcion = 0;
            }
        } while (opcion < 1 || opcion > 5);
        return opcion;
    }
    
    /**
     * Función para validar el inicio de sesión
     * 
     * @param usuarios Listado de usuarios disponibles para el login
     * @return Usuario logueado si el login fue exitoso, null si el usuario decide salir
     */
    private static Usuario validarLogin(List<Usuario> usuarios) {
        Scanner sc = new Scanner(System.in);
        boolean loginExitoso = false;
        Usuario usuarioActual = null;

        while (!loginExitoso) {
            System.out.print("Ingrese usuario (nombre o correo) o 'S' para salir: ");
            String usuarioInput = sc.nextLine();
            if (usuarioInput.equalsIgnoreCase("S")) {
                return null;  // Salir del sistema
            }

            System.out.print("Ingrese contraseña o 'S' para salir: ");
            String passwordInput = sc.nextLine();
            if (passwordInput.equalsIgnoreCase("S")) {
                return null;  // Salir del sistema
            }

            // Validar credenciales
            for (Usuario usuario : usuarios) {
                if ((usuario.getNombre().equals(usuarioInput) || usuario.getEmail().equals(usuarioInput)) &&
                        usuario.getPassword().equals(passwordInput)) {
                    loginExitoso = true;
                    usuarioActual = usuario;
                    break;
                }
            }

            if (!loginExitoso) {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }
        return usuarioActual;  // Login exitoso
    }
}
