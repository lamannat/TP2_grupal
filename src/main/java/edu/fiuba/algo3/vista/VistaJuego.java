package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaJuego extends Escena implements Observer{

    private final BorderPane padre;
    private final SetUpJuego setUp;
    private Juego juego;
    private Map<String, BloqueAccion> bloqueDeAccion;
    private HBox estados;
    private double ANCHO = 1120.0;
    private double ALTO = 630.0;

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
        this.padre.setMinWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setMinHeight(controladorDeEscena.getResolucionAlto());
        this.padre.setMaxWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setMaxHeight(controladorDeEscena.getResolucionAlto());

        estados = new HBox();
        estados.setPrefSize(1280, 90);
        estados.setMinSize(1280, 90);
        estados.setMaxSize(1280, 90);

        estados.setStyle("-fx-background-color: " + juego.jugadorActual().getColor().getCodigo() + "; -fx-font-size: 30");
        Label estadoTitulo = new Label("Turno Jugador: " + juego.jugadorActual().getNombre());
        estadoTitulo.setTextFill(Color.valueOf(juego.jugadorActual().getColor().getColorText()));
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
        padre.setLeft(this.setearMapa());
        padre.setRight(info);

        padre.setStyle("-fx-background-color: #272727");

        this.juego.agregarObserverARondaActual(this);
    }

    private AnchorPane setearMapa(){
        /*File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;*/

        AnchorPane contenedorMapa = new AnchorPane();
        contenedorMapa.setMaxHeight(ALTO);
        contenedorMapa.setMaxWidth(ANCHO);
        contenedorMapa.setPrefHeight(ALTO);
        contenedorMapa.setPrefWidth(ANCHO);

        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView();
        iv.setPreserveRatio(false);
        iv.fitWidthProperty().set(ANCHO);
        iv.fitHeightProperty().set(ALTO);
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

        for (List<String> linea : LeerArchivo.leerArchivo("mapa.txt")) {
            VistaBotonPais boton = new VistaBotonPais(this.juego, linea.get(0));
            double x = Integer.parseInt(linea.get(1)), y = Integer.parseInt(linea.get(2));
            x *= ANCHO / 1280.0;
            y *= ALTO / 720.0;
            boton.setLayoutX(x);
            boton.setLayoutY(y);
            fichas.getChildren().add(boton);
        }

        return fichas;
    }

    private AnchorPane setFichasGuia(){

        AnchorPane fichasGuia  = new AnchorPane();

        for(int i = 0; i < ALTO; i+=25){
            for(int j = 0; j < ANCHO; j+=50){
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
