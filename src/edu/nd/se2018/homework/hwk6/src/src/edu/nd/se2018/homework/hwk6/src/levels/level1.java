package src.edu.nd.se2018.homework.hwk6.src.levels;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class level1 implements levelStrategy{
	Image tileImage;
	Image keyImage;
	Image wallImage;
	Image portalImage;
	Image chipItemImage;
	
	@Override
	public int[][] createMap(int keyCount, int chipCount, int[][] mapGrid, ObservableList<Node> root, int scale, int dimensions) {
		
		// Create Keys and Walls
		while (keyCount != 0) {
			Random randomKey = new Random();
			Random randomKeyColor = new Random();
			
			int keyColor = randomKeyColor.nextInt(5) + 2;
			int keyX = randomKey.nextInt(15) + 5; // Generate random key position
			int keyY = randomKey.nextInt(16) + 4;
			while (mapGrid[keyX][keyY] >= 2 && mapGrid[keyX][keyY] <= 5) {	  // Tile is already a key
				keyX = randomKey.nextInt(15) + 5; // Generate random key position
				keyY = randomKey.nextInt(16) + 4;
			}
			
			// Select color of key and wall
			if (keyColor == 2) { // Blue
				keyImage = new Image("images//chip//textures//blueKey.png");
				wallImage = new Image("images//chip//textures/blueKeyWall.png");
			}
			else if (keyColor == 3) { // Green
				keyImage = new Image("images//chip//textures//greenKey.png");
				wallImage = new Image("images//chip//textures/greenKeyWall.png");
			}
			else if (keyColor == 4) { // Yellow
				keyImage = new Image("images//chip//textures//yellowKey.png");
				wallImage = new Image("images//chip//textures/yellowKeyWall.png");
			}
			else if (keyColor == 5) { // Red
				keyImage = new Image("images//chip//textures//redKey.png");
				wallImage = new Image("images//chip//textures/redKeyWall.png");
			}
			mapGrid[keyX][keyY] = keyColor;
			
			Rectangle key = new Rectangle(keyX*scale,keyY*scale,scale,scale);
			Rectangle wall = new Rectangle(12*scale,3*scale,scale,scale); // Change keyX and keyY
			
			key.setFill(new ImagePattern(keyImage));
			wall.setFill(new ImagePattern(wallImage));
			wall.setStroke(Color.BLACK);
			key.setStroke(Color.BLACK);
			root.add(wall);
			root.add(key);
			keyCount -= 1;
		}
		
		// Create Chips
		while (chipCount != 0) {
			Random randomKey = new Random();
			int chipX = randomKey.nextInt(15) + 5; // Generate random chip position
			int chipY = randomKey.nextInt(16) + 4;
			while (mapGrid[chipX][chipY] >= 2 || mapGrid[chipX][chipY] <= 7) {	  // Tile is already a chip or key
				chipX = randomKey.nextInt(15) + 5; // Generate random chip position
				chipY = randomKey.nextInt(16) + 4;
			}
			
			Rectangle chip = new Rectangle(chipX*scale,chipY*scale,scale,scale);
			mapGrid[chipX][chipY] = 7;
			chipItemImage = new Image("images//chip//textures//chipItem.png");
			chip.setFill(new ImagePattern(chipItemImage));
			chip.setStroke(Color.BLACK);
			root.add(chip);
			
			chipCount -= 1;
		}
		
		// Create Exit portal
		Rectangle portal = new Rectangle(12*scale,2*scale,scale,scale);
		portalImage = new Image("images//chip//textures//portal.png");
		portal.setFill(new ImagePattern(portalImage));
		portal.setStroke(Color.BLACK);
		root.add(portal);
		
		return mapGrid;
	}
}
