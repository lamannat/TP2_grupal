package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Observer;
import javafx.scene.control.Button;

public class BotonSiguienteTurno extends Button {

    public BotonSiguienteTurno(Juego juego){
        this.setText("Jugar");
        this.setOnAction(e->{
            juego.avanzar();
            this.setText("Siguiente");
        });
    }
}
