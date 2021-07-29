package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class PantallaNombresBotonAtrasEventHandler implements EventHandler<ActionEvent> {
	private App app;
	
	public PantallaNombresBotonAtrasEventHandler(App app) {
		this.app = app;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {		
		this.app.start(this.app.getStage());
	}

}