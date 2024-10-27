/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;


/**
 * Representa una excepción personalizada que captura 
 * cuando una opción seleccionada no está disponible en el contexto de una operación.
 * Esta clase extiende la clase Exception de Java.
 * @author Francisco de la Cruz v1.0
 */
public class OptionNotAvailable extends Exception {
    /**
     * Constructor por defecto que crea una nueva instancia de OptionNotAvailable con un mensaje predeterminado.
     */
    public OptionNotAvailable() {
        super("Opcion elegida no disponible");
    }
    /**
     * Constructor que permite crear una nueva instancia de OptionNotAvailable con un mensaje personalizado.
     *
     * @param message El mensaje que describe la causa de la excepción.
     */
    public OptionNotAvailable(String message) {
        super(message);
    }

    /**
     * Constructor que permite crear una nueva instancia de OptionNotAvailable a partir de otra excepción.
     *
     * @param e La excepción original que se desea encapsular.
     */
    public OptionNotAvailable(Exception e) {
        super(e);
    }
}
