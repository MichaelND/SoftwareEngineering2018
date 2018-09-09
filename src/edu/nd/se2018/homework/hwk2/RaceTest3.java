package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.nd.se2018.homework.hwk2.dogs.Dog;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

public class RaceTest3 {
	@Test
	public void test() {
		//Test using many dogs and also variation of speed and strategies to make sure race can correctly output optimal speed and strategy
		Race newrace = new Race();
		List<Dog> contestants = new ArrayList<Dog>();
				
		Dog dog1 = newrace.addDog("Max", 128, new EarlySprint());
		Dog dog2 = newrace.addDog("Charlie", 137, new SteadyRun());
		Dog dog3 = newrace.addDog("Buddy", 141, new EarlySprint());
		Dog dog4 = newrace.addDog("Joe", 121, new SlowStart());
		Dog dog5 = newrace.addDog("Doggo", 140, new SteadyRun());
		Dog dog6 = newrace.addDog("Doge", 137, new SlowStart());
		Dog dog7 = newrace.addDog("Lucky", 135, new EarlySprint());

		contestants.add(dog1);
		contestants.add(dog2);
		contestants.add(dog3);
		contestants.add(dog4);
		contestants.add(dog5);
		contestants.add(dog6);
		contestants.add(dog7);
				
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Buddy"); //Highest speed and early sprint wins
	
		dog6.setMaxSpeed(138);
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Doge"); //Slow start with lower speed wins (optimal strategy)
	}
}
