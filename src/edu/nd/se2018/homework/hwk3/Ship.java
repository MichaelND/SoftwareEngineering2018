package edu.nd.se2018.homework.hwk3;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Ship class that extends the Observable superclass
 * @author Michael
 *
 */

public class Ship extends Observable{
	Point currentLocation;
	int dimensions = 25;
	int borderSize = 600;
	int scale = borderSize / dimensions;

	Image shipImage;
	ImageView shipImageView;


	List<Observer> observers = new LinkedList<Observer>();

	public Ship() {
		currentLocation = new Point(12,12);
		shipImage = new Image("file:///Users/MichaelWang/Documents/GitHub/SoftwareEngineering2018/src/images/ColumbusShip.png",scale,scale,true,true);
		shipImageView = new ImageView(shipImage);
	}
	
	public ImageView getImageView(){
		return shipImageView;
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}
	
	public void goEast(int[][] oceanGrid) {
		if (currentLocation.x < dimensions - 1) { //check bounds
			if (oceanGrid[currentLocation.x + 1][currentLocation.y] == 0) //check island
				currentLocation.x++;
		}
		setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
		notifyObservers();  // Now notify observers.
	}
	public void goWest(int[][] oceanGrid) {
		if (currentLocation.x > 0) {
			if (oceanGrid[currentLocation.x - 1][currentLocation.y] == 0)
				currentLocation.x--;
		}
		setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
		notifyObservers();  // Now notify observers.
	}
	public void goNorth(int[][] oceanGrid) {
		if (currentLocation.y > 0) {
			if (oceanGrid[currentLocation.x][currentLocation.y - 1] == 0)
				currentLocation.y--;
		}
		setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
		notifyObservers();  // Now notify observers.
	}
	public void goSouth(int[][] oceanGrid) {
		if (currentLocation.y < dimensions - 1) {
			if (oceanGrid[currentLocation.x][currentLocation.y + 1] == 0)
				currentLocation.y++;
		}
		setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
		notifyObservers();  // Now notify observers.
	}
}
