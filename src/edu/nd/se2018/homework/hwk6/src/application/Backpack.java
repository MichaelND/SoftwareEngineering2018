package application;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk3.Ship;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Backpack class
 * @author Michael
 *
 */

public class Backpack implements Observer{
	int totalChips;
	int redKeys;
	int blueKeys;
	int greenKeys;
	int yellowKeys;
	int chipCount;
	
	Point chipLocation;
	
	public Backpack(int count) {
		chipCount = count;
		totalChips = chipCount;
		redKeys = 0;
		blueKeys = 0;
		greenKeys = 0;
		yellowKeys = 0;
	}
	public void empty() {
		totalChips = chipCount;
		redKeys = 0;
		blueKeys = 0;
		greenKeys = 0;
		yellowKeys = 0;
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Chip){
			chipLocation = ((Chip)o).getChipLocation();
			updateBackpack((Chip)o, ((Chip)o).mapGrid);		
		}
		
	}
	private void updateBackpack(Observable o, int[][] grid) {
		if (grid[chipLocation.x][chipLocation.y] == 2) {
			blueKeys += 1;
		}
		else if (grid[chipLocation.x][chipLocation.y] == 3) {
			greenKeys += 1;
		}
		else if (grid[chipLocation.x][chipLocation.y] == 4) {
			yellowKeys += 1;
		}
		else if (grid[chipLocation.x][chipLocation.y] == 5) {
			redKeys += 1;
		}
		else if (grid[chipLocation.x][chipLocation.y] == 8) {
			if (blueKeys > 0 && totalChips == 0) {
				grid[chipLocation.x][chipLocation.y] = 0;
				//add code to update map to basic tile
			}
			else 
				((Chip)o).setOldLocation();
		}
		else if (grid[chipLocation.x][chipLocation.y] == 9) {
			if (greenKeys > 0 && totalChips == 0) {
				grid[chipLocation.x][chipLocation.y] = 0;
				//add code to update map to basic tile
			}
			else 
				((Chip)o).setOldLocation();
		}
		else if (grid[chipLocation.x][chipLocation.y] == 10) {
			if (yellowKeys > 0 && totalChips == 0) {
				grid[chipLocation.x][chipLocation.y] = 0;
				//add code to update map to basic tile
			}
			else 
				((Chip)o).setOldLocation();
		}
		else if (grid[chipLocation.x][chipLocation.y] == 11) {
			if (redKeys > 0 && totalChips == 0) {
				grid[chipLocation.x][chipLocation.y] = 0;
				//add code to update map to basic tile
			}
			else 
				((Chip)o).setOldLocation();
		}
		else if (grid[chipLocation.x][chipLocation.y] == 6) {
			grid[chipLocation.x][chipLocation.y] = 0;
			totalChips -= 1;
		}
		else if (grid[chipLocation.x][chipLocation.y] == 7) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Level Completed!");
	        alert.setHeaderText("Congrats!");
	        alert.setContentText("Good Job!");
	        alert.showAndWait();
		}
	}
}
