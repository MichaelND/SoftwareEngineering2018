package edu.nd.se2018.homework.hwk3;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Ocean map class 
 * @author Michael
 *
 */

public class OceanMap {
	Random rand = new Random();
	int[][] oceanGrid; 
	
	public void drawMap(ObservableList<Node> root, int scale, int dimensions, int islandCount) {
		oceanGrid = new int[dimensions][dimensions];
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = 0; //0 represents water
			}
		}
		
		for (int i = 0; i < islandCount; i++) {
			int randx = rand.nextInt(dimensions-1);
			int randy = rand.nextInt(dimensions-1);
			while (oceanGrid[randx][randy] == 1) { //find island that is not already on map
				randx = rand.nextInt(dimensions-1);
				randy = rand.nextInt(dimensions-1);
			}
			
			//update
			Rectangle rect = new Rectangle(randx*scale,randy*scale,scale,scale);
			rect.setStroke(Color.BLACK);
			rect.setFill(Color.FORESTGREEN);
			root.add(rect);
			oceanGrid[randx][randy] = 1; //1 represents island
		}
	}
}
