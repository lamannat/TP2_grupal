package edu.fiuba.algo3.controlador;

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

public class BotonSiguienteEventHandler implements EventHandler<ActionEvent> {

    private final Stage ventana;
    private final TextField inputUsuario;
    private final Label label;
    private final ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton;
    private int cantidadActualJugadores;
    private int cantidadTotalJugadores;


    public BotonSiguienteEventHandler(Stage unaVentana, ArrayList<Pair<String, BotonDeColor>> listaNombreYBoton, TextField texto, Label label,int cantidadTotalJugadores) {
        this.ventana = unaVentana;
        this.listaNombreYBoton = listaNombreYBoton;
        this.inputUsuario = texto;
        this.label = label;
        this.cantidadActualJugadores = 1;
        this.cantidadTotalJugadores = cantidadTotalJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(cantidadActualJugadores == cantidadTotalJugadores) {
            // Pasaría al mapa
            VistaJuego siguienteVista = new VistaJuego();
            ventana.setScene(siguienteVista.crearJuego(ventana));
        }

        else if (this.listaNombreYBoton.isEmpty()) {
            this.label.setText("Debe ingresar un color");
            this.label.setTextFill(javafx.scene.paint.Color.RED);
            this.inputUsuario.requestFocus();
            System.out.println("hay error");

        } else {
            Pair<String,BotonDeColor> par = listaNombreYBoton.get(0);
            String nombre = par.getKey();
            BotonDeColor boton = par.getValue();
            System.out.println("Nombre: "+nombre+" Boton: " + boton.getText());
            listaNombreYBoton.clear();
            this.inputUsuario.clear();
            this.inputUsuario.requestFocus();
            this.label.setText("");
            boton.desactivar(nombre);
            cantidadActualJugadores++;
        }

    }
}
