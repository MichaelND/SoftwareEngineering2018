package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.nd.se2018.homework.hwk2.dogs.Dog;
import edu.nd.se2018.homework.hwk2.raceStrategies.EarlySprint;
import edu.nd.se2018.homework.hwk2.raceStrategies.SlowStart;
import edu.nd.se2018.homework.hwk2.raceStrategies.SteadyRun;

public class RaceTest2 {
	@Test
	public void test() {
		//Test using different speeds with the same race strategy for all three strategies
		
		Race newrace = new Race();
		List<Dog> contestants = new ArrayList<Dog>();
		
		Dog dog1 = newrace.addDog("Max", 14, new EarlySprint());
		Dog dog2 = newrace.addDog("Charlie", 13, new EarlySprint());

		contestants.add(dog1);
		contestants.add(dog2);
		
		//Max's speed is higher for early sprint strategy
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Max"); //Higher speed dog wins
		
		//Both dogs are now using the slow start strategy
		dog1.setRaceStrategy(new SlowStart());
		dog2.setRaceStrategy(new SlowStart());
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Max"); //Higher speed dog wins
		
		//Both dogs are at the same speed using the steady run strategy
		dog1.setMaxSpeed(13);
		dog2.setMaxSpeed(14);
		dog1.setRaceStrategy(new SteadyRun());
		dog2.setRaceStrategy(new SteadyRun());
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Charlie"); //Higher speed dog wins
		
		//Edge case where both dogs don't move
		dog1.setMaxSpeed(0);
		dog2.setMaxSpeed(0);
		newrace.startRace(contestants);
		newrace.runRace(contestants);
		assert(newrace.findWinner(contestants)=="Max"); //First dog wins
	}
}
