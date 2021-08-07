package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonPaisEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class VistaBotonPais extends Button implements Observer {

    private Pais paisAsociado;

    public VistaBotonPais(Juego juego, String nombrePais, VistaJuego vistaJuego){
        super();
        this.getStylesheets().add("estiloBotonPais.css");
        this.paisAsociado = juego.getPaisPorNombre(nombrePais);
        if (paisAsociado == null)
            return;

        this.setOnAction(new BotonPaisEventHandler(vistaJuego, this.paisAsociado));

        juego.addObserverAPaises(this);
        Tooltip unTooltip = new Tooltip(paisAsociado.toString());
        unTooltip.setShowDelay(Duration.millis(100));
        this.setTooltip(unTooltip);
        this.setText(String.valueOf(paisAsociado.cantidadFichas()));
        this.setTextFill(Color.valueOf(paisAsociado.getColor().getColorText()));
        this.setStyle("-fx-background-color: " + paisAsociado.getColor().getCodigo());

    }

    @Override
    public void change() {
        this.setText(String.valueOf(paisAsociado.cantidadFichas()));
        this.setTextFill(Color.valueOf(paisAsociado.getColor().getColorText()));
        this.setStyle("-fx-background-color: " + paisAsociado.getColor().getCodigo() + ";" + "-fx-font-weight: bold"+ ";" + "-fx-font-size: 12");
    }
}
