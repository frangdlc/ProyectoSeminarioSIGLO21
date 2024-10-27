/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.Scanner;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Establecimiento;

/**
 *Esta clase gestiona la vista del menú principal de la aplicación. 
 * Su función principal es presentar al usuario opciones para navegar a diferentes secciones de la aplicación, como categorías, informes y cerrar sesión
 * @author Francisco de la Cruz v1.0
 */
public class ViewMenuPrincipal {
    private ViewCategoria viewCategoria;
    private ViewInformes viewInformes;
    private ViewMortandad viewMortandad;

    public ViewMenuPrincipal(ViewCategoria viewCategoria, ViewInformes viewInformes, ViewMortandad viewMortandad) {
        this.viewCategoria = viewCategoria;
        this.viewInformes = viewInformes;
        this.viewMortandad = viewMortandad;
    }
    
/**
 * Muestra el menú principal al usuario y gestiona la selección de opciones.
 * Este método permite al usuario navegar a diferentes secciones de la aplicación,
 * como categorías, informes y cerrar sesión.
 *
 * @param usuarioActual El usuario que ha iniciado sesión.
 * @param establecimientoActual El establecimiento seleccionado relacionado con el usuario.
 */
    public void mostrarMenuPrincipal(Usuario usuarioActual, Establecimiento establecimientoActual) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = solicitarOpcion(sc);

            switch (opcion) {
                case 1:
                    viewCategoria.mostrarMenuCategoria(usuarioActual);
                    break;
                case 2:
                    System.out.println("Movimientos aún no implementado.");
                    break;
                case 3:
                    viewInformes.mostrarMenuInformes(establecimientoActual, viewMortandad);
                    break;
                case 4:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
/**
 * Muestra las opciones del menú principal en la consola.
 * Este método imprime las diferentes opciones disponibles para el usuario,
 * permitiéndole elegir una acción.
 */
    private void mostrarMenu() {
        System.out.println("--------------------------");
        System.out.println("    Menu Principal    ");
        System.out.println("1) Categoria");
        System.out.println("2) Movimientos");
        System.out.println("3) Informes");
        System.out.println("4) Cerrar Sesión");
        System.out.println("--------------------------");
    }
    
/**
 * Solicita al usuario que seleccione una opción del menú.
 * Este método asegura que la opción ingresada sea un número válido
 * dentro del rango permitido. Si la opción es inválida,
 * se solicita al usuario que intente nuevamente.
 *
 * @param sc El escáner utilizado para leer la entrada del usuario.
 * @return int La opción seleccionada por el usuario.
 */
    private int solicitarOpcion(Scanner sc) {
        int opcion = -1;
        while (true) {
            System.out.print("Seleccione una opción: ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    break;
                } else {
                    System.out.println("Opción inválida, debe ser entre 1 y 4.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                sc.next();
            }
        }
        return opcion;
    }
}
