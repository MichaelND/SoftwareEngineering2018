package edu.nd.se2018.homework.hwk3;

public class Ship {
	Point currentLocation = new Point();
	
	public class Point {
		int x;
		int y;
	}
	
	Ship() {
		currentLocation.x = 5;
		currentLocation.y = 5;
	}
	
	public Point getShipLocation() {
		return currentLocation;
	}
}
