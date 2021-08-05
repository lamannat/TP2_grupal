package edu.fiuba.algo3.vista.movimiento;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class DropDownPaisElegido extends ComboBox implements Observer {
    private Juego juego;

    public DropDownPaisElegido(Juego juego, DropDownPaisDestino dropDownPaisDestino, DropDownCantidadFichas cantidadFichas, BotonMoverTropas moverTropas) {
        this.juego = juego;

        asignarPaisesDelJugador();

        this.setOnAction(e -> {
            Pais paisElegido = this.juego.getPaisPorNombre((String)this.getValue());
            if (paisElegido == null)
                return;
            moverTropas.setPaisConFichas(paisElegido);

            ObservableList<String> paisesDestino = FXCollections.observableArrayList();
            for (Pais pais : paisElegido.getPaisesAleados())
                paisesDestino.add(pais.toString());

            dropDownPaisDestino.getItems().clear();
            dropDownPaisDestino.getItems().addAll(paisesDestino.sorted());


            ObservableList<String> cantidadAMover = FXCollections.observableArrayList();

            for (Integer i = 1; i <= paisElegido.fichasParaMover() ; i++)
                cantidadAMover.add(i.toString());

            cantidadFichas.getItems().clear();
            cantidadFichas.getItems().addAll(cantidadAMover);
        });
    }

    private void asignarPaisesDelJugador() {
        ObservableList<String> paisesDelJugador = FXCollections.observableArrayList();
        for (Pais pais: juego.jugadorActual().getPaisDeReagrupamiento())
            paisesDelJugador.add(pais.toString());

        this.getItems().clear();
        this.getItems().addAll(paisesDelJugador.sorted());
    }

    @Override
    public void change() {
        asignarPaisesDelJugador();
    }
}
