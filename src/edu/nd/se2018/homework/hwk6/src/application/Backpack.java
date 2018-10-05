package application;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk3.Ship;

public class Backpack implements Observer{
	int chips;
	int redKeys;
	int blueKeys;
	int greenKeys;
	int yellowKeys;
	
	Point chipLocation;
	
	public Backpack() {
		chips = 0;
		redKeys = 0;
		blueKeys = 0;
		greenKeys = 0;
		yellowKeys = 0;
	}
	public void empty() {
		chips = 0;
		redKeys = 0;
		blueKeys = 0;
		greenKeys = 0;
		yellowKeys = 0;
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Chip){
			chipLocation = ((Chip)o).getChipLocation();
			updateBackpack();			
		}
		
	}
	private void updateBackpack() {
		// TODO Auto-generated method stub
		
	}
}
