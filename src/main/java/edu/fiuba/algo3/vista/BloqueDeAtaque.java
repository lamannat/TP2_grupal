package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.DropDownDeAtacanteEventHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.util.List;

public class BloqueDeAtaque extends VBox implements Observer {

    private Juego juego;
    private ComboBox paisQueSePuedeAtacar;

    public BloqueDeAtaque(Juego juego) {

        this.juego = juego;

        Jugador jugador = juego.jugadorActual();
        Label titulo = new Label("Ataqueeee " + jugador.getNombre());
        titulo.setStyle("-fx-background-color: white");

        List<Pais> paisesDelJugador = jugador.getPaisesConquitados();
        ObservableList<String> opciones = FXCollections.observableArrayList();
        for (Pais paisDelJugador : paisesDelJugador)
            opciones.add(paisDelJugador.toString());

        ComboBox paisParaAtacar = new ComboBox(opciones);
        paisParaAtacar.setOnAction(new DropDownDeAtacanteEventHandler(juego, paisParaAtacar));

        juego.addObserver(this);
        this.paisQueSePuedeAtacar = new ComboBox();
        this.paisQueSePuedeAtacar.setVisible(false);

        Button botonDeAtaque = new Button("Atacar al wacho");
        botonDeAtaque.setOnAction(e -> {
//            juego.removerObserver(this);
            Pais paisDefensor = juego.getPaisPorNombre((String) paisParaAtacar.getValue());
            Pais paisAtacante = juego.getPaisPorNombre((String) paisParaAtacar.getValue());
            try {
                paisAtacante.paisAtacaAPais(paisDefensor, juego.getBatalla());
            } catch (FichasInsuficientesException | NoEsLimitrofeException | AtaqueAPaisAliadoException error) {
                // oh no, anyways
                System.out.println("Hola");
            }
        });

        this.getChildren().addAll(titulo, paisParaAtacar, this.paisQueSePuedeAtacar, botonDeAtaque);
    }

    @Override
    public void change() {
        Pais paisAtacante = juego.getPaisActual();
        List<Pais> listaAtacables = paisAtacante.getPaisesParaAtacar();
        ObservableList<String> opciones = FXCollections.observableArrayList();
        for (Pais paisDelJugador : listaAtacables)
            opciones.add(paisDelJugador.toString());
        this.paisQueSePuedeAtacar.setVisible(true);
        this.paisQueSePuedeAtacar.getItems().clear();
        this.paisQueSePuedeAtacar.getItems().addAll(opciones);
    }
}
