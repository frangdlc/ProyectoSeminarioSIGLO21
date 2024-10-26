/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.Scanner;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public class ViewMenuPrincipal {
    private ViewCategoria categoriaView;
    private ViewInformes viewInformes;
    private ViewMortandad viewMortandad;

    public ViewMenuPrincipal(ViewCategoria categoriaView, ViewInformes viewInformes, ViewMortandad viewMortandad) {
        this.categoriaView = categoriaView;
        this.viewInformes = viewInformes;
        this.viewMortandad = viewMortandad;
    }

    public void mostrarMenuPrincipal(Usuario usuarioActual, Establecimiento establecimientoActual) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            mostrarMenu();
            opcion = solicitarOpcion(sc);

            switch (opcion) {
                case 1:
                    categoriaView.mostrarMenuCategoria(usuarioActual);
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

    private void mostrarMenu() {
        System.out.println("--------------------------");
        System.out.println("    Menu Principal    ");
        System.out.println("1) Categoria");
        System.out.println("2) Movimientos");
        System.out.println("3) Informes");
        System.out.println("4) Cerrar Sesión");
        System.out.println("--------------------------");
    }

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
