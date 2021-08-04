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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        contenedorMapa.setMaxHeight(720);
        contenedorMapa.setMaxWidth(1280);
        contenedorMapa.setPrefHeight(720);
        contenedorMapa.setPrefWidth(1280);

        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView();
        iv.setPreserveRatio(false);
        iv.fitWidthProperty().set(1280);
        iv.fitHeightProperty().set(720);
        iv.setImage(image);

        contenedorMapa.getChildren().add(setFichas());

        contenedorMapa.getChildren().add(iv);
        contenedorMapa.getChildren().add(setFichas());
        //contenedorMapa.getChildren().add(setFichasGuia());
        contenedorMapa.setStyle("-fx-background-color: #72745d");

        return contenedorMapa;
    }

    private AnchorPane setFichas() {

        AnchorPane fichas = new AnchorPane();

        VistaBotonPais botonArgentina = new VistaBotonPais(this.juego, "Argentina");
        botonArgentina.setLayoutX(400);
        botonArgentina.setLayoutY(550);
        fichas.getChildren().add(botonArgentina);

        VistaBotonPais botonChile = new VistaBotonPais(this.juego, "Chile");
        botonChile.setLayoutX(360);
        botonChile.setLayoutY(550);
        fichas.getChildren().add(botonChile);

        VistaBotonPais botonUruguay = new VistaBotonPais(this.juego, "Uruguay");
        botonUruguay.setLayoutX(460);
        botonUruguay.setLayoutY(525);
        fichas.getChildren().add(botonUruguay);

        VistaBotonPais botonBrasil = new VistaBotonPais(this.juego, "Brasil");
        botonBrasil.setLayoutX(450);
        botonBrasil.setLayoutY(450);
        fichas.getChildren().add(botonBrasil);

        VistaBotonPais botonPeru = new VistaBotonPais(this.juego, "Peru");
        botonPeru.setLayoutX(360);
        botonPeru.setLayoutY(475);
        fichas.getChildren().add(botonPeru);

        VistaBotonPais botonColombia = new VistaBotonPais(this.juego, "Colombia");
        botonColombia.setLayoutX(355);
        botonColombia.setLayoutY(425);
        fichas.getChildren().add(botonColombia);

        return fichas;
    }

    private AnchorPane setFichasGuia(){

        AnchorPane fichasGuia  = new AnchorPane();

        for(int i = 0; i < 1280; i+=25){
            for(int j = 0; j < 720; j+=50){
                Button botonGuia = new Button();
                botonGuia.setTooltip(new Tooltip(String.valueOf(i) + " " + String.valueOf(j)));
                botonGuia.setLayoutX(i);
                botonGuia.setLayoutY(j);
                fichasGuia.getChildren().add(botonGuia);
            }
        }

        return fichasGuia;
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
