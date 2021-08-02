package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorDeEscena;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.moduloRonda.Turno;
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
import java.util.List;

public class VistaJuego extends Escena {

    private final VBox padre;
    private final SetUpJuego setUp;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena, SetUpJuego setUp) {
        super(padre, controladorDeEscena);
        this.padre = (VBox) padre;
        this.setUp = setUp;
    }

    public void mostrar(Stage ventana) {
        Juego juego = setUp.dameJuego();

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
