package edu.fiuba.algo3.vista.bloqueAccion.ataque;

import edu.fiuba.algo3.controlador.accionesHandlers.ataque.DropDownPaisDefensorEventHandler;
import edu.fiuba.algo3.controlador.accionesHandlers.ataque.DropDownPaisElegidoEventHandler;
import edu.fiuba.algo3.modelo.Batalla;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.BloqueAccion;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class BloqueDeAtaque extends BloqueAccion {

    private final Juego juego;
    private DropDownAccion dropDownAtacantes;
    private DropDownAccion dropDownDefensores;

    public BloqueDeAtaque(Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueDeAtaque");
    }

    @Override
    public void change() {
        actualizar();
    }

    @Override
    public void setDropDown(Pais paisASetear) {

        dropDownAtacantes.setPais(paisASetear);
        dropDownDefensores.setPais(paisASetear);
    }

    public void actualizar() {
        BotonAtacar botonAtacar = new BotonAtacar(juego);

        DropDownAccion paisDefensor = new DropDownAccion("Defensor");
        paisDefensor.setActualizacion(() -> paisDefensor.getItems().clear());
        paisDefensor.setOnAction(new DropDownPaisDefensorEventHandler(juego, paisDefensor, botonAtacar));

        dropDownDefensores = paisDefensor;

        DropDownAccion paisParaAtacar = new DropDownAccion("Atacante");
        paisParaAtacar.setActualizacion(() -> {
            ObservableList<String> opciones = FXCollections.observableArrayList();
            for (Pais pais: juego.jugadorActual().getPaisAtacantes())
                opciones.add(pais.toString());

            paisParaAtacar.getItems().clear();
            paisParaAtacar.getItems().addAll(opciones.sorted());
        });
        paisParaAtacar.setOnAction(new DropDownPaisElegidoEventHandler(juego, paisParaAtacar, paisDefensor, botonAtacar));

        dropDownAtacantes = paisParaAtacar;

        Batalla batalla = juego.getBatalla();
        batalla.addObserver(paisParaAtacar);
        batalla.addObserver(paisDefensor);
        juego.addObserverAPaises(paisParaAtacar);
        juego.addObserverAPaises(paisDefensor);

        Label labelPaisAtacar = new Label("Elija pais\ncon cual atacar");
        Label labelPaisDefensor = new Label("Elija pais\na cual atacar");

        this.getChildren().clear();
        this.getChildren().addAll(labelPaisAtacar, paisParaAtacar, labelPaisDefensor, paisDefensor, botonAtacar);
    }
}
