package edu.nd.se2018.homework.hwk3;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class OceanExplorer extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,400,400);
		primaryStage.setTitle("My Island");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
