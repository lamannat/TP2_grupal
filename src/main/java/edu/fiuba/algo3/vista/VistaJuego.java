package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.moduloRonda.Accion;
import edu.fiuba.algo3.modelo.moduloRonda.Ronda;
import edu.fiuba.algo3.vista.ataque.BloqueDeAtaque;
import edu.fiuba.algo3.vista.incorporacion.BloqueDeIncorporacion;
import edu.fiuba.algo3.vista.movimiento.BloqueDeMovimiento;
import edu.fiuba.algo3.vista.solicitar.BloqueSolicitarCarta;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        estados.setPrefHeight(100);
        estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo() + "; -fx-font-size: 30");
        Label estadoTitulo = new Label("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));
        estadoTitulo.setTextFill(Color.BLACK);
        estados.getChildren().add(estadoTitulo);
        estados.setAlignment(Pos.CENTER);

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

        StackPane info = new StackPane();
        info.getChildren().addAll(acciones, botonSiguienteTurno);
        info.setAlignment(acciones, Pos.TOP_CENTER);
        info.setAlignment(botonSiguienteTurno, Pos.BOTTOM_CENTER);

        padre.setTop(estados);
        padre.setCenter(this.setearMapa());
        padre.setRight(info);

        this.juego.agregarObserverARondaActual(this);
    }

    private AnchorPane setearMapa(){
        /*File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;*/

        AnchorPane contenedorMapa = new AnchorPane();
        contenedorMapa.setPrefHeight(540);
        contenedorMapa.setPrefWidth(960);

        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.png");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView();
        iv.setPreserveRatio(false);
        iv.fitWidthProperty().bind(contenedorMapa.widthProperty());
        iv.fitHeightProperty().bind(contenedorMapa.heightProperty());
        iv.setImage(image);
        contenedorMapa.getChildren().add(iv);
        contenedorMapa.setStyle("-fx-background-color: red");

        return contenedorMapa;
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

        this.estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo() + "; -fx-font-size: 30");
        Label estadoTitulo = (Label)(this.estados.getChildren().get(0));
        estadoTitulo.setText("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));

    }
}
