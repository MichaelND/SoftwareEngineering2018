package src.edu.nd.se2018.homework.hwk6.src.levels;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Level one class
 * @author Michael
 *
 */

public class level1 implements levelStrategy{
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
			
			int keyColor = randomKeyColor.nextInt(4) + 2;
			int keyX = randomKey.nextInt(15) + 5; // Generate random key position
			int keyY = randomKey.nextInt(16) + 4;
			
			// Select color of key and wall
			if (keyColor == 2) { // Blue
				keyImage = new Image("images//chip//textures//blueKey.png");
				wallImage = new Image("images//chip//textures//blueKeyWall.png");
				mapGrid[12][3] = 8; // 8 for BlueKeyWall
			}
			else if (keyColor == 3) { // Green
				keyImage = new Image("images//chip//textures//greenKey.png");
				wallImage = new Image("images//chip//textures//greenKeyWall.png");
				mapGrid[12][3] = 9; // 9 for GreenKeyWall
			}
			else if (keyColor == 4) { // Yellow
				keyImage = new Image("images//chip//textures//yellowKey.png");
				wallImage = new Image("images//chip//textures//yellowKeyWall.png");
				mapGrid[12][3] = 10; // 10 for YellowKeyWall
			}
			else if (keyColor == 5) { // Red
				keyImage = new Image("images//chip//textures//redKey.png");
				wallImage = new Image("images//chip//textures//redKeyWall.png");
				mapGrid[12][3] = 11; // 11 for RedKeyWall
			}
			mapGrid[keyX][keyY] = keyColor;
			
			Rectangle key = new Rectangle(keyX*scale,keyY*scale,scale,scale);
			key.setFill(new ImagePattern(keyImage));
			key.setStroke(Color.BLACK);
			root.add(key);
			
			Rectangle wall = new Rectangle(12*scale,3*scale,scale,scale); // Change keyX and keyY
			wall.setFill(new ImagePattern(wallImage));
			wall.setStroke(Color.BLACK);
			root.add(wall);
			
			keyCount -= 1;
		}
		
		// Create Chips
		while (chipCount != 0) {
			Random randomKey = new Random();
			int chipX = randomKey.nextInt(15) + 5; // Generate random chip position
			int chipY = randomKey.nextInt(16) + 4;
			while (mapGrid[chipX][chipY] >= 2 && mapGrid[chipX][chipY] <= 6) {	  // Tile is already a chip or key
				chipX = randomKey.nextInt(15) + 5; // Generate random chip position
				chipY = randomKey.nextInt(16) + 4;
			}
			
			Rectangle chip = new Rectangle(chipX*scale,chipY*scale,scale,scale);
			mapGrid[chipX][chipY] = 6; // 6 for chipItem
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
		mapGrid[12][2] = 7; // 7 for portal
		root.add(portal);
		
		return mapGrid;
	}
}
