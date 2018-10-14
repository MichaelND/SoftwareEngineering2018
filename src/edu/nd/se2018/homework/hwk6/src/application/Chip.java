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
	Point prevLocation;
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
	
	public void setImageView(String direction) {
		if (direction == "East")
			chipImage = new Image("images//chip//textures//chipRight.png",scale,scale,true,true);
		else if (direction == "West")
			chipImage = new Image("images//chip//textures//chipLeft.png",scale,scale,true,true);
		else if (direction == "North")
			chipImage = new Image("images//chip//textures//chipUp.png",scale,scale,true,true);
		else if (direction == "South")
			chipImage = new Image("images//chip//textures//chipDown.png",scale,scale,true,true);
		chipImageView.setImage(chipImage);
	}
	
	public int[][] getMapGrid() {
		return mapGrid;
	}
	
	public void setMapGrid(int x, int y, int val) {
		mapGrid[x][y] = val;
	}
	
	public Point getChipLocation() {
		return currentLocation;
	}
	public void setOldLocation() {
		currentLocation = prevLocation;
	}
		
	public void goEast() {
		if (currentLocation.x < dimensions - 1) { //check bounds
			if (mapGrid[currentLocation.x + 1][currentLocation.y] != 1) { //check wall
				prevLocation = currentLocation;
				currentLocation.x++;
			}
		}
		setChanged();
	}
	public void goWest() {
		if (currentLocation.x > 0) {
			if (mapGrid[currentLocation.x - 1][currentLocation.y] != 1) {
				prevLocation = currentLocation;
				currentLocation.x--;
			}
		}
		setChanged();
	}
	public void goNorth() {
		if (currentLocation.y > 0) {			
			if (mapGrid[currentLocation.x][currentLocation.y - 1] != 1) {
				prevLocation = currentLocation;
				currentLocation.y--;
			}
		}
		setChanged();
	}
	public void goSouth() {
		if (currentLocation.y < dimensions - 1) {
			if (mapGrid[currentLocation.x][currentLocation.y + 1] != 1) {
				prevLocation = currentLocation;
				currentLocation.y++;
			}
		}
		setChanged();

	}
}
