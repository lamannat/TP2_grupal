package edu.fiuba.algo3.vista;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VistaJuego {

    public Scene crearJuego(Stage ventana) {
        InputStream stream = null;
        try {
            stream = new FileInputStream("src/main/java/edu/fiuba/algo3/archivos/mapaTEg.png");
        } catch (FileNotFoundException e) {
            System.out.println("Y el archivo?");
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
        Group root = new Group(imageView);
        root.setStyle("-fx-background-color: black");
        Scene escenaJuego = new Scene(root);
        return escenaJuego;
    }

}
