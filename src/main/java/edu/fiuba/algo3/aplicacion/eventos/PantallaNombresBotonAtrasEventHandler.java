package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import edu.fiuba.algo3.aplicacion.app.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;


public class PantallaNombresBotonAtrasEventHandler implements EventHandler<ActionEvent> {
	private App app;
	public PantallaNombresBotonAtrasEventHandler(App app) {

		this.app = app;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Scene escena = new Scene(new VistaInicio(app));
		File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/start-screen.css");
		escena.getStylesheets().add(estilo.toURI().toString());
		app.setScene(escena);
	}

}