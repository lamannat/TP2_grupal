package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonColorEventHandler;
import edu.fiuba.algo3.controlador.BotonDeColor;
import edu.fiuba.algo3.controlador.BotonSiguiente;
import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.color.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;

public class VistaSetearNombresYColores {

    Integer cantJugadores;

    public void setCantJugadores(Integer n){
        cantJugadores = n;
    }

    public Scene crearJugadores(Stage ventana, Scene mapa){
        HBox hboxTexto = new HBox();
        hboxTexto.setStyle("-fx-background-color: #272727");

        TextField texto = new TextField();
        texto.setPromptText("Ingrese el nombre del Jugador");
        texto.setScaleX(2);
        texto.setScaleY(2);

        Label label = new Label();
        label.setTextFill(Color.WHITE);
        label.setScaleX(3);
        label.setScaleY(3);

        BotonSiguiente botonSiguiente = new BotonSiguiente(3);
        botonSiguiente.setText("Siguiente Jugador");
        botonSiguiente.setScaleX(3);
        botonSiguiente.setScaleY(3);

        ArrayList<Pair<String,BotonDeColor>> listaNombreYBoton = new ArrayList<>();

        botonSiguiente.setOnAction(new BotonSiguienteEventHandler(listaNombreYBoton,texto,label));

        hboxTexto.setSpacing(320.0);
        hboxTexto.setAlignment(Pos.CENTER);
        hboxTexto.getChildren().addAll(texto,botonSiguiente);
        HBox hboxColores = new HBox();
        hboxColores.setStyle("-fx-background-color: #272727");

        //seteamos botones de colores
        BotonDeColor botonColorAzul = new BotonDeColor(new ColorAzul());
        BotonDeColor botonColorRojo = new BotonDeColor(new ColorRojo());
        BotonDeColor botonColorVerde = new BotonDeColor(new ColorVerde());
        BotonDeColor botonColorMagenta = new BotonDeColor(new ColorMagenta());
        BotonDeColor botonColorNegro = new BotonDeColor(new ColorNegro());
        BotonDeColor botonColorAmarillo = new BotonDeColor(new ColorAmarillo());

        botonColorAzul.setTextFill(Color.WHITE);
        botonColorRojo.setTextFill(Color.WHITE);
        botonColorVerde.setTextFill(Color.WHITE);
        botonColorMagenta.setTextFill(Color.WHITE);
        botonColorNegro.setTextFill(Color.WHITE);
        botonColorAmarillo.setTextFill(Color.BLACK);

        BotonColorEventHandler botonAzulEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
        botonColorAzul.enAccion(botonAzulEventHandler);
        BotonColorEventHandler botonRojoEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
        botonColorRojo.enAccion(botonRojoEventHandler);
        BotonColorEventHandler botonVerdeEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
        botonColorVerde.enAccion(botonVerdeEventHandler);
        BotonColorEventHandler botonMagentaEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
        botonColorMagenta.enAccion(botonMagentaEventHandler);
        BotonColorEventHandler botonNegroEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
        botonColorNegro.enAccion(botonNegroEventHandler);
        BotonColorEventHandler botonAmarilloEventHandler = new BotonColorEventHandler(texto,label,listaNombreYBoton);
        botonColorAmarillo.enAccion(botonAmarilloEventHandler);

        hboxColores.getChildren().addAll(botonColorAzul,botonColorAmarillo,botonColorMagenta,botonColorNegro,botonColorRojo,botonColorVerde);
        hboxColores.setAlignment(Pos.CENTER);
        hboxColores.setSpacing(200);

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(100.0);
        vbox.getChildren().addAll(hboxTexto,hboxColores,label);
        vbox.setMinSize(110.0,110.0);
        vbox.setStyle("-fx-background-color: #272727");

        Scene sceneJugadores = new Scene(vbox);

        return sceneJugadores;

    }
}
