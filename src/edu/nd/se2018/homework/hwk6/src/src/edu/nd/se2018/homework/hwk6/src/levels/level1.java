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

	@Override
	public int[][] createMap(int keyCount, int chipCount, int[][] mapGrid, ObservableList<Node> root, int scale, int dimensions) {
		
		while (keyCount != 0) {
			Random randomKey = new Random();
			Random randomKeyColor = new Random();
			
			int keyColor = randomKeyColor.nextInt(4) + 1;
			int keyX = randomKey.nextInt(15) + 5; // Generate random key position
			int keyY = randomKey.nextInt(16) + 4;
			while (mapGrid[keyX][keyY] == 2) {	  // Tile is already a key
				keyX = randomKey.nextInt(15) + 5; // Generate random key position
				keyY = randomKey.nextInt(16) + 4;
			}
			
			Rectangle rect = new Rectangle(keyX*scale,keyY*scale,scale,scale);
			mapGrid[keyX][keyY] = 2;
			
			if (keyColor == 1)
				keyImage = new Image("images//chip//textures//blueKey.png");
			else if (keyColor == 2)
				keyImage = new Image("images//chip//textures//greenKey.png");
			else if (keyColor == 3)
				keyImage = new Image("images//chip//textures//yellowKey.png");
			else if (keyColor == 4)
				keyImage = new Image("images//chip//textures//redKey.png");
			
			rect.setFill(new ImagePattern(keyImage));
			rect.setStroke(Color.BLACK);
			root.add(rect);
			keyCount -= 1;
		}
		return mapGrid;
	}
}
