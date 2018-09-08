package edu.nd.se2018.homework.hwk2;

import java.util.List;
import java.util.ArrayList;
import edu.nd.se2018.homework.hwk2.dogs.Dog;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

/**
 * Creates a new race and adds dogs to it
 * @author Michael Wang
 *
 */
public class Race {
	
	public Race(){
		List<Dog> contestants = new ArrayList<Dog>();

		//Add Dogs to race and initialize strategy and max speed
		Dog dog1 = new Dog("Max");
		dog1.setRaceStrategy(new EarlySprint());
		dog1.setMaxSpeed(10);
		contestants.add(dog1);
		
		Dog dog2 = new Dog("Charlie");
		dog2.setRaceStrategy(new SlowStart());
		dog2.setMaxSpeed(10);
		contestants.add(dog2);
		
		Dog dog3 = new Dog("Buddy");
		dog3.setRaceStrategy(new SteadyRun());
		dog3.setMaxSpeed(10);
		contestants.add(dog3);
		
		Dog dog4 = new Dog("Jack");
		dog4.setRaceStrategy(new SlowStart());
		dog4.setMaxSpeed(10);
		contestants.add(dog4);
		
		Dog dog5 = new Dog("Rocky");
		dog5.setRaceStrategy(new EarlySprint());
		dog5.setMaxSpeed(10);
		contestants.add(dog5);
		
		//Start Race
		System.out.println("Race Has Started!\n");
		for (Dog dog : contestants) {
			dog.startRace();
		}
		//Run Race
		for (float i = 0; i <= 10; i++) {
			for (Dog dog: contestants) {
				dog.displayRace(i);
			}
			System.out.println("\n");
		}
		//Calculate and Announce Winner
		float maxDistance = 0;
		String winner = "";
		for (Dog dog : contestants) { 
			if (dog.getDistance() > maxDistance) {
				maxDistance = dog.getDistance();
				winner = dog.getName();
			}
		}
		System.out.println("The Winner is " + winner);
	}
}
