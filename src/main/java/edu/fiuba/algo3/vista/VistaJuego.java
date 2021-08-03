package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.ataque.BloqueDeAtaque;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

public class VistaJuego extends Escena {

    private final BorderPane padre;
    private final SetUpJuego setUp;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (BorderPane) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        Juego juego = setUp.dameJuego();

        HBox estados = new HBox();
        estados.setStyle("-fx-background-color: #3030b6");
        Label estadoTitulo = new Label("Ataqueeeeeee");
        estados.getChildren().add(estadoTitulo);

        BloqueDeAtaque bloqueDeAtaque = new BloqueDeAtaque(juego);

        padre.setTop(estados);
        padre.setCenter(this.setearMapa());
        padre.setRight(bloqueDeAtaque);


//        padre.setStyle("-fx-background-color: black");
    }

    private ImageView setearMapa(){
        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;
    }
}
