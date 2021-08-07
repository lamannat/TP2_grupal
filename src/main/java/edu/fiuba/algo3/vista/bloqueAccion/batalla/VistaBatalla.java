package edu.fiuba.algo3.vista.bloqueAccion.batalla;

import edu.fiuba.algo3.controlador.accionesHandlers.batalla.DropDownBatallaEventHandler;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VistaBatalla implements Observer {
    private final Pais paisAtacante;
    private final Pais paisDefensor;
    private final BotonBatalla botonBatalla;
    private final DropDownAccion dropDown;
    private final Stage nuevaVentana;


    public VistaBatalla(Pais paisAtacante, Pais paisDefensor){
        this.paisAtacante = paisAtacante;
        this.paisDefensor = paisDefensor;

        this.nuevaVentana = new Stage();
        nuevaVentana.initModality(Modality.APPLICATION_MODAL);
        nuevaVentana.initStyle(StageStyle.UNDECORATED);

        this.botonBatalla = new BotonBatalla(paisDefensor,paisAtacante,nuevaVentana);

        this.dropDown = new DropDownAccion("N° Fichas");
        this.dropDown.enAccion(new DropDownBatallaEventHandler(dropDown, botonBatalla));

        ObservableList<String> cantidadAMover = FXCollections.observableArrayList();

        for (Integer i = 1; i <= paisAtacante.fichasDespuesDeConquista() ; i++)
            cantidadAMover.add(i.toString());

        dropDown.getItems().clear();
        dropDown.getItems().addAll(cantidadAMover);

    }

    @Override
    public void change() {

        if(!paisDefensor.fueConquistado())
            return;

        VBox layout = new VBox();
        layout.getChildren().clear();
        Label labelConquista = new Label(paisAtacante.toString() + " conquisto a " + paisDefensor.toString());
        labelConquista.setTextFill(Color.WHITE);

        Label elegirTropas = new Label("Elegi cuantas tropas pasar");
        elegirTropas.setTextFill(Color.WHITE);

        Scene nuevaEscena = new Scene(layout, 450,300);
        layout.setStyle("-fx-background-color: #272727;" +
                        "-fx-border-color: #ffcc3d;\n" +
                        "-fx-border-style: solid;\n" +
                        "-fx-border-width: 5;");
        layout.getStyleClass().add("bloqueDeAccion");
        nuevaEscena.getStylesheets().addAll("estiloSidePanel.css");

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(labelConquista,elegirTropas,dropDown,botonBatalla);

        nuevaVentana.setScene(nuevaEscena);
        nuevaVentana.show();
    }
}
