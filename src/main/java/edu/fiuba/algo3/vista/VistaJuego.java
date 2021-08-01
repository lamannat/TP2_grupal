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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VistaJuego extends Escena {

    private final VBox padre;

    public VistaJuego(Parent padre, ControladorDeEscena controladorDeEscena, Juego juego) {
        super(padre, controladorDeEscena, juego);
        this.padre = (VBox) padre;
    }

    public void mostrar(Stage ventana) {
        InputStream stream = null;
        try {
            stream = new FileInputStream("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.jpg");
        } catch (FileNotFoundException e) {
            System.out.println("Y el archivo? capo");
            e.printStackTrace();
        }
        assert stream != null;
        Image image = new Image(stream);
        //Creating the image view
        ImageView imageView = new ImageView();
        //Setting image to the image view
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitWidth(850);
        imageView.setPreserveRatio(true);
        //Setting the Scene object
//        HBox root = new HBox(imageView);
        padre.getChildren().add(imageView);
        padre.setStyle("-fx-background-color: black");
    }

}
