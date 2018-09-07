package edu.nd.se2018.homework.hwk2.dog.types;

import edu.nd.se2018.homework.hwk2.dog.raceStrategies.*;

public class Beagle extends Dog{
	public Beagle(){
		System.out.println("New Beagle");
		raceStrategy = new EarlySprint();
	}

	@Override
	public void display() {
		System.out.println("I am a beagle.");		
	}
}
