package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	BorderPane root;
	Map Map;
	Scene scene;
	Chip chip;
	
	//Changeable factors
//	int islandCount = 10; //default 10
	int dimensions = 25;  //default 25
	int borderSize = 600; //default 600
	
	int scale = borderSize / dimensions;
	
	@Override
	public void start(Stage primaryStage) {
//		//Bounds check
//		if (islandCount > dimensions * dimensions - 1 - pirateCount) {
//			System.out.println("Too many Islands");
//			return;
//		}
//		else if (pirateCount > dimensions * dimensions - 1 - islandCount) {
//			System.out.println("Too many pirates");
//			return;
//		}
		
		//Create map
		root = new BorderPane();
		Map = new Map();
		Map.drawMap(root.getChildren(), scale, dimensions);
		scene = new Scene(root,borderSize,borderSize);
		
		//Create ship
		chip = new Chip(dimensions, borderSize, Map.mapGrid);
		chip.getImageView().setX(chip.getChipLocation().x * scale);
		chip.getImageView().setY(chip.getChipLocation().y * scale);
		root.getChildren().add(chip.chipImageView);
		
//		// Create pirates
//		for(int j = 0; j < pirateCount; j++) {
//			pirate = new Pirate(dimensions, borderSize, oceanMap.oceanGrid);
//			pirate.getImageView().setX(pirate.getPirateLocation().x * scale);
//			pirate.getImageView().setY(pirate.getPirateLocation().y * scale);
//			root.getChildren().add(pirate.pirateImageView);
//			ship.addObserver(pirate);
//		}
		
		primaryStage.setTitle("Chip's Challenge");
		primaryStage.setScene(scene);
		primaryStage.show();
		startGame();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void startGame(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent ke) {
				switch(ke.getCode()){
					case RIGHT:
						chip.goEast();
						break;
					case LEFT:
						chip.goWest();
						break;
					case UP:
						chip.goNorth();
						break;
					case DOWN:
						chip.goSouth();
						break;
					default:
						break;
				}
				chip.getImageView().setX(chip.getChipLocation().x * scale);
				chip.getImageView().setY(chip.getChipLocation().y * scale);
//				chip.notifyObservers();
			}
		});
	}
}
