package application;


import java.awt.Point;
import java.util.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

	/**
	 * Chip class that defines chip
	 * @author Michael
	 *
	 */

public class Chip extends Observable{
	Point currentLocation;
	int dimensions;
	int borderSize;
	int scale;
	int[][] mapGrid;

	Image chipImage;
	ImageView chipImageView;
		
	public Chip(int d, int size, int[][] grid) {
		mapGrid = grid;
		dimensions = d;
		borderSize = size;
		scale = borderSize / dimensions;
		currentLocation = new Point(12,12);
		chipImage = new Image("images//chip//textures//chipDown.png",scale,scale,true,true);
		chipImageView = new ImageView(chipImage);
	}

	public ImageView getImageView(){
		return chipImageView;
	}
	
	public Point getChipLocation() {
		return currentLocation;
	}
		
	public void goEast() {
		if (currentLocation.x < dimensions - 1) { //check bounds
			if (mapGrid[currentLocation.x + 1][currentLocation.y] == 0) //check island
				currentLocation.x++;
		}
//			setChanged();		// The observable object has moved. Must have line...
	}
	public void goWest() {
		if (currentLocation.x > 0) {
			if (mapGrid[currentLocation.x - 1][currentLocation.y] == 0)
				currentLocation.x--;
		}
//		setChanged();
	}
	public void goNorth() {
		if (currentLocation.y > 0) {
			if (mapGrid[currentLocation.x][currentLocation.y - 1] == 0)
				currentLocation.y--;
		}
//			setChanged();
	}
	public void goSouth() {
		if (currentLocation.y < dimensions - 1) {
			if (mapGrid[currentLocation.x][currentLocation.y + 1] == 0)
				currentLocation.y++;
		}
//			setChanged();
	}
}
