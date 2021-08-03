package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.moduloRonda.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.Ronda;
import edu.fiuba.algo3.modelo.moduloRonda.RondaAgregarCincoFichas;
import edu.fiuba.algo3.vista.ataque.BloqueDeAtaque;
import edu.fiuba.algo3.vista.incorporacion.BloqueDeIncorporacion;
import edu.fiuba.algo3.vista.movimiento.BloqueDeMovimiento;
import edu.fiuba.algo3.vista.solicitar.BloqueSolicitarCarta;
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
import java.util.HashMap;
import java.util.Map;

public class VistaJuego extends Escena implements Observer{

    private final BorderPane padre;
    private final SetUpJuego setUp;
    private Juego juego;
    private Map<String, BloqueAccion> bloqueDeAccion;
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

        bloqueDeAccion = new HashMap<>();

        bloqueDeAccion.put("AgregarFichas", new BloqueDeIncorporacion(juego));
        bloqueDeAccion.put("Ataque", new BloqueDeAtaque(juego));
        bloqueDeAccion.put("Movimiento", new BloqueDeMovimiento(juego));
        bloqueDeAccion.put("SolicitarCarta", new BloqueSolicitarCarta(juego));

        for (BloqueAccion bloque : bloqueDeAccion.values())
            bloque.setVisible(false);

        BotonSiguienteTurno botonSiguienteTurno = new BotonSiguienteTurno(juego,this);

        StackPane acciones = new StackPane();
        acciones.getChildren().addAll(bloqueDeAccion.values());

        padre.setTop(estados);
        padre.setCenter(this.setearMapa());
        padre.setRight(acciones);
        padre.setBottom(botonSiguienteTurno);

        this.juego.agregarObserverARondaActual(this);
    }

    private ImageView setearMapa(){
        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;
    }


    @Override
    public void change() {

        Ronda ronda = juego.dameRonda();
        Accion fase = ronda.dameFase();

        for (BloqueAccion bloque : bloqueDeAccion.values())
            bloque.setVisible(false);

        BloqueAccion bloque = bloqueDeAccion.get(fase.ID());

        if (bloque != null) {
            bloque.actualizar();
            bloque.setVisible(true);
        }

        this.estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo());
        Label estadoTitulo = (Label)(this.estados.getChildren().get(0));
        estadoTitulo.setText("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));

    }
}
