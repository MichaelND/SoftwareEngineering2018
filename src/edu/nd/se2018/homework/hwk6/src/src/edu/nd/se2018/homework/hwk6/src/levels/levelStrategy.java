package src.edu.nd.se2018.homework.hwk6.src.levels;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public interface levelStrategy {
	public int[][] createMap(int chipCount, int[][] mapGrid, ObservableList<Node> root, int scale, int dimensions);
}
