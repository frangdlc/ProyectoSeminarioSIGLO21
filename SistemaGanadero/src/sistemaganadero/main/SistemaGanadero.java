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
 * CUANDO COLOCO EN SELECCIONAR PARA MODIFICAR 0, ESTA TOMANDO UNA OPCION IGUAL
 * QUE AL EDITAR CARGUE LOS DATOS ANTERIORES
 * QUE TENGA LA OPCION DE CANCELAR
 * 
 * @author Usuario
 */
public class SistemaGanadero {

     public static void main(String[] args) {
        // Crear los DAOs simulados
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
                                    System.out.println("Hola2");

           Establecimiento establecimientoActual = controllerSistema.seleccionarEstablecimiento(usuarioActual, viewEstablecimiento);
                        System.out.println("Hola1");

            if (establecimientoActual != null) {
                // Mostrar menú principal
                viewMenuPrincipal.mostrarMenuPrincipal(usuarioActual, establecimientoActual);
            } else {
                System.out.println("No seleccionó un establecimiento. Volviendo al inicio.");
            }
        } else {
            System.out.println("Saliendo del sistema...");
        }
    }
}