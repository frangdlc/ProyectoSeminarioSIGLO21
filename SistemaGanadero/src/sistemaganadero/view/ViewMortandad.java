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
 *
 * @author Usuario
 */
public class ViewMortandad {
    private ControllerInforme controller;

    public ViewMortandad(ControllerInforme controller) {
        this.controller = controller;
    }

    public void mostrarInformeMortandad(Establecimiento establecimiento) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese fecha desde (YYYY-MM-DD): ");
        Date desde = Date.valueOf(sc.next());
        
        System.out.print("Ingrese fecha hasta (YYYY-MM-DD): ");
        Date hasta = Date.valueOf(sc.next());

        List<Mortandad> mortandades = controller.obtenerMortandadesPorFechasYEstablecimiento(desde, hasta, establecimiento);

        if (mortandades.isEmpty()) {
            System.out.println("No se encontraron datos de mortandad para las fechas indicadas.");
        } else {
            System.out.println("--------Mortandades encontradas para el Establecimiento: " + establecimiento.getNombre() + " --------");
            
            for (Mortandad mortandad : mortandades) {
                System.out.println("ID Movimiento: " + mortandad.getId());
                System.out.println("Fecha: " + mortandad.getFecha());
                System.out.println("Causa: " + mortandad.getCausa());
                System.out.println("N° Trazabilidad: " + mortandad.getNumeroTrazabilidad());
                
                // Información del movimiento y subcategoría
                Movimiento movimiento = mortandad.getMovimiento();
                Subcategoria subcategoria = movimiento.getSubcategoria();

                // Imprimir nombre de la subcategoría
                System.out.println("Subcategoría: " + subcategoria.getNombre());

                // Obtener y imprimir la categoría de la subcategoría
                Categoria categoria = subcategoria.getCategoria();
                System.out.println("Categoría: " + categoria.getNombre());

                System.out.println("-----------------------------------------");
            }
        }
    }
}