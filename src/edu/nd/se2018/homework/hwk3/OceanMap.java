package edu.nd.se2018.homework.hwk3;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	enum cellType {
		WATER, ISLAND, PIRATE;
	}
	Random rand = new Random();
	
	public void drawMap(ObservableList<Node> root, int scale, int dimensions, int islandCount) {
		cellType[][] oceanGrid = new cellType[dimensions][dimensions];
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = cellType.WATER;
			}
		}
		
		
		
		
	}
}
