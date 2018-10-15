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
		int pos = grid[chipLocation.x][chipLocation.y];
		
		if (pos == 2) {
			blueKeys += 1;
		}
		else if (pos == 3) {
			greenKeys += 1;
		}
		else if (pos == 4) {
			yellowKeys += 1;
		}
		else if (pos == 5) {
			redKeys += 1;
		}
		else if (pos == 6) {
			((Chip)o).itemPickUp(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0);
			totalChips -= 1;
			System.out.println("pick up chip");
			setChanged();
			notifyObservers();
		}
		else if (pos == 7) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Level Completed!");
	        alert.setHeaderText("Congrats!");
	        alert.setContentText("Good Job!");
	        alert.showAndWait();
		}
		else if (pos == 8) {
			if (blueKeys > 0 && totalChips == 0)
				((Chip)o).itemPickUp(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0);
			else
				((Chip)o).setOldLocation();
			setChanged();
			notifyObservers();
		}
		else if (pos == 9) {
			if (greenKeys > 0 && totalChips == 0)
				((Chip)o).itemPickUp(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0);
			else {
				((Chip)o).setOldLocation();
			}
			setChanged();
			notifyObservers();
		}
		else if (pos == 10) {
			if (yellowKeys > 0 && totalChips == 0) {
				((Chip)o).itemPickUp(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0);
			}
			else {
				((Chip)o).setOldLocation();
			}
			setChanged();
			notifyObservers();
		}
		else if (pos == 11) {
			if (redKeys > 0 && totalChips == 0) {
				((Chip)o).itemPickUp(((Chip)o).getChipLocation().x,((Chip)o).getChipLocation().y, 0);
			}
			else {
				((Chip)o).setOldLocation();
			}
			setChanged();
			notifyObservers();
		}
	}
}
