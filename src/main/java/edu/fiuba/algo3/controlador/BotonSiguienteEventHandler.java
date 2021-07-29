package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BotonSiguienteEventHandler implements EventHandler<ActionEvent> {

    TextField inputUsuario;
    Label label;
    ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton;


    public BotonSiguienteEventHandler(ArrayList<Pair<String, BotonDeColor>> listaNombreYBoton, TextField texto, Label label) {
        this.listaNombreYBoton = listaNombreYBoton;
        this.inputUsuario = texto;
        this.label = label;
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
            this.inputUsuario.clear();
            this.inputUsuario.requestFocus();
            this.label.setText("");
            boton.desactivar(nombre);
        }

    }
}
