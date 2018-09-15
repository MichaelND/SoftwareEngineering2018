package edu.nd.se2018.homework.hwk3;

import java.awt.Point;
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
	int dimensions = 25;
	int borderSize = 600;
	int scale = borderSize / dimensions;
	
	Point shipPosition;
	Point piratePosition;
	Image pirateImage;
	ImageView pirateImageView;
	Random rand = new Random();

	// Constructor
	public Pirate(){
		piratePosition = new Point(rand.nextInt(borderSize), rand.nextInt(borderSize));
		pirateImage = new Image("file:///Users/MichaelWang/Documents/GitHub/SoftwareEngineering2018/src/images/PirateShip.png",scale,scale,true,true);	
		pirateImageView = new ImageView(pirateImage);
		System.out.println("ok");
	}
	
	public ImageView getImageView(){
		return pirateImageView;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	// Moves the pirate
	// Because the pirate is an observer of the ship -- it's "shipPosition" variable is kept updated.
	// So whenever we tell the pirate to move we can assume that it knows the current position of the ship.
//	public void movePirate() {
//		if (piratePosition.x - shipPosition.x < 0)
//			piratePosition.x++;
//		else
//			piratePosition.x--;
//		
//		if (piratePosition.y - shipPosition.y < 0)
//			piratePosition.y++;
//		else
//			piratePosition.y--;
//		
//		pirateImageView.setX(piratePosition.x);
//		pirateImageView.setY(piratePosition.y);	
//		
//		// Retained for debugging.
//		// System.out.println("Cat: " + catPosition.x + " " + catPosition.y);
//	}
//
//	// If the pirate is registered as an observer of the ship it will get the position.
//	// Note the downcasting that occurs + the necessity of checking whether s is an instanceof Ship!
//	@Override
//	public void update(Observable s, Object arg1) {
//		if (s instanceof Ship){
//			shipPosition = ((Ship)s).getShipLocation();
//			movePirate();			
//		}		
//		
//	}
}
