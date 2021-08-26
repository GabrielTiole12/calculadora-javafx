package minhaCalculadora;

import calculadora.Calculadora;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppMinha extends Application {
	
	double posX = 0;
	double posY = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		String css = getClass().getResource("/minhaCalculadora/Calculadora.css").toExternalForm();
		
		Scene cena = new Scene(new Calculadora(), 232, 322);
		cena.setFill(Color.TRANSPARENT);
		cena.getStylesheets().add(css);
		
		cena.setOnMousePressed(event -> {
			posX = primaryStage.getX() - event.getScreenX();
			posY = primaryStage.getY() - event.getScreenY();
		});

		cena.setOnMouseDragged(e -> {
			primaryStage.setX(e.getScreenX() + posX);
			primaryStage.setY(e.getScreenY() + posY);
		});
		
		primaryStage.setScene(cena);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
