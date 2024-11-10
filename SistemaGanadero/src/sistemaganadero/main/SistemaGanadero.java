/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaganadero.main;

import sistemaganadero.controller.ControllerCategoria;
import sistemaganadero.controller.ControllerEstablecimiento;
import sistemaganadero.controller.ControllerInforme;
import sistemaganadero.controller.ControllerSistema;
import sistemaganadero.dao.CategoriaDAO;
import sistemaganadero.dao.EstablecimientoDAO;
import sistemaganadero.dao.ICategoriaDAO;
import sistemaganadero.dao.IEstablecimientoDAO;
import sistemaganadero.dao.IMovimientoDAO;
import sistemaganadero.dao.ISubcategoriaDAO;
import sistemaganadero.dao.IUsuarioDAO;
import sistemaganadero.dao.IUsuarioEstablecimientoDAO;
import sistemaganadero.dao.MovimientoDAO;
import sistemaganadero.dao.SubcategoriaDAO;
import sistemaganadero.dao.UsuarioDAO;
import sistemaganadero.dao.UsuarioEstablecimientoDAO;
import sistemaganadero.modelo.Usuario;
import sistemaganadero.modelo.Establecimiento;
import sistemaganadero.view.ViewCategoria;
import sistemaganadero.view.ViewEstablecimiento;
import sistemaganadero.view.ViewInformes;
import sistemaganadero.view.ViewInicioSesion;
import sistemaganadero.view.ViewMenuPrincipal;
import sistemaganadero.view.ViewMortandad;

/**
 * El programa simula un sistema de gestión ganadera. 
 * Utiliza objetos simulados (Mock), DAO para manejar datos y controladores para gestionar la lógica del negocio. Las vistas se encargan de la interacción con el usuario.
 * Pasos del Programa actualmente:
 * Crear Simulados:
 * DAOs (Data Access Objects) son objetos que manejan la interacción con la base de datos.
 * Aquí se crean versiones simuladas de estos DAOs, mediante MOCK para usuarios, establecimientos, categorías, subcategorías, movimientos y mortandad.
 * Crear Controladores:
 * Los controladores gestionan la lógica del negocio.
 * Se crean controladores para categorías, establecimientos, informes y el sistema general.
 * Crear Vistas:
 * Las vistas son las interfaces que interactúan con el usuario.
 * Se crean vistas para categorías, establecimientos, informes, mortandad, inicio de sesión y el menú principal.
 * Inicio de Sesión:
 * El usuario inicia sesión a través de la vista de inicio de sesión.
 * Si el inicio de sesión es exitoso, se muestra un mensaje de bienvenida.
 * Seleccionar Establecimiento:
 * El usuario selecciona un establecimiento a través de la vista correspondiente.
 * Si se selecciona un establecimiento, se muestra el menú principal.
 * Mostrar Menú Principal:
 * El menú principal permite al usuario interactuar con las diferentes partes del sistema.
 * 
 * @author Francisco de la Cruz v1.0
 */
public class SistemaGanadero {

    public static void main(String[] args) {
        // Inicialización de DAOs
        IUsuarioDAO usuarioDAO = new UsuarioDAO();
        IUsuarioEstablecimientoDAO usuarioEstablecimientoDAO = new UsuarioEstablecimientoDAO();
        IEstablecimientoDAO establecimientoDAO = new EstablecimientoDAO();
        ICategoriaDAO categoriaDAO = new CategoriaDAO();
        ISubcategoriaDAO subcategoriaDAO = new SubcategoriaDAO();
        IMovimientoDAO movimientoDAO = new MovimientoDAO();

        // Inicialización de controladores
        ControllerSistema controllerSistema = new ControllerSistema(usuarioDAO);
        ControllerEstablecimiento controllerEstablecimiento = new ControllerEstablecimiento(establecimientoDAO);
        ControllerCategoria controllerCategoria = new ControllerCategoria(categoriaDAO, subcategoriaDAO);
        ControllerInforme controllerInforme = new ControllerInforme(movimientoDAO);

        // Inicialización de vistas
        ViewInicioSesion viewInicioSesion = new ViewInicioSesion(controllerSistema);
        ViewEstablecimiento viewEstablecimiento = new ViewEstablecimiento(controllerEstablecimiento);
        ViewCategoria viewCategoria = new ViewCategoria(controllerCategoria);
        ViewInformes viewInformes = new ViewInformes(controllerInforme);
        ViewMortandad viewMortandad = new ViewMortandad(controllerInforme);

        // Creación de ViewMenuPrincipal con dependencias
        ViewMenuPrincipal viewMenuPrincipal = new ViewMenuPrincipal(viewCategoria, viewInformes);

        // Inicio de sesión
        Usuario usuarioActual = viewInicioSesion.iniciarSesion();

        if (usuarioActual != null) {
            System.out.println("Bienvenido, " + usuarioActual.getNombre());

            // Selección de establecimiento
            Establecimiento establecimientoActual = viewEstablecimiento.seleccionarEstablecimiento(usuarioActual.getId(), usuarioEstablecimientoDAO);

            if (establecimientoActual != null) {
                System.out.println("Establecimiento seleccionado: " + establecimientoActual.getNombre());

                // Muestra el menú principal
                viewMenuPrincipal.mostrarMenuPrincipal(usuarioActual, establecimientoActual);
            } else {
                System.out.println("No se seleccionó ningún establecimiento. Cerrando sesión...");
            }
        } else {
            System.out.println("Saliendo del sistema...");
        }
    }
}