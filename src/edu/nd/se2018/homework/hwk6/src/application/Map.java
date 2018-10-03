package application;

import java.util.Random;

import src.edu.nd.se2018.homework.hwk6.src.levels.level1;
import src.edu.nd.se2018.homework.hwk6.src.levels.levelStrategy;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Map class 
 * @author Michael
 *
 */

public class Map {
	levelStrategy levelStrat;
	int[][] mapGrid; 
	Image tileImage;
	ObservableList<Node> Root;
	int Scale;
	int Dimensions;
	
	public void drawMap(ObservableList<Node> root, int scale, int dimensions) {
		Root = root;
		Scale = scale;
		Dimensions = dimensions;
		mapGrid = new int[dimensions][dimensions];
		//Create the basic Map
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				if (x == 4 || y == 3 ||  x == 20 || y == 21 || y == 12 && x <= 4 || y == 12 && x >= 20) {
					rect.setFill(Color.GRAY);
					mapGrid[x][y] = 1; //1 represents border
				}
				else {
					tileImage = new Image("images//chip//textures//BlankTile.png");
					rect.setFill(new ImagePattern(tileImage));
					mapGrid[x][y] = 0; //0 represents blank tile
				}
				rect.setStroke(Color.BLACK);
				root.add(rect);
			}
		}
	}
	public int[][] createMap(int keyCount, int chipCount, ObservableList<Node> root, int scale, int dimensions) {
		return levelStrat.createMap(keyCount, chipCount, mapGrid, root, scale, dimensions);
	}
	public void setLevelStrategy(levelStrategy strategy){
		this.levelStrat = strategy;
	}
}

