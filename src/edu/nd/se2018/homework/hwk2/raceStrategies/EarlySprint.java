package edu.nd.se2018.homework.hwk2.raceStrategies;

public class EarlySprint implements RaceStrategy{
	
	@Override
	public float runRace(float distance, float speed) {
		if (distance < 2)
			return speed;
		else
			return (float) (speed * 0.75);
	}
	
}
