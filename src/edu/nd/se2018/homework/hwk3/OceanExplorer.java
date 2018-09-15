package edu.nd.se2018.homework.hwk3;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.util.List;

import edu.nd.se2018.homework.hwk3.OceanMap;

/**
 * OceanExplorer Application 
 * @author Michael
 *
 */

public class OceanExplorer extends Application {
	int dimensions = 25;
	int borderSize = 600;
	int scale = borderSize / dimensions;

	int islandCount = 10;
	
	BorderPane root;
	OceanMap oceanMap;
	Scene scene;
	
	Ship ship;
	List<Pirate> pirates;
	
	int pirateCount = 2;
	
	@Override
	public void start(Stage primaryStage) {
		root = new BorderPane();
		oceanMap = new OceanMap();
		oceanMap.drawMap(root.getChildren(), scale, dimensions, islandCount);
		scene = new Scene(root,borderSize,borderSize);
		
		ship = new Ship();
		ship.getImageView().setX(ship.getShipLocation().x * scale);
		ship.getImageView().setY(ship.getShipLocation().y * scale);
		root.getChildren().add(ship.shipImageView);
		
		System.out.println("ok");
		
		// Create cats
		for(int j = 0; j < pirateCount; j++)
			pirates.add(new Pirate());
		System.out.println("ok");
		
		// Register cats as observers of the mouse.
		// You won't find the addObserver in the mouse class if you look for it, BECAUSE it is in the 
		// superclass OBSERVABLE.
		for(Pirate pirate: pirates) {
			ship.addObserver(pirate);
			root.getChildren().add(pirate.getImageView());
		}
		System.out.println("ok");
		primaryStage.setTitle("My Island");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		startSailing();
		System.out.println("ok");
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
						ship.goEast(oceanMap.oceanGrid);
						break;
					case LEFT:
						ship.goWest(oceanMap.oceanGrid);
						break;
					case UP:
						ship.goNorth(oceanMap.oceanGrid);
						break;
					case DOWN:
						ship.goSouth(oceanMap.oceanGrid);
						break;
					default:
						break;
				} 
				ship.getImageView().setX(ship.getShipLocation().x * scale);
				ship.getImageView().setY(ship.getShipLocation().y * scale);
			}
		});
	}
}
