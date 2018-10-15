package application;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

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

public class Map implements Observer{
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
		Scale = scale;
		mapGrid = new int[dimensions][dimensions];
		//Create the basic Map
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				if (x == 4 || y == 3 ||  x == 20 || y == 21 || y == 12 && x <= 4 || y == 12 && x >= 20 || x == 12 && y >= 21) {
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
	@Override
	public void update(Observable o, Object arg) { // Set the tile to blank tile
		if (o instanceof Backpack){
			System.out.println("Map updated");
			int x = ((Backpack)o).chipLocation.x;
			int y = ((Backpack)o).chipLocation.y;
			Rectangle rect = new Rectangle(x*Scale,y*Scale,Scale,Scale);
			tileImage = new Image("images//chip//textures//BlankTile.png");
			rect.setFill(new ImagePattern(tileImage));
			mapGrid[x][y] = 0;
			rect.setStroke(Color.BLACK);
			Root.add(rect);
		}
		
	}
}

