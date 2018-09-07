package edu.nd.se2018.homework.hwk2.dog.types;

import edu.nd.se2018.homework.hwk2.dog.raceStrategies.*;

public class Bulldog extends Dog{
	public Bulldog(){
		System.out.println("New Bulldog");
		raceStrategy = new EarlySprint();
	}

	@Override
	public void display() {
		System.out.println("I am a bulldog.");		
	}
}
