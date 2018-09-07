package edu.nd.se2018.homework.hwk2.dog.types;

import edu.nd.se2018.homework.hwk2.dog.raceStrategies.*;

public class Poodle extends Dog{
	public Poodle(){
		System.out.println("New Poodle");
		raceStrategy = new SteadyRun();
	}

	@Override
	public void display() {
		System.out.println("I am a poodle.");		
	}
}