package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.color.Color;
import edu.fiuba.algo3.vista.BotonDeColor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.util.ArrayList;

public class BotonColorEventHandler implements EventHandler<ActionEvent> {
    private Color color;
    private final TextField inputNombre;
    private final Label listaInputs;
    private BotonDeColor miBotonDeColor;
    private ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton;

    public BotonColorEventHandler(TextField inputNombre, Label listaInputs, ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton){
        this.inputNombre = inputNombre;
        this.listaInputs = listaInputs;
        this.listaNombreYBoton = listaNombreYBoton;
    }

    public void setColor(Color unColor){
        this.color = unColor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.inputNombre.getText().trim().equals("")) {
            this.listaInputs.setText("Debe ingresar un nombre");
            this.listaInputs.setTextFill(javafx.scene.paint.Color.RED);
            this.inputNombre.requestFocus();

        } else {
            this.listaInputs.setTextFill(javafx.scene.paint.Color.WHITE);
            String nombre = inputNombre.getText();
            String linea = nombre + " tiene color: " + color.getNombre();
            this.listaInputs.setText(linea);
            listaNombreYBoton.clear();
            listaNombreYBoton.add(new Pair<>(nombre, this.miBotonDeColor));
        }
    }

    public void setColorSeleccionado(BotonDeColor botonDeColor) {
        this.miBotonDeColor = botonDeColor;
    }
}
