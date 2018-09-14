package edu.nd.se2018.homework.hwk3;

import java.awt.Point;

public class Ship {
	Point currentLocation;
	
	public Ship() {
		currentLocation = new Point(12,12);
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}
}
