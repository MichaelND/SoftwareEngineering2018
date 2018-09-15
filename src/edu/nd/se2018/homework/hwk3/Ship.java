package edu.nd.se2018.homework.hwk3;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable{
	Point currentLocation;
	int dimensions = 25;
	
	public Ship() {
		currentLocation = new Point(12,12);
	}
	public Point getShipLocation() {
		return currentLocation;
	}
	public void goEast() {
		if (currentLocation.x < dimensions - 1) {
			currentLocation.x++;
		}
	}
	public void goWest() {
		if (currentLocation.x > 0) {
			currentLocation.x--;
		}
	}
	public void goNorth() {
		if (currentLocation.y > 0) {
			currentLocation.y--;
		}
	}
	public void goSouth() {
		if (currentLocation.y < dimensions - 1) {
			currentLocation.y++;
		}
	}
}
