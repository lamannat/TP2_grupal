package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonColorEventHandler;
import edu.fiuba.algo3.modelo.color.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class BotoneraColores extends HBox {

    public BotoneraColores(TextField texto, Label label, ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton) {

        List<BotonDeColor> botonesColores = new ArrayList<>();

        BotonDeColor botonColorAzul = new BotonDeColor(new ColorAzul());
        botonesColores.add(botonColorAzul);
        BotonDeColor botonColorRojo = new BotonDeColor(new ColorRojo());
        botonesColores.add(botonColorRojo);
        BotonDeColor botonColorVerde = new BotonDeColor(new ColorVerde());
        botonesColores.add(botonColorVerde);
        BotonDeColor botonColorMagenta = new BotonDeColor(new ColorMagenta());
        botonesColores.add(botonColorMagenta);
        BotonDeColor botonColorNegro = new BotonDeColor(new ColorNegro());
        botonesColores.add(botonColorNegro);
        BotonDeColor botonColorAmarillo = new BotonDeColor(new ColorAmarillo());
        botonesColores.add(botonColorAmarillo);

        for(BotonDeColor boton : botonesColores) {
            BotonColorEventHandler botonColorEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
            boton.enAccion(botonColorEventHandler);
            this.getChildren().add(boton);
        }

        botonColorAzul.setTextFill(javafx.scene.paint.Color.WHITE);
        botonColorRojo.setTextFill(javafx.scene.paint.Color.WHITE);
        botonColorVerde.setTextFill(javafx.scene.paint.Color.WHITE);
        botonColorMagenta.setTextFill(javafx.scene.paint.Color.WHITE);
        botonColorNegro.setTextFill(javafx.scene.paint.Color.WHITE);
        botonColorAmarillo.setTextFill(Color.BLACK);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
    }
}
