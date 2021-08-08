package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ListenerVentanaDesenfocada;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Popup extends Stage {

    private final Stage ventanaPrincipal;
    private final Pane layout;
    private int v;
    private int v1;
    private double x;
    private double y;

    public Popup(Stage ventanaPrincipal, Pane layout){
        this.ventanaPrincipal = ventanaPrincipal;
        this.layout = layout;
    }
    
    public void setDimensiones(int v, int v1){
        this.v = v;
        this.v1 = v1;
    }

    public void setDistanciaAPrincipal(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void crearPopup(){
        // New window (Stage)
        Scene nuevaEscena = new Scene(layout,v,v1);
        this.setScene(nuevaEscena);

        this.initStyle(StageStyle.UNDECORATED);
        this.setX(x);
        this.setY(y);

        this.focusedProperty().addListener(new ListenerVentanaDesenfocada(this));

        this.show();
    }


}
