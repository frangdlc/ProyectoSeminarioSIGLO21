/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaganadero.main;

import sistemaganadero.controller.ControllerCategoria;
import sistemaganadero.controller.ControllerEstablecimiento;
import sistemaganadero.controller.ControllerInforme;
import sistemaganadero.controller.ControllerSistema;
import sistemaganadero.dao.ICategoriaDAO;
import sistemaganadero.dao.IEstablecimientoDAO;
import sistemaganadero.dao.IMortandadDAO;
import sistemaganadero.dao.IMovimientoDAO;
import sistemaganadero.dao.ISubcategoriaDAO;
import sistemaganadero.dao.IUsuarioDAO;
import sistemaganadero.dao.IUsuarioEstablecimientoDAO;
import sistemaganadero.dao.MockCategoriaDAO;
import sistemaganadero.dao.MockEstablecimientoDAO;
import sistemaganadero.dao.MockMortandadDAO;
import sistemaganadero.dao.MockMovimientoDAO;
import sistemaganadero.dao.MockSubcategoriaDAO;
import sistemaganadero.dao.MockUsuarioDAO;
import sistemaganadero.dao.MockUsuarioEstablecimientoDAO;
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
        // Crear los datos simulados
        IUsuarioDAO mockUsuarioDAO = new MockUsuarioDAO();
        IEstablecimientoDAO mockEstablecimientoDAO = new MockEstablecimientoDAO();
        IUsuarioEstablecimientoDAO mockUsuarioEstablecimientoDAO = new MockUsuarioEstablecimientoDAO();
        ICategoriaDAO mockCategoriaDAO = new MockCategoriaDAO();
        ISubcategoriaDAO mockSubcategoriaDAO = new MockSubcategoriaDAO(mockCategoriaDAO);
        IMovimientoDAO mockMovimientoDAO = new MockMovimientoDAO(mockEstablecimientoDAO, mockSubcategoriaDAO);  
        IMortandadDAO mockMortandadDAO = new MockMortandadDAO(mockMovimientoDAO); 

        // Crear controladores
        ControllerCategoria categoriaController = new ControllerCategoria(mockCategoriaDAO, mockSubcategoriaDAO);
        ControllerEstablecimiento establecimientoController = new ControllerEstablecimiento(mockEstablecimientoDAO);
        ControllerInforme informeController = new ControllerInforme(mockMortandadDAO);
        ControllerSistema controllerSistema = new ControllerSistema(mockUsuarioDAO.obtenerUsuarios(), mockUsuarioEstablecimientoDAO);

        // Crear vistas
        ViewCategoria categoriaView = new ViewCategoria(categoriaController);
        ViewEstablecimiento viewEstablecimiento = new ViewEstablecimiento(establecimientoController);
        ViewInformes viewInformes = new ViewInformes(informeController);
        ViewMortandad viewMortandad = new ViewMortandad(informeController);
        ViewInicioSesion viewInicioSesion = new ViewInicioSesion(controllerSistema);
        ViewMenuPrincipal viewMenuPrincipal = new ViewMenuPrincipal(categoriaView, viewInformes, viewMortandad);

        // Inicio de sesión
        Usuario usuarioActual = viewInicioSesion.iniciarSesion();

        if (usuarioActual != null) {
            System.out.println("Bienvenido, " + usuarioActual.getNombre());
            
            // Seleccionar establecimiento
           Establecimiento establecimientoActual = controllerSistema.seleccionarEstablecimiento(usuarioActual, viewEstablecimiento);

            if (establecimientoActual != null) {
                // Mostrar menú principal
                viewMenuPrincipal.mostrarMenuPrincipal(usuarioActual, establecimientoActual);
            } else {
                System.out.println("Cerrando sesion...");
            }
        } else {
            System.out.println("Saliendo del sistema...");
        }
    }
}