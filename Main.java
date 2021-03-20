package EtchApp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class Main extends Application {
//38 rows and 79 columns is preferred personally

	@Override
	public void start(Stage stage) throws Exception {
		GUICode display = new GUICode(38,80);
		Game game = new Game(38,80);
		stage.setTitle("Etch-A-Sketch");
		stage.setResizable(true);
		Scene scene = new Scene(display,900,900);
		scene.getStylesheets().add(getClass().getResource("Untouched.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("Traversed.css").toExternalForm());
		scene.getStylesheets().add(getClass().getResource("CurrentCursor.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
        display.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.S) {
                    display.keyMove(1, 0, game);
                }
                if (keyEvent.getCode() == KeyCode.W) {
                    display.keyMove(-1, 0, game);
                }
                if (keyEvent.getCode() == KeyCode.A) {
                    display.keyMove(0, -1, game);
                }
                if (keyEvent.getCode() == KeyCode.D) {
                    display.keyMove(0, 1, game);
                }
            }
        });
	}
}