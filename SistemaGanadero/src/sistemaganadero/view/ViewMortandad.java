/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import sistemaganadero.controller.ControllerInforme;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.modelo.Mortandad;
import sistemaganadero.modelo.Movimiento;
import sistemaganadero.modelo.Subcategoria;
import sistemaganadero.modelo.Categoria;

/**
 * Esta clase se encarga de gestionar la visualización de informes de mortandad en un establecimiento específico. 
 * Permite al usuario ingresar un rango de fechas y muestra los datos de mortandad correspondientes a esas fechas.
 * @author Usuario
 */
public class ViewMortandad {
    private ControllerInforme controller;

    public ViewMortandad(ControllerInforme controller) {
        this.controller = controller;
    }
    
/**
* Muestra el informe de mortandad para un establecimiento en un rango de fechas.
* 
* Este método solicita al usuario que ingrese las fechas de inicio y fin,
* y luego utiliza el controlador para obtener y mostrar los datos de mortandad correspondientes a esas fechas para el establecimiento proporcionado.
* 
* @param establecimiento El establecimiento para el cual se desea obtener el informe de mortandad.
*/
public void mostrarInformeMortandad(Establecimiento establecimiento) {
    Scanner sc = new Scanner(System.in);
    Date desde = null;
    Date hasta = null;

    // Bucle para ingresar la fecha "desde"
    while (desde == null) {
        System.out.print("Ingrese fecha desde (YYYY-MM-DD) o 'S' para salir: ");
        String inputDesde = sc.next();

        if (inputDesde.equalsIgnoreCase("S")) {
            System.out.println("Saliendo de la opción de informe de mortandad.");
            return; // Sale del método si el usuario elige "S"
        }

        try {
            desde = Date.valueOf(inputDesde); // Intenta convertir la fecha
        } catch (IllegalArgumentException e) {
            System.out.println("Formato de fecha inválido. Asegúrese de ingresar la fecha en el formato YYYY-MM-DD.");
        }
    }

    // Bucle para ingresar la fecha "hasta"
    while (hasta == null) {
        System.out.print("Ingrese fecha hasta (YYYY-MM-DD) o 'S' para salir: ");
        String inputHasta = sc.next();

        if (inputHasta.equalsIgnoreCase("S")) {
            System.out.println("Saliendo de la opción de informe de mortandad.");
            return; // Sale del método si elige "S"
        }

        try {
            hasta = Date.valueOf(inputHasta); // Intenta convertir la fecha

            // Verificar que "hasta" no sea menor que "desde"
            if (hasta.before(desde)) {
                System.out.println("La fecha 'hasta' no puede ser anterior a la fecha 'desde'. Por favor, ingrese nuevamente.");
                hasta = null; // Reiniciar "hasta" para volver a pedir la fecha
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Formato de fecha inválido. Asegúrese de ingresar la fecha en el formato YYYY-MM-DD.");
        }
    }

    // Obtener mortandades entre las fechas dadas para el establecimiento
    List<Mortandad> mortandades = controller.obtenerMortandadesPorFechasYEstablecimiento(desde, hasta, establecimiento);

    if (mortandades.isEmpty()) {
        System.out.println("No se encontraron datos de mortandad para las fechas indicadas.");
    } else {
        System.out.println("-------- Mortandades encontradas para el Establecimiento: " + establecimiento.getNombre() + " --------");

        for (Mortandad mortandad : mortandades) {
                System.out.println("ID Movimiento: " + mortandad.getId());
                System.out.println("Fecha: " + mortandad.getFecha());
                System.out.println("Causa: " + mortandad.getCausa());
                System.out.println("N° Trazabilidad: " + mortandad.getNumeroTrazabilidad());

                Movimiento movimiento = mortandad.getMovimiento();
                Subcategoria subcategoria = movimiento.getSubcategoria();

                // Imprimir información de la subcategoría
                System.out.println("Subcategoría: " + subcategoria.getNombre());

                // Obtener e imprimir la categoría de la subcategoría
                Categoria categoria = subcategoria.getCategoria();
                System.out.println("Categoría: " + categoria.getNombre());

                System.out.println("-----------------------------------------");
            }
        }
    }
}