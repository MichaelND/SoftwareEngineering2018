package edu.nd.se2018.homework.hwk3;

import java.awt.Point;
import java.util.Observable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Ship class that extends the Observable superclass
 * @author Michael
 *
 */

public class Ship extends Observable{
	Point currentLocation;
	int dimensions;
	int borderSize;
	int scale;
	int[][] oceanGrid;

	Image shipImage;
	ImageView shipImageView;
	
	public Ship(int d, int size, int[][] grid) {
		oceanGrid = grid;
		dimensions = d;
		borderSize = size;
		scale = borderSize / dimensions;
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
	
	public void goEast() {
		if (currentLocation.x < dimensions - 1) { //check bounds
			if (oceanGrid[currentLocation.x + 1][currentLocation.y] == 0) //check island
				currentLocation.x++;
		}
		setChanged();		// The observable object has moved. Must have line...
	}
	public void goWest() {
		if (currentLocation.x > 0) {
			if (oceanGrid[currentLocation.x - 1][currentLocation.y] == 0)
				currentLocation.x--;
		}
		setChanged();
	}
	public void goNorth() {
		if (currentLocation.y > 0) {
			if (oceanGrid[currentLocation.x][currentLocation.y - 1] == 0)
				currentLocation.y--;
		}
		setChanged();
	}
	public void goSouth() {
		if (currentLocation.y < dimensions - 1) {
			if (oceanGrid[currentLocation.x][currentLocation.y + 1] == 0)
				currentLocation.y++;
		}
		setChanged();
	}
}
