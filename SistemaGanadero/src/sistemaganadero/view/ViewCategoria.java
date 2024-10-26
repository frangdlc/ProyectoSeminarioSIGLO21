/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaganadero.view;

import exceptions.OptionNotAvailable;
import java.util.List;
import java.util.Scanner;
import sistemaganadero.controller.ControllerCategoria;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;



/**
 *
 * @author Usuario
 */

public class ViewCategoria {
    private ControllerCategoria controllerCategoria;
    private Scanner sc = new Scanner(System.in);

    public ViewCategoria(ControllerCategoria controllerCategoria) {
        this.controllerCategoria = controllerCategoria;
    }

public void mostrarMenuCategoria(Usuario usuarioActual) {
    Scanner sc = new Scanner(System.in);
    int opcionCategoria = -1;

    if (usuarioActual.getRol().getNombre().equalsIgnoreCase("Dueño")) {
        do {
            try {
                // Mostrar el menú de categorías
                mostrarMenuCategoriaOpciones();

                // Solicitar opción del usuario
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

private void mostrarMenuCategoriaOpciones() {
    System.out.println("--------------------------");
    System.out.println("    Menu Categoria    ");
    System.out.println("1) Agregar categoria");
    System.out.println("2) Modificar categoria");
    System.out.println("3) Eliminar categoria");
    System.out.println("4) Listar categorias");
    System.out.println("0) Volver");
    System.out.println("--------------------------");
}

private int solicitarOpcionCategoria(Scanner sc) {
    int opcion = -1;
    while (true) {
        System.out.print("Seleccione una opción: ");
        if (sc.hasNextInt()) {
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            if (opcion >= 0 && opcion <= 4) {
                break; // Opción válida
            } else {
                System.out.println("Opción inválida, debe ser entre 0 y 4.");
            }
        } else {
            System.out.println("Por favor, ingrese un número válido.");
            sc.next(); // Limpiar el buffer
        }
    }
    return opcion;
}
    private void agregarCategoria() {
        System.out.print("Ingrese el nombre de la nueva categoria: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la descripción de la nueva categoria: ");
        String descripcion = sc.nextLine();
        controllerCategoria.agregarCategoria(nombre, descripcion);
        System.out.println("Categoría agregada.");
    }

private void modificarCategoria() {
    listarCategorias();
    System.out.print("Seleccione el ID de la categoría a modificar: ");
    int id = sc.nextInt();
    sc.nextLine(); // Limpiar el buffer

    Categoria categoria = controllerCategoria.obtenerCategoriaPorId(id);

    if (categoria == null) {
        System.out.println("ID no encontrado.");
        return;
    }

    // Mostrar los valores actuales
    System.out.println("Valores actuales:");
    System.out.println("Nombre actual: " + categoria.getNombre());
    System.out.println("Descripción actual: " + categoria.getDescripcion());

    // Permitir ingresar nuevos valores
    System.out.print("Ingrese el nuevo nombre (o presione Enter para mantener el actual): ");
    String nombre = sc.nextLine();
    if (nombre.isEmpty()) {
        nombre = categoria.getNombre(); // Mantener el nombre actual
    }

    System.out.print("Ingrese la nueva descripción (o presione Enter para mantener la actual): ");
    String descripcion = sc.nextLine();
    if (descripcion.isEmpty()) {
        descripcion = categoria.getDescripcion(); // Mantener la descripción actual
    }

    controllerCategoria.modificarCategoria(id, nombre, descripcion);
    System.out.println("Categoría modificada.");
}

    private void eliminarCategoria() {
        listarCategorias();
        System.out.print("Seleccione el ID de la categoría a eliminar: ");
        int id = sc.nextInt();
        controllerCategoria.eliminarCategoria(id);
        System.out.println("Categoría eliminada.");
    }

    private void listarCategorias() {
        System.out.println("Listado de categorías:");
        List<Categoria> categorias = controllerCategoria.obtenerCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            for (Categoria categoria : categorias) {
                System.out.println("ID: " + categoria.getId() + " - " + categoria.getNombre());
            }
        }
    }

    private void listarCategoriasConDetalles() {
        listarCategorias();
        System.out.print("Seleccione el ID de la categoría para ver detalles o 0 para volver: ");
        int id = sc.nextInt();

        if (id != 0) {
            Categoria categoria = controllerCategoria.obtenerCategoriaPorId(id);
            if (categoria != null) {
                System.out.println("Detalles de la categoría: ");
                System.out.println("ID: " + categoria.getId());
                System.out.println("Nombre: " + categoria.getNombre());
                System.out.println("Descripción: " + categoria.getDescripcion());

                System.out.println("Subcategorías:");
                List<Subcategoria> subcategorias = controllerCategoria.obtenerSubcategoriasPorCategoria(categoria);
                for (Subcategoria subcategoria : subcategorias) {
                    System.out.println(" - " + subcategoria.getNombre());
                }
            } else {
                System.out.println("ID no encontrado.");
            }
        }
    }
}


