/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import java.util.List;
import java.util.Scanner;
import sistemaganadero.controller.ControllerEstablecimiento;
import sistemaganadero.dao.IUsuarioEstablecimientoDAO;
import sistemaganadero.modelo.Establecimiento;
/**
 *
 * @author Usuario
 */
public class ViewEstablecimiento {
    
    private ControllerEstablecimiento controller;

    public ViewEstablecimiento(ControllerEstablecimiento controller) {
        this.controller = controller;
    }

   public Establecimiento seleccionarEstablecimiento(int usuarioId, IUsuarioEstablecimientoDAO usuarioEstablecimientoDAO) {
       
        List<Establecimiento> establecimientos = controller.obtenerEstablecimientosPorUsuario(usuarioId, usuarioEstablecimientoDAO);

        if (establecimientos.isEmpty()) {
            System.out.println("No hay establecimientos disponibles.");
            return null;
        }

        System.out.println("Seleccione un establecimiento:");
        for (int i = 0; i < establecimientos.size(); i++) {
            System.out.println((i + 1) + ") " + establecimientos.get(i).getNombre());
        }

        Scanner sc = new Scanner(System.in);
        int seleccion = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese el número de establecimiento (o 0 para salir): ");
                seleccion = Integer.parseInt(sc.nextLine()); // Se usa nextLine() para evitar problemas con entradas no numéricas.
                if (seleccion == 0) {
                    return null;
                }
                if (seleccion >= 1 && seleccion <= establecimientos.size()) {
                    entradaValida = true; // Salir del bucle si la entrada es válida.
                } else {
                    System.out.println("Opción no válida. Vuelva a elegir.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }

        return establecimientos.get(seleccion - 1);
    }
}
