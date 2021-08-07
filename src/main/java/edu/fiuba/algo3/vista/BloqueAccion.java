package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.scene.layout.VBox;

public abstract class BloqueAccion extends VBox implements Observer {

    public abstract void actualizar();

    @Override
    public void change() {

    }

    public abstract void setDropDown(Pais paisASetear);
}
