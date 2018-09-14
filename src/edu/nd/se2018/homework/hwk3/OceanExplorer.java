package edu.nd.se2018.homework.hwk3;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class OceanExplorer extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,500,500);
		
		OceanMap oceanMap = new OceanMap();
		oceanMap.drawMap(root.getChildren(), 20);
		
		Ship ship = new Ship();
		Image shipImage = new Image("images\\ship.png",20,20,true,true);
		ImageView shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * 20);
		shipImageView.setY(ship.getShipLocation().y * 20);
		
		root.getChildren().add(shipImageView);
		
		primaryStage.setTitle("My Island");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
