/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaganadero.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import sistemaganadero.dao.MockCategoriaDAO;
import sistemaganadero.dao.MockEstablecimientoDAO;
import sistemaganadero.dao.MockMortandadDAO;
import sistemaganadero.dao.MockMovimientoDAO;
import sistemaganadero.dao.MockSubcategoriaDAO;
import sistemaganadero.dao.MockUsuarioDAO;
import sistemaganadero.dao.MockUsuarioEstablecimientoDAO;
import sistemaganadero.modelo.Categoria;
import sistemaganadero.modelo.Subcategoria;
import sistemaganadero.modelo.Movimiento;

import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Rol;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.modelo.Mortandad;

/**
 *
 * @author Usuario
 */
public class SistemaGanadero {

    public static void main(String[] args) {
        // Crear los DAOs simulados
        MockUsuarioDAO mockUsuarioDAO = new MockUsuarioDAO();
        MockEstablecimientoDAO mockEstablecimientoDAO = new MockEstablecimientoDAO();
        MockUsuarioEstablecimientoDAO mockUsuarioEstablecimientoDAO = new MockUsuarioEstablecimientoDAO();
        MockCategoriaDAO mockCategoriaDAO = new MockCategoriaDAO();
        MockSubcategoriaDAO mockSubcategoriaDAO = new MockSubcategoriaDAO(mockCategoriaDAO);
 // Instanciar MockMovimientoDAO con dependencias
        MockMovimientoDAO mockMovimientoDAO = new MockMovimientoDAO(mockEstablecimientoDAO, mockSubcategoriaDAO);  
        
        // Instanciar MockMortandadDAO con la instancia de MockMovimientoDAO
        MockMortandadDAO mockMortandadDAO = new MockMortandadDAO(mockMovimientoDAO); 
        
        Establecimiento establecimientoActual = null;
        // Obtener los usuarios simulados
        List<Usuario> usuarios = mockUsuarioDAO.obtenerUsuarios();
        Scanner sc = new Scanner(System.in);
        System.out.println("Inicio de Sesion");

        Usuario usuarioActual = validarLogin(usuarios);


        if (usuarioActual != null) {
            // Mostrar mensaje de bienvenida
            System.out.println("Bienvenido, " + usuarioActual.getNombre());

            // Seleccionar establecimiento
            List<Integer> establecimientos = mockUsuarioEstablecimientoDAO.obtenerEstablecimientosPorUsuario(usuarioActual.getId());
            if (!establecimientos.isEmpty()) {
                establecimientoActual = seleccionarEstablecimiento(mockEstablecimientoDAO, establecimientos);
                
                if (establecimientoActual != null) {
                    System.out.println("Establecimiento seleccionado: " + establecimientoActual.getNombre());

                    // Menú principal
                    mostrarMenuPrincipal(usuarioActual, mockCategoriaDAO, mockSubcategoriaDAO, establecimientoActual, mockMortandadDAO);
                } else {
                    System.out.println("No seleccionó un establecimiento. Volviendo al inicio.");
                }
            } else {
                System.out.println("No tiene establecimientos asignados.");
            }
        } else {
            System.out.println("Saliendo del sistema...");
        }
    }

    /**
     * Función para validar el inicio de sesión
     * 
     * @param usuarios Listado de usuarios disponibles para el login
     * @return Usuario logueado si el login fue exitoso, null si el usuario decide salir
     */
    private static Usuario validarLogin(List<Usuario> usuarios) {
        Scanner sc = new Scanner(System.in);
        boolean loginExitoso = false;
        Usuario usuarioActual = null;

        while (!loginExitoso) {
            System.out.print("Ingrese usuario (nombre o correo) o 'S' para salir: ");
            String usuarioInput = sc.nextLine();
            if (usuarioInput.equalsIgnoreCase("S")) {
                return null;  // Salir del sistema
            }

            System.out.print("Ingrese contraseña o 'S' para salir: ");
            String passwordInput = sc.nextLine();
            if (passwordInput.equalsIgnoreCase("S")) {
                return null;  // Salir del sistema
            }

            // Validar credenciales
            for (Usuario usuario : usuarios) {
                if ((usuario.getNombre().equals(usuarioInput) || usuario.getEmail().equals(usuarioInput)) &&
                        usuario.getPassword().equals(passwordInput)) {
                    loginExitoso = true;
                    usuarioActual = usuario;
                    break;
                }
            }

            if (!loginExitoso) {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }
        return usuarioActual;  // Login exitoso
    }
    
    private static Establecimiento seleccionarEstablecimiento(MockEstablecimientoDAO mockEstablecimientoDAO, List<Integer> idsEstablecimientos) {
        Scanner sc = new Scanner(System.in);
        List<Establecimiento> establecimientosUsuario = new ArrayList<>();

        // Obtener solo los establecimientos relacionados con el usuario
        for (Integer idEstablecimiento : idsEstablecimientos) {
            for (Establecimiento est : mockEstablecimientoDAO.obtenerEstablecimientos()) {
                if (est.getId() == idEstablecimiento) {
                    establecimientosUsuario.add(est);
                }
            }
        }

        if (establecimientosUsuario.isEmpty()) {
            System.out.println("No hay establecimientos disponibles.");
            return null;
        }

        System.out.println("Seleccione un establecimiento:");

        // Mostrar los establecimientos disponibles
        for (int i = 0; i < establecimientosUsuario.size(); i++) {
            System.out.println((i + 1) + ") " + establecimientosUsuario.get(i).getNombre());
        }

        int seleccion = -1;
        do {
            try {
                System.out.print("Ingrese el número de establecimiento (o 0 para salir): ");
                seleccion = sc.nextInt();
                if (seleccion == 0) {
                    return null; // Usuario eligió salir
                }
                if (seleccion < 1 || seleccion > establecimientosUsuario.size()) {
                    System.out.println("Debe ingresar una opción válida.");
                    seleccion = -1;
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar un número.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        } while (seleccion == -1);

        // Retornar el establecimiento seleccionado
        return establecimientosUsuario.get(seleccion - 1);
    }

    private static void mostrarMenuPrincipal(Usuario usuarioActual, MockCategoriaDAO mockCategoriaDAO, MockSubcategoriaDAO mockSubcategoriaDAO, Establecimiento establecimientoActual,MockMortandadDAO mockMortandadDAO) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("    Menu Principal    ");
            System.out.println("1) Categoria");
            System.out.println("2) Movimientos");
            System.out.println("3) Informes");
            System.out.println("4) Cerrar Sesión");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMenuCategoria(usuarioActual, mockCategoriaDAO, mockSubcategoriaDAO);
                    break;
                case 2:
                    System.out.println("Movimientos aún no implementado.");
                    break;
                case 3:
                    mostrarMenuInformes(establecimientoActual, mockMortandadDAO);
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
     * Función para mostrar el menú de categorías
     */
private static void mostrarMenuCategoria(Usuario usuarioActual, MockCategoriaDAO mockCategoriaDAO, MockSubcategoriaDAO mockSubcategoriaDAO) {
    Scanner sc = new Scanner(System.in);
    int opcionCategoria;

    // Si el usuario es "Dueño/a", mostrar todas las opciones
    if (usuarioActual.getRol().getNombre().equalsIgnoreCase("Dueño")) {
        do {
            System.out.println("    Menu Categoria    ");
            System.out.println("1) Agregar categoria");
            System.out.println("2) Modificar categoria");
            System.out.println("3) Eliminar categoria");
            System.out.println("4) Listar categorias");
            System.out.println("0) Volver");
            System.out.print("Seleccione una opción: ");
            opcionCategoria = sc.nextInt();

            switch (opcionCategoria) {
                case 1:
                    agregarCategoria(mockCategoriaDAO);
                    break;
                case 2:
                    modificarCategoria(mockCategoriaDAO);
                    break;
                case 3:
                    eliminarCategoria(mockCategoriaDAO);
                    break;
                case 4:
                    listarCategoriasConDetalles(mockCategoriaDAO, mockSubcategoriaDAO);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcionCategoria != 0);

    } else {
        // Si no es "Dueño/a", solo mostrar "Listar categorias" y "Volver"
        listarCategoriasConDetalles(mockCategoriaDAO, mockSubcategoriaDAO);
    }
}

private static void listarCategoriasConDetalles(MockCategoriaDAO mockCategoriaDAO, MockSubcategoriaDAO mockSubcategoriaDAO) {
    Scanner sc = new Scanner(System.in);

    // Listar las categorías
    listarCategorias(mockCategoriaDAO);

    // Menu para ver detalles o volver
    int opcionDetalle = -1; // Inicializa con un valor no válido
    do {
        try {
            System.out.print("Seleccione el ID de la categoría para ver detalles o 0 para volver: ");
            opcionDetalle = sc.nextInt();

            if (opcionDetalle > 0) {
                Categoria categoriaSeleccionada = null;

                // Buscar la categoría seleccionada usando un bucle for
                for (Categoria categoria : mockCategoriaDAO.obtenerCategorias()) {
                    if (categoria.getId() == opcionDetalle) {
                        categoriaSeleccionada = categoria;
                        break; // Salir del bucle si se encuentra la categoría
                    }
                }

                if (categoriaSeleccionada != null) {
                    mostrarDetallesCategoria(categoriaSeleccionada, mockSubcategoriaDAO);
                } else {
                    System.out.println("Categoría no encontrada.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Debe ser un número entero.");
            sc.next(); // Limpiar el buffer del scanner
        }
    } while (opcionDetalle != 0);

    System.out.println("Volviendo al menú de categorías...");
}

private static void mostrarDetallesCategoria(Categoria categoria, MockSubcategoriaDAO mockSubcategoriaDAO) {
    System.out.println("Detalles de la Categoría:");
    System.out.println("Nombre: " + categoria.getNombre());
    System.out.println("Descripción: " + categoria.getDescripcion());

    // Mostrar subcategorías de la categoría seleccionada
    List<Subcategoria> subcategorias = mockSubcategoriaDAO.obtenerSubcategoriasPorCategoria(categoria);
    if (!subcategorias.isEmpty()) {
        System.out.println("Subcategorías:");
        for (Subcategoria subcategoria : subcategorias) {
            System.out.println("- " + subcategoria.getNombre());
        }
    } else {
        System.out.println("No hay subcategorías asociadas.");
    }

    // La única opción es volver
    Scanner sc = new Scanner(System.in);
    System.out.println("Presione cualquier tecla para volver...");
    sc.nextLine();
}

private static void agregarCategoria(MockCategoriaDAO mockCategoriaDAO) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el nombre de la nueva categoria: ");
    String nuevoNombre = sc.nextLine();
    System.out.print("Ingrese la descripción de la nueva categoria: ");
    String nuevaDescripcion = sc.nextLine();
    mockCategoriaDAO.agregarCategoria(new Categoria(mockCategoriaDAO.obtenerCategorias().size() + 1, nuevoNombre, nuevaDescripcion));
    System.out.println("Categoría agregada.");
}

private static void modificarCategoria(MockCategoriaDAO mockCategoriaDAO) {
    Scanner sc = new Scanner(System.in);
    listarCategorias(mockCategoriaDAO);
    System.out.print("Seleccione el ID de la categoría a modificar: ");
    int idModificar = sc.nextInt();
    sc.nextLine(); // limpiar el buffer
    System.out.print("Ingrese el nuevo nombre: ");
    String nombreModificado = sc.nextLine();
    System.out.print("Ingrese la nueva descripción: ");
    String descripcionModificada = sc.nextLine();
    mockCategoriaDAO.modificarCategoria(idModificar, nombreModificado, descripcionModificada);
    System.out.println("Categoría modificada.");
}

private static void eliminarCategoria(MockCategoriaDAO mockCategoriaDAO) {
    Scanner sc = new Scanner(System.in);
    listarCategorias(mockCategoriaDAO);
    System.out.print("Seleccione el ID de la categoría a eliminar: ");
    int idEliminar = sc.nextInt();
    mockCategoriaDAO.eliminarCategoria(idEliminar);
    System.out.println("Categoría eliminada.");
}
private static void listarCategorias(MockCategoriaDAO mockCategoriaDAO) {
    System.out.println("Listado de categorías:");
    // Obtener todas las categorías y mostrarlas
    List<Categoria> categorias = mockCategoriaDAO.obtenerCategorias();
    if (categorias.isEmpty()) {
        System.out.println("No hay categorías disponibles.");
    } else {
        for (Categoria categoria : categorias) {
            System.out.println("ID: " + categoria.getId() + " - " + categoria.getNombre());
        }
    }
    System.out.println("0) Volver");
}

private static void mostrarMenuInformes(Establecimiento establecimientoActual, MockMortandadDAO mockMortandadDAO) {
    Scanner sc = new Scanner(System.in);
    int opcionInforme;

    do {
        System.out.println("    Menu de Informes    ");
        System.out.println
("1) Informe de mortandad por fechas");
        System.out.println("0) Volver");
        System.out.print("Seleccione una opción: ");
        opcionInforme = sc.nextInt();

        switch (opcionInforme) {
            case 1:
                System.out.print("Ingrese la fecha desde (yyyy-MM-dd): ");
                Date desde = Date.valueOf(sc.next());
                System.out.print("Ingrese la fecha hasta (yyyy-MM-dd): ");
                Date hasta = Date.valueOf(sc.next());

                // Obtener las mortandades en el rango de fechas para el establecimiento actual
                List<Mortandad> mortandades = mockMortandadDAO.obtenerMortandadesPorFechasYEstablecimiento(desde, hasta, establecimientoActual);

                if (mortandades.isEmpty()) {
                    System.out.println("No se encontraron mortandades en el rango seleccionado.");
                } else {
                        System.out.println("Mortandades encontradas:");
                        for (Mortandad mortandad : mortandades) {
                            System.out.println("ID Movimiento: " + mortandad.getId());
                            System.out.println("Fecha: " + mortandad.getFecha());
                            System.out.println("Causa: " + mortandad.getCausa());
                            System.out.println("N° Trazabilidad: " + mortandad.getNumeroTrazabilidad());
                            // Información del movimiento y subcategoría
                            Movimiento movimiento = mortandad.getMovimiento();
                            Subcategoria subcategoria = movimiento.getSubcategoria();
                            System.out.println("Subcategoría: " + subcategoria.getNombre());
                            System.out.println("-----------------------------");
                        }
                    
                }
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
