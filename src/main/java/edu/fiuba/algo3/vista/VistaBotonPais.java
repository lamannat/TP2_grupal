package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import edu.fiuba.algo3.modelo.color.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class VistaBotonPais extends Button implements Observer {

    private Pais paisAsociado;

    public VistaBotonPais(Juego juego, String nombrePais){
        super();
        this.paisAsociado = juego.getPaisPorNombre(nombrePais);
        if (paisAsociado == null)
            return;

        juego.addObserverAPaises(this);
        this.setTooltip(new Tooltip(paisAsociado.toString()));
        this.setText(String.valueOf(paisAsociado.cantidadFichas()));
        this.setStyle("-fx-background-color: " + paisAsociado.getColor().getCodigo() + ";" + "-fx-font-weight: bold"+ ";" + "-fx-font-size: 14");
    }

    @Override
    public void change() {
        this.setText(String.valueOf(paisAsociado.cantidadFichas()));
        this.setStyle("-fx-background-color: " + paisAsociado.getColor().getCodigo() + ";" + "-fx-font-weight: bold"+ ";" + "-fx-font-size: 14");
    }
}
