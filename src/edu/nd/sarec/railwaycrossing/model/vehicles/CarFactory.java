package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;


/**
 * Very basic car factory.  Creates the car and registers it with the crossing gate and the car infront of it.
 * @author jane
 * Added methods for car factory to get opposite car factory, previous car, and crossing gates 
 * @editor michael
 */
public class CarFactory {
	
	private Collection<CrossingGate> gates = null;
	private Car previousCar = null;
	private ArrayList<Car> cars = new ArrayList<Car>();
	Direction direction;
	Point location;
	private CarFactory oppositeFactory;
	
	public CarFactory(Direction direction, Point location, Collection<CrossingGate> gates, CarFactory opposite){
		this.direction = direction;
		this.location = location;
		this.gates = gates;
		this.oppositeFactory = opposite;
	}
	
	public CarFactory getOppositeCarFactory() {
		return oppositeFactory;
	}
	
	public void setPreviousCar(Car prev) {
		previousCar = prev;
	}
	
	public Car getPreviousCar() {
		return previousCar;
	}
	
	public Collection<CrossingGate> getCrossingGates( ) {
		return gates;
	}
	// Most code here is to create random speeds
	public Car buildCar(Road road){
		if (previousCar == null || location.y < previousCar.getVehicleY()-100){
			Car car = new Car(location.x,location.y, this, road);	
			double speedVariable = (Math.random() * 10)/10;
			car.setSpeed((2-speedVariable)*1.25); 
			
			// All cars created by this factory must be aware of crossing gates in the road
			for(CrossingGate gate: gates){
				gate.addObserver(car);
				if(gate != null && gate.getTrafficCommand()=="STOP")
					car.setGateDownFlag(false);
			}
			
			// Each car must observe the car infront of it so it doesn't collide with it.
			if (previousCar != null)
				previousCar.addObserver(car);
			previousCar = car;
			
			cars.add(car);
			return car;
		} else 
			return null;

	}

	// We will get a concurrency error if we try to delete cars whilst iterating through the array list
	// so we perform this in two stages.
	// 1.  Loop through the list and identify which cars are off the screen.  Add them to 'toDelete' array.
	// 2.  Iterate through toDelete and remove the cars from the original arrayList.
	public ArrayList<Car> removeOffScreenCars() {
		// Removing cars from the array list.
		ArrayList<Car> toDelete = new ArrayList<Car>();
		for(Car car: cars) {
			car.move();
			if (car.offScreen())
				toDelete.add(car);
		}   

		for (Car car: toDelete)
			cars.remove(car);
		return toDelete;
	}
}
