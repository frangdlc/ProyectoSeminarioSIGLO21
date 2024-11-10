/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import exceptions.OptionNotAvailable;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import sistemaganadero.controller.ControllerCategoria;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;



/**
 * Esta clase gestiona la interfaz de usuario relacionada con las categorías en la aplicación.
 * Proporciona un menú que permite a los usuarios (específicamente a los dueños) agregar, modificar,
 * eliminar y listar categorías. Si el usuario no tiene el rol de dueño, solo puede listar las categorías.
 * 
 * La clase utiliza un controlador (ControllerCategoria) para manejar la lógica de negocio
 * relacionada con las categorías.
 * @author Francisco de la Cruz v1.0
 */

public class ViewCategoria {
    private ControllerCategoria controllerCategoria;
    private Scanner sc = new Scanner(System.in);

    public ViewCategoria(ControllerCategoria controllerCategoria) {
        this.controllerCategoria = controllerCategoria;
    }
/**
* Muestra el menú de categorías y permite al usuario interactuar con él.
* 
* Este método verifica si el usuario actual es un dueño. Si lo es, muestra el menú
* de opciones para agregar, modificar, eliminar o listar categorías. Si no, solo
* permite listar las categorías.
* 
* @param usuarioActual El usuario que está interactuando con el sistema.
*/
public void mostrarMenuCategoria(Usuario usuarioActual) {
    Scanner sc = new Scanner(System.in);
    int opcionCategoria = -1;

    if (usuarioActual.getRol().getNombre().equalsIgnoreCase("Dueño")) {
        do {
            try {
                mostrarMenuCategoriaOpciones();
                opcionCategoria = solicitarOpcionCategoria(sc);

                switch (opcionCategoria) {
                    case 1:
                        agregarCategoria();
                        break;
                    case 2:
                        modificarCategoria();
                        break;
                    case 3:
                        eliminarCategoria();
                        break;
                    case 4:
                        listarCategoriasConDetalles();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        throw new OptionNotAvailable("Opción inválida, seleccione una opción del 0 al 4.");
                }

            } catch (OptionNotAvailable e) {
                System.out.println(e.getMessage());
                // No se repite el menú, solo se vuelve a solicitar la opción
            }
        } while (opcionCategoria != 0);
    } else {
        listarCategoriasConDetalles(); // Si no es dueño, solo puede listar
    }
}

/**
* Muestra las opciones del menú de categorías en la consola.
* Este método imprime las diferentes acciones disponibles para el usuario.
*/
private void mostrarMenuCategoriaOpciones() {
    System.out.println("╔══════════════════════════════════╗");
    System.out.println("║        Menu de Categoría    ║");
    System.out.println("╠══════════════════════════════════╣");
    System.out.println("║ 1) Agregar categoría        ║");
    System.out.println("║ 2) Modificar categoría      ║");
    System.out.println("║ 3) Eliminar categoría       ║");
    System.out.println("║ 4) Listar categorías        ║");
    System.out.println("║ 0) Volver                   ║");
    System.out.println("╚══════════════════════════════════╝");
}

/**
* Solicita al usuario que seleccione una opción del menú de categorías.
* 
* Este método asegura que la opción ingresada sea un número válido dentro del rango permitido (0 a 4). Si la opción es inválida,
* se solicita al usuario que intente nuevamente.
* 
* @param sc El escáner utilizado para leer la entrada del usuario.
* @return int La opción seleccionada por el usuario.
*/
private int solicitarOpcionCategoria(Scanner sc) {
    int opcion = -1;
    while (true) {
        System.out.print("Seleccione una opción: ");
        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion >= 0 && opcion <= 4) {
                break; 
            } else {
                System.out.println("Opción inválida, debe ser entre 0 y 4.");
            }
        } else {
            System.out.println("Por favor, ingrese un número válido.");
            sc.next();
        }
    }
    return opcion;
}

 /**
* Agrega una nueva categoría a través de la entrada del usuario.
* Este método solicita al usuario el nombre y la descripción de la nueva categoría y llama al controlador para agregarla.
*/
private void agregarCategoria() {
    System.out.print("Ingrese el nombre de la nueva categoria: ");
    String nombre = sc.nextLine();
    System.out.print("Ingrese la descripción de la nueva categoria: ");
    String descripcion = sc.nextLine();
    controllerCategoria.agregarCategoria(nombre, descripcion);
}

/**
* Modifica una categoría existente a través de la entrada del usuario.
* Este método lista las categorías disponibles, solicita al usuario que seleccionen una categoría para modificar 
* y luego permite al usuario ingresar nuevos valores para el nombre y la descripción.
*/
private void modificarCategoria() {
    // Listar las categorías disponibles
    listarCategorias();

    // Pedir al usuario que seleccione la categoría a modificar
    System.out.print("Seleccione el número de la categoría que desea modificar: ");
    int idCategoria = sc.nextInt();
    sc.nextLine();

    // Obtener la categoría seleccionada
    Categoria categoria = controllerCategoria.obtenerCategoriaPorId(idCategoria);
    
    if (categoria == null) {
        System.out.println("Categoría no encontrada.");
        return;
    }

    // Mostrar los detalles actuales de la categoría
    System.out.println("Categoría seleccionada: " + categoria.getNombre());
    System.out.println("Descripción actual: " + categoria.getDescripcion());

    // Pedir al usuario que ingrese el nuevo nombre o descripción
    System.out.print("Ingrese el nuevo nombre (o 's' para cancelar, o 'Enter' para mantener el actual): ");
    String nuevoNombre = sc.nextLine();
    if (nuevoNombre.equalsIgnoreCase("s")) {
        System.out.println("Operación cancelada.");
        return;
    }
    // Mantener el nombre actual si el campo está vacío
    if (nuevoNombre.isEmpty()) {
        nuevoNombre = categoria.getNombre();
    }

    System.out.print("Ingrese la nueva descripción (o 's' para cancelar, o 'Enter' para mantener la actual): ");
    String nuevaDescripcion = sc.nextLine();
    if (nuevaDescripcion.equalsIgnoreCase("s")) {
        System.out.println("Operación cancelada.");
        return;
    }
    // Mantener la descripción actual si el campo está vacío
    if (nuevaDescripcion.isEmpty()) {
        nuevaDescripcion = categoria.getDescripcion();
    }

    // Modificar la categoría
    controllerCategoria.modificarCategoria(idCategoria, nuevoNombre, nuevaDescripcion);

    categoria = null;
}
/**
* Elimina una categoría existente a través de la entrada del usuario.
* Este método lista las categorías disponibles y solicita al usuario que seleccione una categoría para eliminar.
*/
private void eliminarCategoria() {
    listarCategorias();  // Muestra la lista de categorías con sus IDs
    System.out.print("Seleccione el nº de la categoría a eliminar: ");
    int id = sc.nextInt();
    sc.nextLine(); // Limpiar el buffer
    // Validar que la categoría exista
    Categoria categoria = controllerCategoria.obtenerCategoriaPorId(id);
    if (categoria == null) {
        System.out.println("Categoría no encontrada. Operación cancelada.");
        return;
    }
    controllerCategoria.eliminarCategoria(id);
}
/**
* Lista las categorías disponibles en la aplicación.
* Este método utiliza el controlador para obtener la lista de categorías y luego las imprime en la consola.
*/
    private void listarCategorias() {
        System.out.println("Listado de categorías:");
        List<Categoria> categorias = controllerCategoria.obtenerCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            for (Categoria categoria : categorias) {
                System.out.println("Nro: " + categoria.getId() + " - " + categoria.getNombre());
            }
        }
    }
    
/**
* Lista las categorías con detalles adicionales.
* Este método lista las categorías disponibles y permite al usuario seleccionar una categoría para ver sus detalles, incluyendo sus subcategorías.
*/
private void listarCategoriasConDetalles() {
    int id = -1; // Inicializar id con un valor no válido
    listarCategorias(); // Muestra la lista de categorías

    do {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("           Seleccion de categoria           ");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.print("║ Seleccione el ID de la categoría para ver detalles (0 para volver): ");
        
        // Validar la entrada del usuario
        while (true) {
            try {
                id = sc.nextInt(); // Intentar leer el número
                sc.nextLine();
                if (id >= 0) {
                    break; // Salir del bucle si la entrada es válida
                } else {
                    System.out.println("║   Ingrese un número válido (0 o un ID positivo).");
                }
            } catch (InputMismatchException e) {
                System.out.println("║️  Entrada inválida. Ingrese un número.");
                sc.next();
            }
        }

        if (id != 0) {
            Categoria categoria = controllerCategoria.obtenerCategoriaPorId(id);
            if (categoria != null) {
                System.out.println("╔═══════════════════════════════════════════════════════════════════╗");
                System.out.println("             Detalles de la categoria seleccionada     ");
                System.out.println("╠═══════════════════════════════════════════════════════════════════╣");
                System.out.printf("  ID: %d%n", categoria.getId());
                System.out.printf("  Nombre: %s%n", categoria.getNombre());
                System.out.printf("  Descripción: %s%n", categoria.getDescripcion());
                
                System.out.println("     ═══════════════════════════════════════════════");
                System.out.println("  Subcategorías: ");
                List<Subcategoria> subcategorias = controllerCategoria.obtenerSubcategoriasPorCategoria(categoria);
                if (subcategorias.isEmpty()) {
                    System.out.println("║  No se encontraron subcategorías para esta categoría.");
                } else {
                    for (Subcategoria subcategoria : subcategorias) {
                        System.out.println("  - " + subcategoria.getNombre());
                    }
                }
                System.out.println(" *********═══════════════════**********══════════════════════════════*********");
            } else {
                System.out.println("╔══════════════════════════════════════════════════╗");
                System.out.println("║  ID no encontrado. Intente nuevamente.         ║");
                System.out.println("╚══════════════════════════════════════════════════╝");
            }
        }
    } while (id != 0); // Continua hasta que el usuario ingrese 0
}
}

