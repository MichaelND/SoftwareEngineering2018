package edu.nd.se2018.homework.hwk3;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class OceanExplorer extends Application {
	int dimensions = 25;
	int borderSize = 600;
	int islandCount = 10;
	int scale = borderSize / dimensions;
	
	BorderPane root;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	Image shipImage;
	ImageView shipImageView;
	
	@Override
	public void start(Stage primaryStage) {
		root = new BorderPane();
		oceanMap = new OceanMap();
		oceanMap.drawMap(root.getChildren(), scale, dimensions, islandCount);
		
		scene = new Scene(root,borderSize,borderSize);
		ship = new Ship();
		shipImage = new Image("file:///Users/MichaelWang/Documents/GitHub/SoftwareEngineering2018/src/images/ColumbusShip.png",24,24,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * scale);
		shipImageView.setY(ship.getShipLocation().y * scale);
		
		root.getChildren().add(shipImageView);
		
		primaryStage.setTitle("My Island");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		startSailing();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				} 
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
			}
		});
	}
}
