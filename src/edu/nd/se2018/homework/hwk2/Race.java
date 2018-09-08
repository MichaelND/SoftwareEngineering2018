package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.dogs.Dog;

/**
 * Creates a new race and adds dogs to it
 * @author Michael Wang
 *
 */
public class Race {
	
	public Race(){
		
		Dog dog1 = new Dog("Max");
		Dog dog2 = new Dog("Charlie");
		Dog dog3 = new Dog("Buddy");
		Dog dog4 = new Dog("Jack");
		Dog dog5 = new Dog("Rocky");
		
		
//		Dog Max = new EarlySprint();
//		Max.setStrategy(new EarlySprint());
//		Dog Charlie = new EarlySprint();
//		Dog Buddy =  new SlowStart();
//		Dog Jack =  new SteadyRun;
//		Dog Rocky =  new SteadyRun();
//		
//		
//		race.addDog("Buddy", 24, new SlowStart());
//		race.addDog("Jack", 26, new SteadyRun());
//		race.addDog("Rocky", 23, new SteadyRun());
//		
//		race.start();
//		race.display();
//		race.displayWinner();
//		
//		for (Dog dog : contestants) {
//			race.startRace(dog);
//		}
//		
//		for (Dog dog : contestants) {
//			dog.startRace();
//		}
//		
//		boolean winner = false;
//		while (!winner) {
//			for (Dog dog : contestants) {
//				dog.display();
//			}
//		}
//	
		
		//Add Horses
		//each horse has a name and maximum speed
		//races are 10 miles
		//three strategies
		// early sprint
		// - max speed for first 2 miles then 75%
		// steady run
		// - 80% of max speed for the whole time
		// slow start
		// - 75% for 6 miles, 90% for 3 miles, 100% for 1 mile
		//Start Race
		//Run Race
		//Announce Winner
		
	}

}
