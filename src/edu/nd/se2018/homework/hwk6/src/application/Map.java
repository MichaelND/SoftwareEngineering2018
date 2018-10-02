package application;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Map class 
 * @author Michael
 *
 */

public class Map {
	Random rand = new Random();
	int[][] mapGrid; 
	Image tileImage;
	
	public void drawMap(ObservableList<Node> root, int scale, int dimensions) {
		mapGrid = new int[dimensions][dimensions];
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
				tileImage = new Image("images//chip//textures//BlankTile.png");
				rect.setStroke(Color.BLACK);
				rect.setFill(new ImagePattern(tileImage));
				root.add(rect);
				mapGrid[x][y] = 0; //0 represents blank tile
			}
		}
		
//		for (int i = 0; i < islandCount; i++) {
//			int randx = rand.nextInt(dimensions);
//			int randy = rand.nextInt(dimensions);
//			while (oceanGrid[randx][randy] == 1 || (randx == 12 && randy == 12)) { //find island that is not already on map
//				randx = rand.nextInt(dimensions);
//				randy = rand.nextInt(dimensions);
//			}
			
			//update
//			Rectangle rect = new Rectangle(randx*scale,randy*scale,scale,scale);
//			rect.setStroke(Color.BLACK);
//			rect.setFill(Color.FORESTGREEN);
//			root.add(rect);
//			mapGrid[randx][randy] = 1; //1 represents island
//		}
	}
}

