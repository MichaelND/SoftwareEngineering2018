package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import src.edu.nd.se2018.homework.hwk6.src.levels.level1;
import src.edu.nd.se2018.homework.hwk6.src.levels.level2;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 * Main class that starts the program
 * @author Michael
 *
 */


public class Main extends Application {
	BorderPane root;
	Map map;
	Scene scene;
	Chip chip;
	Backpack backpack;
	int[][] mapGrid;
	
	int keyCount = 1;
	int chipCount = 10; 
	int dimensions = 25; 
	int borderSize = 600;
	int scale = borderSize / dimensions;
	
	@Override
	public void start(Stage primaryStage) {
		//Bounds check
		if (keyCount > 1) {
			Alert error = new Alert(AlertType.ERROR);
			error.setContentText("keyCount must be 1!");
			error.showAndWait();
		}
		
		//Create map
		root = new BorderPane();
		map = new Map();
		map.drawMap(root.getChildren(), scale, dimensions);
		map.setLevelStrategy(new level1());
		mapGrid = map.createMap(keyCount, chipCount, root.getChildren(), scale, dimensions); //Specify number of keys and chips (keys must be less than 7)
		scene = new Scene(root,borderSize,borderSize);
		
		//Create backpack
		backpack = new Backpack(chipCount);
				
		//Create chip
		chip = new Chip(dimensions, borderSize, map.mapGrid, backpack);
		chip.getImageView().setX(chip.getChipLocation().x * scale);
		chip.getImageView().setY(chip.getChipLocation().y * scale);
		root.getChildren().add(chip.chipImageView);
		
		//Add observers
		chip.addObserver(backpack);
		backpack.addObserver(map);
		
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
						chip.setImageView("East");
						break;
					case LEFT:
						chip.goWest();
						chip.setImageView("West");
						break;
					case UP:
						chip.goNorth();
						chip.setImageView("North");
						break;
					case DOWN:
						chip.goSouth();
						chip.setImageView("South");
						break;
					default:
						break;
				}
				chip.getImageView().setX(chip.getChipLocation().x * scale);
				chip.getImageView().setY(chip.getChipLocation().y * scale);
				chip.notifyObservers();
				
				//Used to update tile underneath without removing chip from image
				root.getChildren().remove(chip.getImageView());
				root.getChildren().add(chip.getImageView());
			}
		});
	}
}
