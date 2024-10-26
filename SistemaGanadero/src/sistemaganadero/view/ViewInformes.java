/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.Scanner;
import sistemaganadero.controller.ControllerInforme;
import sistemaganadero.modelo.Establecimiento;

/**
 *
 * @author Usuario
 */
public class ViewInformes {
    private ControllerInforme controller;

    public ViewInformes(ControllerInforme controller) {
        this.controller = controller;
    }

    public void mostrarMenuInformes(Establecimiento establecimiento, ViewMortandad viewMortandad) {
        Scanner sc = new Scanner(System.in);
        int opcionInforme;

        do {
            System.out.println("    Menu de Informes    ");
            System.out.println("1) Informe de mortandad por fechas");
            System.out.println("0) Volver");
            System.out.print("Seleccione una opción: ");
            opcionInforme = sc.nextInt();

            switch (opcionInforme) {
                case 1:
                    viewMortandad.mostrarInformeMortandad(establecimiento);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionInforme != 0);
    }
}