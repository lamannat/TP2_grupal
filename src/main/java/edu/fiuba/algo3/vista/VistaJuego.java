package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.SetUpJuego;
import edu.fiuba.algo3.archivos.LeerArchivo;
import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.moduloRonda.Ronda;
import edu.fiuba.algo3.modelo.moduloRonda.acciones.Accion;
import edu.fiuba.algo3.vista.bloqueAccion.BloqueAccion;
import edu.fiuba.algo3.vista.bloqueAccion.ataque.BloqueDeAtaque;
import edu.fiuba.algo3.vista.bloqueAccion.incorporacion.BloqueDeIncorporacion;
import edu.fiuba.algo3.vista.bloqueAccion.movimiento.BloqueDeMovimiento;
import edu.fiuba.algo3.vista.bloqueAccion.solicitar.BloqueSolicitarCarta;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VistaJuego extends Escena implements Observer{

    private final BorderPane padre;
    private final SetUpJuego setUp;
    private Juego juego;
    private Map<String, BloqueAccion> bloqueDeAccion;
    private BarraDeEstado estados;
    private double ANCHO = 1120.0;
    private double ALTO = 630.0;
    private BotonObjetivo botonObjetivo;
    private Stage ventana;
    private BotonCarta botonCartas;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (BorderPane) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        this.ventana = ventana;
        this.juego = setUp.dameJuego();
        this.juego.addObserver(this);
        juego.agregarObserverARondaActual(this);

        this.padre.setPrefWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setPrefHeight(controladorDeEscena.getResolucionAlto());
        this.padre.setMinWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setMinHeight(controladorDeEscena.getResolucionAlto());
        this.padre.setMaxWidth(controladorDeEscena.getResolucionAncho());
        this.padre.setMaxHeight(controladorDeEscena.getResolucionAlto());

        estados = new BarraDeEstado(juego);

        bloqueDeAccion = new HashMap<>();
        bloqueDeAccion.put("incorporar fichas", new BloqueDeIncorporacion(juego));
        bloqueDeAccion.put("atacar", new BloqueDeAtaque(juego));
        bloqueDeAccion.put("reagrupar", new BloqueDeMovimiento(juego));
        bloqueDeAccion.put("solicitar carta", new BloqueSolicitarCarta(juego));

        for (BloqueAccion bloque : bloqueDeAccion.values())
            bloque.setVisible(false);

        BotonSiguienteTurno botonSiguienteTurno = new BotonSiguienteTurno(juego);
        botonSiguienteTurno.getStyleClass().addAll("botonSiguienteTurno", "hoverOscuro");
        botonSiguienteTurno.setAlignment(Pos.CENTER);

        StackPane acciones = new StackPane();
        acciones.getChildren().addAll(bloqueDeAccion.values());

        StackPane info = new StackPane();
        info.getChildren().addAll(acciones, botonSiguienteTurno);
        info.setAlignment(acciones, Pos.TOP_CENTER);
        info.setAlignment(botonSiguienteTurno, Pos.BOTTOM_CENTER);
        info.setStyle("-fx-padding: 10px 0px 15px 0px");

        AnchorPane mapa = this.setearMapa();

        // boton objetivo
        this.botonObjetivo = new BotonObjetivo(ventana, juego);
        this.botonObjetivo.setLayoutX(20);
        this.botonObjetivo.setLayoutY(ALTO - 80);

        // boton de las cartas
        this.botonCartas = new BotonCarta(ventana, juego);
        this.botonCartas.setLayoutX(105);
        this.botonCartas.setLayoutY(ALTO - 80);

        mapa.getChildren().addAll(this.botonObjetivo, this.botonCartas);

        padre.setTop(estados);
        padre.setLeft(mapa);
        padre.setRight(info);
        padre.setStyle("-fx-background-color: #272727");

        this.juego.agregarObserverARondaActual(this);
    }

    private AnchorPane setearMapa(){
        AnchorPane contenedorMapa = new AnchorPane();
        contenedorMapa.setMaxHeight(ALTO);
        contenedorMapa.setMaxWidth(ANCHO);
        contenedorMapa.setPrefHeight(ALTO);
        contenedorMapa.setPrefWidth(ANCHO);

        Image image = new Image(getClass().getResourceAsStream("/imagenes/mapaTEg.jpg"));
        ImageView iv = new ImageView();
        iv.setPreserveRatio(false);
        iv.fitWidthProperty().set(ANCHO);
        iv.fitHeightProperty().set(ALTO);
        iv.setImage(image);

        contenedorMapa.getChildren().add(setFichas());

        contenedorMapa.getChildren().add(iv);
        contenedorMapa.getChildren().add(setFichas());
        contenedorMapa.setStyle("-fx-background-color: #ffcc3d;" +
                "-fx-border-color: #ffcc3d;\n" +
                "-fx-border-style: solid;\n" +
                "-fx-border-width: 1;");

        return contenedorMapa;
    }

    private AnchorPane setFichas() {

        AnchorPane fichas = new AnchorPane();

        for (List<String> linea : LeerArchivo.leerArchivo(getClass().getResourceAsStream("/archivos/mapa.txt"))) {
            VistaBotonPais boton = new VistaBotonPais(this.juego, linea.get(0), this);
            double x = Integer.parseInt(linea.get(1)), y = Integer.parseInt(linea.get(2));
            x *= ANCHO / 1280.0;
            y *= ALTO / 720.0;
            boton.setLayoutX(x);
            boton.setLayoutY(y);
            fichas.getChildren().add(boton);
        }

        return fichas;
    }

    public void setDropDown(Pais paisASetear){

        Ronda ronda = juego.dameRonda();
        Accion fase = ronda.dameFase();
        BloqueAccion bloque = bloqueDeAccion.get(fase.ID());

        bloque.setDropDown(paisASetear);
    }

    @Override
    public void change() {

        Jugador jugadorGanador = juego.getJugadorGanador();
        if (jugadorGanador != null) {
            BotonSiguienteEscenaEventHandler algo = new BotonSiguienteEscenaEventHandler(this.ventana, this.controladorDeEscena);
            algo.handle(new ActionEvent());
            return;
        }

        Ronda ronda = juego.dameRonda();
        Accion fase = ronda.dameFase();

        for (BloqueAccion bloque : bloqueDeAccion.values())
            bloque.setVisible(false);

        BloqueAccion bloque = bloqueDeAccion.get(fase.ID());

        if (bloque != null) {
            bloque.actualizar();
            bloque.setVisible(true);
        }

        this.estados.actualizar();
    }
}
