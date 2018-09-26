package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Observer;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 * Added functionality of moving through junction and for cars to leave right lane to move to left
 * @editor michael
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double speed = 0;
	private boolean inJunction = false;
	private Car leadCar = null; // keeps track of car instead of y coordinate
	private Road road;
	private CarFactory factory;
	private boolean outJunction = false;
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y, CarFactory factory, Road road){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
		this.factory = factory;
		this.road = road;	
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMove = true; 
		
		// 1/4 chance to move to junction if in right spot
		if (currentX > 600 && currentY > 193 && currentY < 195 && !inJunction) {
			if ((int)(Math.random() * 4) == 1) { 
				// car is now junction and the lead car is set to be the last car of this road
				setInJunction(true);
				leadCar = road.getLastCar();
				road.setLastCar(this);
				setChanged();
				notifyObservers();
			}
		}

		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMove = false;
		
		if (inJunction) {
			//first case, car needs to wait in junction because it has reached the end of junction
			if (getVehicleX() < 423) {
				canMove = false;
				
				// Check other road for traffic
				// if there is no traffic, leave junction and enter new road
				if (factory.getOppositeCarFactory().getPreviousCar() != null && factory.getOppositeCarFactory().getPreviousCar().getVehicleY() > 225) { 
					if (factory.getOppositeCarFactory().getPreviousCar() != null)
						factory.getOppositeCarFactory().getPreviousCar().addObserver(this); //have the previous car observe this car
					factory.getOppositeCarFactory().setPreviousCar(this); //set the previous car as this
					
					setInJunction(false);
					setOutJunction(true);
					
					//remove previous gate observing this car, and have other gate observe this car
					for (CrossingGate gate : factory.getCrossingGates())
						gate.deleteObserver(this);
					for (CrossingGate gate : factory.getOppositeCarFactory().getCrossingGates()) {
						gate.addObserver(this);
						if (gate != null && gate.getTrafficCommand() == "STOP")
							this.setGateDownFlag(false);
					}
				}
				
			}
			// Second case. Car is too close too other car.
			if (leadCar != null && leadCar.getInJunction() && getDistanceToLeadCarX() < 50 )
				canMove = false;
		
			if (canMove){
				currentX -= speed;
				ivCar.setX(currentX);
			}
		}
		else { //car not in junction
			// lead car is at the end
			if (leadCar == null || leadCar.getVehicleY() > 1020) {
				leadCar = null;
			}
			
			// Second case. Car is too close too other car.
			if (leadCar != null && !leadCar.getInJunction() && getDistanceToLeadCarY() < 50)
				canMove = false;
			
			if (getOutJunction()) { //if car is coming out of junction on the west road
				if (getVehicleX() > 393) {
					currentX-=speed;
					ivCar.setX(currentX);
				}
				else
					setOutJunction(false);
			}
			
			if (canMove) {
				currentY+=speed;
				ivCar.setY(currentY);
			}
		}
		setChanged();
		notifyObservers();
	}

	public boolean getInJunction() {
		return this.inJunction;
	}
	
	public void setInJunction(boolean inJ) {
		this.inJunction = inJ;
	}
	
	public boolean getOutJunction() {
		return this.outJunction;
	}
	
	public void setOutJunction(boolean outJ) {
		this.outJunction = outJ;
	}
	
	public void setLeadCar(Car lead) {
		leadCar = lead;
	}
	
	public Car getLeadCar() {
		return leadCar;
	}
	
	public CarFactory getFactory() {
		return factory;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}

	public double getDistanceToLeadCarY(){
		return Math.abs(leadCar.getVehicleY()-getVehicleY());
	}
	
	public double getDistanceToLeadCarX(){
		return Math.abs(leadCar.getVehicleX()-getVehicleX());
	}
	
	public void removeLeadCar(){
		leadCar = null;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCar = ((Car) o); // keep track of leading car
			
			if (!this.inJunction) { // if car in not in junction
				if (((Car) o).getInJunction()) {
					leadCar = ((Car) o).getLeadCar();
					o.deleteObserver(this);
				}
				if (leadCar == null || leadCar.getVehicleY() > 1020) {
					leadCar = null;
				}
			}
			else { // car turns into junction, previous car should observe new car in front
				if (!((Car)o).getInJunction()) { // the lead car in junction goes into west road, stop observing 
					o.deleteObserver(this);
				}
			}
		
		}
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}				
	}
	@Override
	public void setMoveDirection(String direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		currentY = originalY;
		
	}
}
