package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPaisEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class VistaBotonPais extends Button implements Observer {

    private final Pais paisAsociado;

    public VistaBotonPais(Juego juego, String nombrePais, VistaJuego vistaJuego){
        super();
        this.getStyleClass().add("botonPais");
        this.paisAsociado = juego.getPaisPorNombre(nombrePais);
        if (paisAsociado == null)
            return;

        this.setOnAction(new BotonPaisEventHandler(vistaJuego, juego.getPaisPorNombre(nombrePais)));

        juego.addObserverAPaises(this);
        Tooltip unTooltip = new Tooltip(paisAsociado.toString());
        unTooltip.setShowDelay(Duration.millis(100));
        this.setTooltip(unTooltip);
        this.actualizar();
    }

    private void actualizar() {
        this.setText(String.valueOf(paisAsociado.cantidadFichas()));
        this.setStyle("-fx-background-color: " + paisAsociado.getColor().getCodigo()
                    + ";" + "-fx-font-weight: bold"+ ";" + "-fx-font-size: 11 ; -fx-text-fill: "
                    + paisAsociado.getColor().getColorText());
    }

    @Override
    public void change() {
        this.actualizar();
    }
}
