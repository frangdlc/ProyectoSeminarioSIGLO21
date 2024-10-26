/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.Scanner;
import sistemaganadero.controller.ControllerInforme;
import sistemaganadero.modelo.Establecimiento;

/**
 * Esta clase representa la vista para mostrar informes relacionados con la mortandad de un establecimiento. 
 * Se encarga de interactuar con el usuario a través de la consola y de presentar las opciones disponibles para generar informes.
 * @author Francisco de la Cruz v1.0
 */
public class ViewInformes {
    private ControllerInforme controller;

    public ViewInformes(ControllerInforme controller) {
        this.controller = controller;
    }

/**
* Muestra el menú de informes y gestiona la interacción del usuario.
* 
* Este método presenta un menú al usuario donde puede seleccionar diferentes opciones para generar informes. 
* Permite al usuario elegir un informe de mortandad por fechas o volver al menú principal.
* 
* @param establecimiento El establecimiento para el cual se desea generar el informe.
* @param viewMortandad La vista encargada de mostrar el informe de mortandad.
*/
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