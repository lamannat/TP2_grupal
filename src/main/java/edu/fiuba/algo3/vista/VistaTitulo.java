package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEscenaEventHandler;
import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaTitulo extends Escena {

    private final VBox padre;

    public VistaTitulo(Parent padre, ControladorDeEscena controladorDeEscena, Juego juego) {
        super(padre, controladorDeEscena, juego);
        this.padre = (VBox) padre;
    }

    @Override
    public void mostrar(Stage ventana) {
        this.padre.getChildren().clear();

        Button botonJugar;
        Scene primera;

        // ALTEGO
        Label altego = new Label("A.L.T.E.G.O");
        altego.setScaleX(20);
        altego.setScaleY(20);
        altego.setTextFill(Color.YELLOW);
        Font font = new Font(10);
        altego.setFont(font);

        // BOTON JUGAR
        botonJugar = new Button("JUGAR");
        botonJugar.setStyle("-fx-background-color: black");
        botonJugar.setTextFill(Color.WHITE);
        botonJugar.setScaleX(5);
        botonJugar.setScaleY(5);
        botonJugar.setOnAction(new BotonSiguienteEscenaEventHandler(ventana, this.controladorDeEscena));
        // LAYOUT INICIAL

        padre.getChildren().addAll(altego, botonJugar);
        padre.setAlignment(Pos.CENTER);
        padre.setStyle("-fx-background-color: #272727");
    }

//    public Scene crearTitulo(Stage ventana){
//        Button botonJugar;
//        Scene primera;
//
//        // ALTEGO
//        Label altego = new Label("A.L.T.E.G.O");
//        altego.setScaleX(20);
//        altego.setScaleY(20);
//        altego.setTextFill(Color.YELLOW);
//        Font font = new Font(10);
//        altego.setFont(font);
//
//        // BOTON JUGAR
//        botonJugar = new Button("JUGAR");
//        botonJugar.setStyle("-fx-background-color: black");
//        botonJugar.setTextFill(Color.WHITE);
//        botonJugar.setScaleX(5);
//        botonJugar.setScaleY(5);
//        botonJugar.setOnAction(new BotonSiguienteEscena(ventana));
//        // LAYOUT INICIAL
//        VBox layout1 = new VBox(250);
//        layout1.getChildren().addAll(altego, botonJugar);
//        layout1.setAlignment(Pos.CENTER);
//        layout1.setStyle("-fx-background-color: #272727");
//        primera = new Scene(layout1, 500, 100);
//
//        return primera;
//    }


}
