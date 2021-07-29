package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.ArrayList;

public class BotonSiguienteEventHandler implements EventHandler<ActionEvent> {

    TextField inputUsuario;
    Label label;
    ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton;

    public BotonSiguienteEventHandler(ArrayList<Pair<String, BotonDeColor>> listaNombreYBoton, TextField texto) {
        this.listaNombreYBoton = listaNombreYBoton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (this.listaNombreYBoton.isEmpty()) {
            System.out.println("hay error");
            //label

        } else {
            Pair<String,BotonDeColor> par = listaNombreYBoton.get(0);
            String nombre = par.getKey();
            BotonDeColor boton = par.getValue();
            System.out.println("Nombre: "+nombre+" Boton: " + boton.getText());
            listaNombreYBoton.clear();
        }

    }
}
