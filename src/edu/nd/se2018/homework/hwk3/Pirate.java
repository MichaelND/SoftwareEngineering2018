package edu.nd.se2018.homework.hwk3;

import java.awt.Point;
import java.lang.Math;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Pirate that implements the Observer
 * @author Michael
 *
 */

public class Pirate implements Observer{
	int dimensions;
	int borderSize;
	int scale;
	int[][] oceanGrid;
	
	Point shipLocation;
	Point pirateLocation;
	Image pirateImage;
	ImageView pirateImageView;
	Random rand = new Random();

	public Pirate(int d, int size, int[][] grid) {
		oceanGrid = grid;
		dimensions = d;
		borderSize = size;
		scale = borderSize / dimensions;
		
		int randx = rand.nextInt(dimensions);
		int randy = rand.nextInt(dimensions);
		while (oceanGrid[randx][randy] == 1 || oceanGrid[randx][randy] == 2 || (randx == 12 && randy == 12)) { //find island or pirate not on map
			randx = rand.nextInt(dimensions);
			randy = rand.nextInt(dimensions);
		}
		oceanGrid[randx][randy] = 2;
		pirateLocation = new Point(randx, randy);
		pirateImage = new Image("images//PirateShip.png",scale,scale,true,true);
//		pirateImage = new Image("file:///Users/MichaelWang/Documents/GitHub/SoftwareEngineering2018/src/images/PirateShip.png",scale,scale,true,true);	
		pirateImageView = new ImageView(pirateImage);
		
	}
	
	public ImageView getImageView(){
		return pirateImageView;
	}
	
	public Point getPirateLocation() {
		return pirateLocation;
	}
	
	public void movePirate() {
		//If pirate's x distance is greater than or equal to y distance, move left or right, otherwise move up or down
		//Only move if there is no island blocking the way
		
		if (Math.abs(pirateLocation.x - shipLocation.x) >= Math.abs(pirateLocation.y - shipLocation.y)) {
			if (pirateLocation.x - shipLocation.x < 0) {
				if (oceanGrid[pirateLocation.x + 1][pirateLocation.y] == 0)
					pirateLocation.x++;
			}
			else {
				if (oceanGrid[pirateLocation.x - 1][pirateLocation.y] == 0)
					pirateLocation.x--;
			}
		}
		else {
			if (pirateLocation.y - shipLocation.y < 0) {
				if (oceanGrid[pirateLocation.x][pirateLocation.y + 1] == 0)
					pirateLocation.y++;
			}
			else {
				if (oceanGrid[pirateLocation.x][pirateLocation.y - 1] == 0)
					pirateLocation.y--;
			}
		}
		pirateImageView.setX(pirateLocation.x * scale);
		pirateImageView.setY(pirateLocation.y * scale);	
		
		if (pirateLocation.x == shipLocation.x && pirateLocation.y == shipLocation.y) { 
			System.out.println("Pirate has captured ship!");
			System.out.println("Time to close the application and try again :)");
		}
	}
	
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Ship){
			shipLocation = ((Ship)s).getShipLocation();
			movePirate();			
		}
	}
}
