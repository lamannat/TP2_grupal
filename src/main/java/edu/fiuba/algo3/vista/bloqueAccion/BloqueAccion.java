package edu.fiuba.algo3.vista.bloqueAccion;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.layout.VBox;

public abstract class BloqueAccion extends VBox implements Observer {

    public BloqueAccion() {
        this.getStyleClass().add("bloqueDeAccion");
    }

    public abstract void actualizar();

    @Override
    public void change() {

    }

    public abstract void setDropDown(Pais paisASetear);
}
