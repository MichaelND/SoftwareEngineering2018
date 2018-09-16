package edu.nd.se2018.homework.hwk3;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

import edu.nd.se2018.homework.hwk3.OceanMap;

/**
 * OceanExplorer Application 
 * @author Michael
 *
 */

public class OceanExplorer extends Application {
	BorderPane root;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	Pirate pirate;
	
	//Changeable factors
	int islandCount = 10; //default 10
	int pirateCount = 2;  //default 2
	int dimensions = 25;  //default 25
	int borderSize = 600; //default 600
	
	int scale = borderSize / dimensions;
	
	@Override
	public void start(Stage primaryStage) {
		//Bounds check
		if (islandCount > dimensions * dimensions - 1 - pirateCount) {
			System.out.println("Too many Islands");
			return;
		}
		else if (pirateCount > dimensions * dimensions - 1 - islandCount) {
			System.out.println("Too many pirates");
			return;
		}
		
		//Create map
		root = new BorderPane();
		oceanMap = new OceanMap();
		oceanMap.drawMap(root.getChildren(), scale, dimensions, islandCount);
		scene = new Scene(root,borderSize,borderSize);
		
		//Create ship
		ship = new Ship(dimensions, borderSize, oceanMap.oceanGrid);
		ship.getImageView().setX(ship.getShipLocation().x * scale);
		ship.getImageView().setY(ship.getShipLocation().y * scale);
		root.getChildren().add(ship.shipImageView);
		
		// Create pirates
		for(int j = 0; j < pirateCount; j++) {
			pirate = new Pirate(dimensions, borderSize, oceanMap.oceanGrid);
			pirate.getImageView().setX(pirate.getPirateLocation().x * scale);
			pirate.getImageView().setY(pirate.getPirateLocation().y * scale);
			root.getChildren().add(pirate.pirateImageView);
			ship.addObserver(pirate);
		}
		
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
				ship.getImageView().setX(ship.getShipLocation().x * scale);
				ship.getImageView().setY(ship.getShipLocation().y * scale);
				ship.notifyObservers();
			}
		});
	}
}
