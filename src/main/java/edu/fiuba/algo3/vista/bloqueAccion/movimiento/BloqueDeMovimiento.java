package edu.fiuba.algo3.vista.bloqueAccion.movimiento;

import edu.fiuba.algo3.controlador.accionesHandlers.movimiento.DropDownCantidadFichasMovimientoEventHandler;
import edu.fiuba.algo3.controlador.accionesHandlers.movimiento.DropDownPaisDestinoMovimientoEventHandler;
import edu.fiuba.algo3.controlador.accionesHandlers.movimiento.DropDownPaisElegidoMovimientoEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.vista.bloqueAccion.BloqueAccion;
import edu.fiuba.algo3.vista.bloqueAccion.DropDownAccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class BloqueDeMovimiento extends BloqueAccion {

    private Juego juego;

    public BloqueDeMovimiento (Juego juego) {
        this.juego = juego;
        actualizar();
        this.setId("bloqueDeMovimiento");
    }

    @Override
    public void change() {
        actualizar();
    }

    public void actualizar() {
        BotonMoverTropas moverTropas = new BotonMoverTropas(juego);
        moverTropas.setText("Mover tropas");

        DropDownAccion paisDestino = new DropDownAccion("Destino");
        paisDestino.setActualizacion(() -> {
            paisDestino.getItems().clear();
        });
        paisDestino.enAccion(new DropDownPaisDestinoMovimientoEventHandler(juego, paisDestino, moverTropas));

        DropDownAccion cantidadFichas = new DropDownAccion("N° Fichas");
        cantidadFichas.setActualizacion(() -> {
            cantidadFichas.getItems().clear();
        });
        cantidadFichas.enAccion(new DropDownCantidadFichasMovimientoEventHandler(cantidadFichas, moverTropas));

        DropDownAccion paisElegido = new DropDownAccion("Origen");
        paisElegido.setActualizacion(() -> {
            ObservableList<String> paisesDelJugador = FXCollections.observableArrayList();
            for (Pais pais: juego.jugadorActual().getPaisDeReagrupamiento())
                paisesDelJugador.add(pais.toString());

            paisElegido.getItems().clear();
            paisElegido.getItems().addAll(paisesDelJugador.sorted());
        });
        paisElegido.enAccion(new DropDownPaisElegidoMovimientoEventHandler(juego, paisElegido, cantidadFichas, paisDestino, moverTropas));

        Label labelDestino = new Label("Elegi pais a donde\nmover fichas");
        Label labelFichas = new Label("Elegi n° de Fichas");
        Label labelElegido = new Label("Elegi pais a cual\nsacarle fichas");

        juego.jugadorActual().addObserver(cantidadFichas);
        juego.jugadorActual().addObserver(paisElegido);
        juego.jugadorActual().addObserver(paisDestino);

        this.getChildren().clear();
        this.getChildren().addAll(labelElegido,paisElegido, labelFichas,cantidadFichas, labelDestino,paisDestino, moverTropas);
    }
}
