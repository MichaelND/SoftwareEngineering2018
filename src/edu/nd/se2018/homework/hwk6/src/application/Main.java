package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import src.edu.nd.se2018.homework.hwk6.src.levels.level1;
import src.edu.nd.se2018.homework.hwk6.src.levels.level2;
import src.edu.nd.se2018.homework.hwk6.src.levels.levelStrategy;
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
	
	int chipCount = 10; 
	int dimensions = 25; 
	int borderSize = 600;
	int scale = borderSize / dimensions;
	
	@Override
	public void start(Stage Stage1) {
		// Create level 1
		createMap(new level1(), Stage1, 1, 12, 12);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void createMap(levelStrategy level, Stage stage, int lvl, int chipStartx, int chipStarty) {
		root = new BorderPane();
		map = new Map(root.getChildren(), scale, dimensions);
		map.setLevelStrategy(level);
		mapGrid = map.createMap(chipCount, root.getChildren(), scale, dimensions); //Specify number of keys and chips (keys must be less than 7)
		scene = new Scene(root,borderSize,borderSize);
		
		//Create backpack
		backpack = new Backpack(chipCount);
						
		//Create chip
		chip = new Chip(dimensions, borderSize, map.mapGrid, backpack, chipStartx, chipStarty);
		chip.getImageView().setX(chip.getChipLocation().x * scale);
		chip.getImageView().setY(chip.getChipLocation().y * scale);
		root.getChildren().add(chip.chipImageView);

		//Add observers
		chip.addObserver(backpack);
		backpack.addObserver(map);
				
		stage.setTitle("Chip's Challenge Level " + lvl);
		stage.setScene(scene);
		stage.show();
		startGame();		
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
					case ESCAPE:
						Stage sb = (Stage)scene.getWindow();//use any one object
				        sb.close();
					default:
						break;
				}
				chip.getImageView().setX(chip.getChipLocation().x * scale);
				chip.getImageView().setY(chip.getChipLocation().y * scale);
				chip.notifyObservers();
				
				//Used to update tile underneath without removing chip from image
				root.getChildren().remove(chip.getImageView());
				root.getChildren().add(chip.getImageView());
				
				if (backpack.winLevel == true) { // Move to Level 2
					Stage Stage2 = new Stage();
					Stage sb = (Stage)scene.getWindow();//use any one object
					root.getChildren().clear();
					sb.close();
					createMap(new level2(), Stage2, 2, 3, 20);
				}
			}
		});
	}
}
