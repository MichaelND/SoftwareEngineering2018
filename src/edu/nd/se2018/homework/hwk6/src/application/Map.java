package application;

import java.util.Observable;
import java.util.Observer;

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
	
	public Map(ObservableList<Node> root, int scale, int dimensions) {
		Root = root;
		Scale = scale;
		Scale = scale;
		mapGrid = new int[dimensions][dimensions];
	}
	public int[][] createMap(int chipCount, ObservableList<Node> root, int scale, int dimensions) {
		return levelStrat.createMap(chipCount, mapGrid, root, scale, dimensions);
	}
	public void setLevelStrategy(levelStrategy strategy){
		this.levelStrat = strategy;
	}
	@Override
	public void update(Observable o, Object arg) { // Set the tile to blank tile when backpack gets a key or chip or enters wall
		if (o instanceof Backpack){
			int x = ((Backpack)o).chipLocation.x;
			int y = ((Backpack)o).chipLocation.y;
			Rectangle rect = new Rectangle(x*Scale, y*Scale, Scale, Scale);
			tileImage = new Image("images//chip//textures//BlankTile.png",Scale,Scale,true,true);
			rect.setFill(new ImagePattern(tileImage));
			rect.setStroke(Color.BLACK);
			Root.add(rect);
			mapGrid[x][y] = 0;
		}
	}
}

