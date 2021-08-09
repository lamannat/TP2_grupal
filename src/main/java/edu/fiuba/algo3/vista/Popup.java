package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ListenerVentanaDesenfocada;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Popup extends Stage {
    private final Pane layout;
    private int v;
    private int v1;
    private double x = 0;
    private double y = 0;
    private String stylesheet = "";

    public Popup(Pane layout){
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

    public void setStylesheet(String stylesheet){
        this.stylesheet = stylesheet;
    }

    public void crearPopup(){
        // New window (Stage)
        Scene nuevaEscena = new Scene(layout,v,v1);

        this.initStyle(StageStyle.UNDECORATED);

        if (x != 0 && y != 0){
            this.setX(x);
            this.setY(y);
        }

        if (stylesheet != "")
            nuevaEscena.getStylesheets().addAll(stylesheet);

        this.focusedProperty().addListener(new ListenerVentanaDesenfocada(this));

        this.setScene(nuevaEscena);
        this.show();
    }


}
