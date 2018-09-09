package edu.nd.se2018.homework.hwk2.raceStrategies;

public class SlowStart implements RaceStrategy{
	
	@Override
	public float runRace(float distance, float speed) {
		if (distance < 6)
			return (float) (speed * 0.75);
		else if (distance >= 6 && distance < 9)
			return (float) (speed * 0.9);
		else
			return speed;
	}
	
}