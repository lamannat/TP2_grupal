package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.moduloRonda.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.Ronda;
import edu.fiuba.algo3.modelo.moduloRonda.RondaAgregarCincoFichas;
import edu.fiuba.algo3.vista.ataque.BloqueDeAtaque;
import edu.fiuba.algo3.vista.incorporacion.BloqueDeIncorporacion;
import edu.fiuba.algo3.vista.movimiento.BloqueDeMovimiento;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class VistaJuego extends Escena implements Observer{

    private final BorderPane padre;
    private final SetUpJuego setUp;
    private Juego juego;
    private BloqueDeIncorporacion bloqueIncorporacion;
    private BloqueDeAtaque bloqueDeAtaque;
    private BloqueDeMovimiento bloqueDeMovimiento;
    private HBox estados;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (BorderPane) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        this.juego = setUp.dameJuego();
        juego.agregarObserverARondaActual(this);

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());

        estados = new HBox();
        estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo());
        Label estadoTitulo = new Label("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));
        estadoTitulo.setScaleX(2);
        estadoTitulo.setScaleY(2);
        estadoTitulo.setTextFill(Color.BLACK);
        estados.getChildren().add(estadoTitulo);
        estados.setAlignment(Pos.CENTER);
        estados.setScaleX(3);
        estados.setScaleY(3);

        this.bloqueIncorporacion = new BloqueDeIncorporacion(juego);
        this.bloqueDeAtaque = new BloqueDeAtaque(juego);
        this.bloqueDeMovimiento = new BloqueDeMovimiento(juego);
        bloqueIncorporacion.setVisible(false);
        bloqueDeAtaque.setVisible(false);
        bloqueDeMovimiento.setVisible(false);

        BotonSiguienteTurno botonSiguienteTurno = new BotonSiguienteTurno(juego,this);

        StackPane acciones = new StackPane();
        acciones.getChildren().addAll(bloqueDeMovimiento, bloqueDeAtaque, bloqueIncorporacion);

        padre.setTop(estados);
        padre.setCenter(this.setearMapa());
        padre.setRight(acciones);
        padre.setBottom(botonSiguienteTurno);

        this.juego.agregarObserverARondaActual(this);

//        padre.setStyle("-fx-background-color: black");
    }

    private ImageView setearMapa(){
        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;
    }


    @Override
    public void change() {
//        String nombreRonda = juego.dameNombreRonda();
//        if (nombreRonda == "RondaAgregarCincoFichas")

        Ronda ronda = juego.dameRonda();
        Accion fase = ronda.dameFase();

        this.bloqueIncorporacion.setVisible(false);
        this.bloqueDeAtaque.setVisible(false);
        this.bloqueDeMovimiento.setVisible(false);

        switch (fase.ID()){
            case "AgregarFichas":
                this.bloqueIncorporacion.actualizar();
                this.bloqueIncorporacion.setVisible(true);
                break;
            case "Ataque":
                this.bloqueDeAtaque.setVisible(true);
                break;
            case "Movimiento":
                this.bloqueDeMovimiento.setVisible(true);
                break;
            case "SolicitarCarta":
                break;
        }
        this.estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo());
        Label estadoTitulo = (Label)(this.estados.getChildren().get(0));
        estadoTitulo.setText("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));

    }
}
