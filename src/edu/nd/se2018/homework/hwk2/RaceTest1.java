package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.nd.se2018.homework.hwk2.dogs.Dog;
import edu.nd.se2018.homework.hwk2.raceStrategies.*;

public class RaceTest1 {
	@Test
	public void test() {
		//Test the three different strategies to make sure they are implemented properly
		//Also, test switching up the race strategies of the dogs
		
		Race newrace = new Race();
		List<Dog> contestants = new ArrayList<Dog>();
		
		Dog dog1 = newrace.addDog("Max", 11, new EarlySprint());
		Dog dog2 = newrace.addDog("Charlie", 11, new SlowStart());
		Dog dog3 = newrace.addDog("Buddy", 11, new SteadyRun());

		contestants.add(dog1);
		contestants.add(dog2);
		contestants.add(dog3);
		
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Charlie");
		
		dog1.setRaceStrategy(new SteadyRun());
		dog2.setRaceStrategy(new EarlySprint());
		dog3.setRaceStrategy(new SlowStart());
		
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Buddy");
		

		dog3.setRaceStrategy(new EarlySprint());
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Max");
	}
}
