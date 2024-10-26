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
 * Esta clase se encarga de gestionar la vista relacionada con los establecimientos en la aplicación.
 * Proporciona una interfaz para que los usuarios seleccionen un establecimiento de una lista de establecimientos disponibles, basada en su identificación de usuario.
 * 
 * La clase utiliza un controlador (ControllerEstablecimiento) para obtener la lista de establecimientos asociados a un usuario específico. 
 * Si no hay establecimientos disponibles, se informa al usuario. 
 * Además, permite al usuario ingresar su selección de manera segura, manejando entradas no válidas y permitiendo cancelar la selección.
 * @author Francisco de la Cruz v1.0
 */
public class ViewEstablecimiento {
    
    private ControllerEstablecimiento controller;

    public ViewEstablecimiento(ControllerEstablecimiento controller) {
        this.controller = controller;
    }
    
/**
* Permite al usuario seleccionar un establecimiento de una lista de establecimientos disponibles.
* 
* Este método recupera los establecimientos asociados al usuario especificado,
* muestra la lista de establecimientos y solicita al usuario que seleccione uno.
* Si el usuario ingresa 0, se cancela la selección.
*
* @param usuarioId El ID del usuario para el cual se desean obtener los establecimientos.
* @param usuarioEstablecimientoDAO El objeto DAO que permite acceder a la relación entre usuarios y establecimientos.
* @return Establecimiento El establecimiento seleccionado por el usuario, o null si no hay establecimientos disponibles o si el usuario decide salir.    
 */
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
