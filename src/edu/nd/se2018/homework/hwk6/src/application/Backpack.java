package application;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Backpack class
 * @author Michael
 *
 */

public class Backpack extends Observable implements Observer{
	int totalChips;
	int keys;
	int chipCount;
	boolean canEnter;
	
	Point chipLocation;
	
	public Backpack(int count) {
		chipCount = count;
		totalChips = 0;
		keys = 0;
		canEnter = false;
	}
	public void empty() {
		totalChips = 0;
		keys = 0;
		canEnter = false;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Chip){
			chipLocation = ((Chip)o).getChipLocation();
			updateBackpack((Chip)o, ((Chip)o).mapGrid);		
		}
	}
	private void updateBackpack(Observable o, int[][] grid) {
		int pos = grid[chipLocation.x][chipLocation.y];
		
		if (pos >= 2 && pos <= 6) {
			if (pos >= 2 && pos <= 5) 
				keys += 1;
			else
				totalChips += 1;
			((Chip)o).clearTile(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0);
			setChanged();
			notifyObservers();
		}
		else if (pos == 7) { // Handle win condition
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Level Completed!");
	        alert.setHeaderText("Congrats!");
	        alert.setContentText("Good Job!");
	        alert.showAndWait();
		}
		
		if (totalChips >= 10 && keys >= 1)
			canEnter = true;

		if (pos >= 8 && pos <= 11 && canEnter) {
			((Chip)o).clearTile(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0); // Map observers backpack, resets tile
			setChanged();
			notifyObservers();
		}
	}
}
