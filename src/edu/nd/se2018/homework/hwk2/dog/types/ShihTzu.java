package edu.nd.se2018.homework.hwk2.dog.types;

import edu.nd.se2018.homework.hwk2.dog.raceStrategies.*;

public class ShihTzu extends Dog{
	public ShihTzu(){
		System.out.println("New Shih Tzu");
		raceStrategy = new SlowStart();
	}

	@Override
	public void display() {
		System.out.println("I am a shih tzu.");		
	}
}
