package edu.nd.se2018.homework.hwk2.dog.types;

import edu.nd.se2018.homework.hwk2.dog.raceStrategies.RaceStrategy;;

/**
 * Creates the Dog base class
 * @author Michael Wang
 *
 */
public abstract class Dog {
	RaceStrategy raceStrategy;
	
	public Dog(){}
		
	public void setStrategy(){
		raceStrategy.setStrategy();
	}

//		public void swim(){
//			System.out.println("I'm swimming");
//		}
//		
//		public void fly(){
//			flyBehavior.performFly();
//		}
		
	public void setRaceStrategy(RaceStrategy raceStrategy){
		this.raceStrategy = raceStrategy;
	}
		
	public abstract void display();		
}

