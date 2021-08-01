package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VistaJuego extends Escena {

    private final VBox padre;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
    }

    public void mostrar(Stage ventana) {
        //this.juego.asignarPaises();

        HBox estados = new HBox();

        VBox mapaObjetivos = new VBox();
        mapaObjetivos.getChildren().add(this.setearMapa());

        HBox principal = new HBox();

        principal.getChildren().add(mapaObjetivos); //agrger info 1 y 2

        padre.getChildren().addAll(estados,principal);

        padre.setStyle("-fx-background-color: black");
    }

    private ImageView setearMapa(){
        File file = new File("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        return iv;
    }
}
