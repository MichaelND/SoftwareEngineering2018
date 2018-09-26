package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 * Added methods to get position of other trains
 * @edited by Michael
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private int direction = 0;
	private double eastBoundx = 0;
	private double westBoundx = 0;
	
	public Train(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
	}
	
	public void setMoveDirection(String d) {
		if (d == "East") 
			direction = 3;
		else if (d == "West")
			direction = -2;
		
		if (direction < 0)
			img = new Image("images//Train.PNG",120,trainLength,false,false);
		else if (direction > 0)
			img = new Image("images//TrainReverse.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		currentX+=direction;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (currentX < -200 || currentX > 1400)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}
	
	public void setEastBoundTrainX(double x) {
		eastBoundx = x;
	}
	
	public void setWestBoundTrainX(double x) {
		westBoundx = x;
	}
	
	public double getEastBoundTrainX() {
		return eastBoundx;
	}
	
	public double getWestBoundTrainX() {
		return westBoundx;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
	
	public int getMoveDirection() {
		return direction;
	}
}