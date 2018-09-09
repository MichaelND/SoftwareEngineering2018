package edu.nd.se2018.homework.hwk2.dogs;

import edu.nd.se2018.homework.hwk2.raceStrategies.RaceStrategy;

/**
 * Creates the Dog class
 * @author Michael Wang
 *
 */
public class Dog {
	RaceStrategy raceStrategy;
	float maxSpeed;
	float distanceRun;
	String name;
	
	public Dog(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public float getDistance() {
		return distanceRun;
	}
	
	public RaceStrategy getStrategy() {
		return raceStrategy;
	}
	
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public void startRace() {
		this.distanceRun = 0;
	}
		
	public void setRaceStrategy(RaceStrategy raceStrategy){
		this.raceStrategy = raceStrategy;
	}
		
	public void displayRace(float currentDistance) {
		float updateDistance = raceStrategy.runRace(currentDistance, maxSpeed);
		System.out.println(this.name + " has run " + this.distanceRun);
		this.distanceRun = this.distanceRun + updateDistance;
	}
}

