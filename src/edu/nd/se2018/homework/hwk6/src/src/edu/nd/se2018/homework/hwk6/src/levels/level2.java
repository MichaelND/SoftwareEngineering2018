package src.edu.nd.se2018.homework.hwk6.src.levels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Level two class
 * @author Michael
 *
 */

public class level2 implements levelStrategy{

	Image keyImage;
	Image wallImage;
	Image tileImage = new Image("images//chip//textures//BlankTile.png");
	Image portalImage = new Image("images//chip//textures//portal.png");
	Image chipItemImage = new Image("images//chip//textures//chipItem.png");
	
	@Override
	public int[][] createMap(int chipCount, int[][] mapGrid, ObservableList<Node> root, int scale, int dimensions) {
		List<Rectangle> rectangles = new ArrayList<Rectangle>();
		//Create the basic Map
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle tile = new Rectangle(x*scale,y*scale,scale,scale);
				if (x == 7 && y >= 8 || y == 3 || x == 17 && y <= 15 || y == 21 ) {
					tile.setFill(Color.GRAY);
					mapGrid[x][y] = 1; //1 represents border
				}
				else {
					tile.setFill(new ImagePattern(tileImage));
					mapGrid[x][y] = 0; //0 represents blank tile
				}
				rectangles.add(tile);
			}
		}
		
		// Spawn random Key and set correct color wall
		Random randomKey = new Random();
		Random randomKeyColor = new Random();
		
		int keyColor = randomKeyColor.nextInt(4) + 2;
		int keyX = randomKey.nextInt(25); // Generate random key position
		int keyY = randomKey.nextInt(16) + 4;
		
		while (mapGrid[keyX][keyY] >= 1 && mapGrid[keyX][keyY] <= 6) {	  // Tile is already a chip or key or wall
			keyX = randomKey.nextInt(25); // Generate random chip position
			keyY = randomKey.nextInt(16) + 4;
		}
		
		// Select color of key and wall
		if (keyColor == 2) { // Blue
			keyImage = new Image("images//chip//textures//blueKey.png");
			wallImage = new Image("images//chip//textures//blueKeyWall.png");
			mapGrid[21][3] = 8; // 8 for BlueKeyWall
		}
		else if (keyColor == 3) { // Green
			keyImage = new Image("images//chip//textures//greenKey.png");
			wallImage = new Image("images//chip//textures//greenKeyWall.png");
			mapGrid[21][3] = 9; // 9 for GreenKeyWall
		}
		else if (keyColor == 4) { // Yellow
			keyImage = new Image("images//chip//textures//yellowKey.png");
			wallImage = new Image("images//chip//textures//yellowKeyWall.png");
			mapGrid[21][3] = 10; // 10 for YellowKeyWall
		}
		else if (keyColor == 5) { // Red
			keyImage = new Image("images//chip//textures//redKey.png");
			wallImage = new Image("images//chip//textures//redKeyWall.png");
			mapGrid[21][3] = 11; // 11 for RedKeyWall
		}
		mapGrid[keyX][keyY] = keyColor;
		
		Rectangle key = new Rectangle(keyX*scale,keyY*scale,scale,scale);
		key.setFill(new ImagePattern(keyImage));
		rectangles.add(key);

		Rectangle wall = new Rectangle(21*scale,3*scale,scale,scale); // Change keyX and keyY
		wall.setFill(new ImagePattern(wallImage));
		rectangles.add(wall);
		
		// Create Chips
		while (chipCount != 0) {
			Random randomChip = new Random();
			int chipX = randomChip.nextInt(25); // Generate random chip position
			int chipY = randomChip.nextInt(16) + 4;
			while (mapGrid[chipX][chipY] >= 1 && mapGrid[chipX][chipY] <= 6) {	  // Tile is already a chip or key or wall
				chipX = randomChip.nextInt(25); // Generate random chip position
				chipY = randomChip.nextInt(16) + 4;
			}
			
			Rectangle chip = new Rectangle(chipX*scale,chipY*scale,scale,scale);
			chip.setFill(new ImagePattern(chipItemImage));
			rectangles.add(chip);
			mapGrid[chipX][chipY] = 6; // 6 for chipItem
			
			chipCount -= 1;
		}
		
		// Create Exit portal
		Rectangle portal = new Rectangle(21*scale,2*scale,scale,scale);
		portal.setFill(new ImagePattern(portalImage));
		mapGrid[21][2] = 7; // 7 for portal
		rectangles.add(portal);
		
		// Add every rectangle to map
		for (Rectangle rectangle : rectangles) {
			rectangle.setStroke(Color.BLACK);
			root.add(rectangle);
		}
		
		return mapGrid;
	}
}