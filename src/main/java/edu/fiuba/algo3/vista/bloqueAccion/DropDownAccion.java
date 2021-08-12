package edu.fiuba.algo3.vista.bloqueAccion;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class DropDownAccion extends ComboBox implements Observer {

    ActualizarDropDown actualizarDropDown;

    public DropDownAccion(String prompt) {
        this.setPromptText(prompt);
        this.actualizarDropDown = null;
    }

    public void setActualizacion(ActualizarDropDown actualizarDropDown) {
        this.actualizarDropDown = actualizarDropDown;
        this.actualizarDropDown.actualizar();
    }

    @Override
    public void change() {
        if (actualizarDropDown != null)
            this.actualizarDropDown.actualizar();
    }

    public void setPais(Pais paisASetear) {
        if(this.getItems().contains(paisASetear.toString()))
            setValue(paisASetear.toString());
    }
}
