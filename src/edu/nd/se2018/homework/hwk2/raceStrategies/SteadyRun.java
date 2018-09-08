package edu.nd.se2018.homework.hwk2.raceStrategies;

public class SteadyRun implements RaceStrategy{

	@Override
	public float runRace(float distance, float speed) {
		return (float) (speed * 0.80);
	}

}
