package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.VistaJuego;
import edu.fiuba.algo3.vista.VistaTitulo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BotonSiguienteJugadorEventHandler implements EventHandler<ActionEvent> {

    private final Stage ventana;
    private final TextField inputUsuario;
    private final Label label;
    private final ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton;
    private final Button botonSiguiente;
    private int cantidadActualJugadores;
    private int cantidadTotalJugadores;
    private final Juego juego;


    public BotonSiguienteJugadorEventHandler(Stage unaVentana, ArrayList<Pair<String, BotonDeColor>> listaNombreYBoton, TextField texto, Label label, int cantidadTotalJugadores, Button botonSiguiente, Juego juego) {
        this.ventana = unaVentana;
        this.listaNombreYBoton = listaNombreYBoton;
        this.inputUsuario = texto;
        this.label = label;
        this.cantidadActualJugadores = 0;
        this.cantidadTotalJugadores = cantidadTotalJugadores;
        this.botonSiguiente = botonSiguiente;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (cantidadActualJugadores >= cantidadTotalJugadores) {
            this.label.setText("Ya eligio la cantidad suficiente de jugadores, aprete Siguiente");
            this.label.setTextFill(javafx.scene.paint.Color.RED);
            this.inputUsuario.requestFocus();
            System.out.println("hay error v2");

        } else if (this.listaNombreYBoton.isEmpty()) {
            this.label.setText("Debe ingresar un color");
            this.label.setTextFill(javafx.scene.paint.Color.RED);
            this.inputUsuario.requestFocus();
            System.out.println("hay error");

        } else {
            Pair<String,BotonDeColor> par = listaNombreYBoton.get(0);

            BotonDeColor boton = par.getValue();

            Color color = boton.getColor();
            String nombre = par.getKey();

            this.juego.setearJugador(nombre, color);

            listaNombreYBoton.clear();
            this.inputUsuario.clear();
            this.inputUsuario.requestFocus();
            this.label.setText("");
            boton.desactivar(nombre);
            cantidadActualJugadores++;
        }

        if (cantidadActualJugadores == cantidadTotalJugadores) {
            botonSiguiente.setVisible(true);
        }
    }
}
