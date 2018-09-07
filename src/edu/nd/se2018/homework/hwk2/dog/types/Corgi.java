package edu.nd.se2018.homework.hwk2.dog.types;

import edu.nd.se2018.homework.hwk2.dog.raceStrategies.*;

public class Corgi extends Dog{
	public Corgi(){
		System.out.println("New Corgi");
		raceStrategy = new SlowStart();
	}

	@Override
	public void display() {
		System.out.println("I am a corgi.");		
	}
}
