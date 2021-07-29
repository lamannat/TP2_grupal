package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaSetearCantidadJugadores;
import edu.fiuba.algo3.vista.VistaSetearNombresYColores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonCantidadEventHandler implements EventHandler<ActionEvent> {
    private int cantidadBoton;
    private Stage ventana;

    public BotonCantidadEventHandler(Stage ventana,int unaCantidad) {
        this.ventana = ventana;
        this.cantidadBoton = unaCantidad;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VistaSetearNombresYColores siguienteVista = new VistaSetearNombresYColores();
        siguienteVista.setCantJugadores(cantidadBoton);
        Scene nuevaEscena = siguienteVista.crearJugadores(ventana);
        ventana.setScene(nuevaEscena);
    }
}
