package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene mainMenu = new Scene(root, 800, 500);
		String css = this.getClass().getResource("application.css").toExternalForm();
		mainMenu.getStylesheets().add(css);
		primaryStage.setTitle("Main Menu");
		primaryStage.setScene(mainMenu);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}