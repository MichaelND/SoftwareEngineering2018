package edu.nd.se2018.homework.hwk2.dogs;

import edu.nd.se2018.homework.hwk2.Race;
import edu.nd.se2018.homework.hwk2.raceStrategies.RaceStrategy;

/**
 * Creates the Dog base class
 * @author Michael Wang
 *
 */
public abstract class Dog extends Race{
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
	
	public RaceStrategy getStrategy() {
		return raceStrategy;
	}
	
	public void startRace() {
		distanceRun = 0;
	}
		
	public void setRaceStrategy(RaceStrategy raceStrategy){
		this.raceStrategy = raceStrategy;
	}
		
	public void displayRace() {
		float updateDistance = raceStrategy.runRace(distanceRun, maxSpeed);
		System.out.println(this.name + " has run " + this.distanceRun);
		this.distanceRun = updateDistance;
	}
}

