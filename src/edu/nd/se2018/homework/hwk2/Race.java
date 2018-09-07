package edu.nd.se2018.homework.hwk2;

import edu.nd.se2018.homework.hwk2.dog.types.*;

/**
 * Creates a new race and adds dogs to it
 * @author Michael Wang
 *
 */
public class Race {
	
	public Race(){
		Dog Max = new Bulldog();
		Max.setStrategy();
		
		Dog Charlie = new Poodle();
		Charlie.setStrategy();
		
		Dog Buddy = new Beagle();
		Buddy.setStrategy();
		
		Dog Jack = new ShihTzu();
		Jack.setStrategy();
		
		Dog Rocky = new Corgi();
		Rocky.setStrategy();
		
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
