package edu.nd.se2018.homework.hwk2;

import java.util.List;
import java.util.ArrayList;
import edu.nd.se2018.homework.hwk2.dogs.Dog;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

/**
 * Creates a new race of dogs and displays the winner
 * @author Michael Wang
 *
 */
public class Race {
	public Race() {}
	
	public void runSampleRace() {
		Race newrace = new Race();
		List<Dog> contestants = new ArrayList<Dog>();

		
		//Add Dogs to race and initialize strategy and max speed
		Dog dog1 = newrace.addDog("Max", 15, new EarlySprint());
		Dog dog2 = newrace.addDog("Charlie", 14, new SlowStart());
		Dog dog3 = newrace.addDog("Buddy", 15, new SteadyRun());
		Dog dog4 = newrace.addDog("Jack", 13, new SlowStart());
		Dog dog5 = newrace.addDog("Rocky", 14, new EarlySprint());

		contestants.add(dog1);
		contestants.add(dog2);
		contestants.add(dog3);
		contestants.add(dog4);
		contestants.add(dog5);
		
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		System.out.print("The winner is " + newrace.findWinner(contestants) + "\n");	
	}
	
	public Dog addDog(String name, float maxSpeed, RaceStrategy strategy) {
		Dog dog = new Dog(name);
		dog.setMaxSpeed(maxSpeed);
		dog.setRaceStrategy(strategy);
		return dog;
	}
	public void startRace(List<Dog> dogs) {
		System.out.println("Race Has Started!\n");
		for (Dog dog : dogs) {
			dog.startRace();
		}
	}
	public void runRace(List<Dog> dogs) {
		for (float i = 1; i <= 10; i++) {
			for (Dog dog: dogs) {
				dog.displayRace(i);
			}
			System.out.println("\n");
		}
	}
	public String findWinner(List<Dog> dogs) {
		float maxDistance = -1;
		String winner = "";
		for (Dog dog : dogs) { 
			if (dog.getDistance() > maxDistance) {
				maxDistance = dog.getDistance();
				winner = dog.getName();
			}
		}
		return winner;
	}
}
