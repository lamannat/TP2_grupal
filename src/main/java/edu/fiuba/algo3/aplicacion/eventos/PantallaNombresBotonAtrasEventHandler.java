package edu.fiuba.algo3.aplicacion.eventos;

import edu.fiuba.algo3.aplicacion.app.App;
import edu.fiuba.algo3.aplicacion.app.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;


public class PantallaNombresBotonAtrasEventHandler implements EventHandler<ActionEvent> {
	private Stage ventana;
	
	public PantallaNombresBotonAtrasEventHandler(Stage ventana) {

		this.ventana = ventana;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		Scene escena = new Scene(new VistaInicio(this.ventana, 1280, 720));
		File estilo = new File ("src/main/java/edu/fiuba/algo3/aplicacion/css/start-screen.css");
		escena.getStylesheets().add(estilo.toURI().toString());
		ventana.setScene(escena);
	}

}