package EtchApp;

import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUICode extends BorderPane{
	
	protected Label[][] labels;
	private int rows;
	private int columns;
	protected int currRow = 0;
	protected int currCol = 0;
	protected Label currLocation;
	protected Label cursor = new Label();
	
	public GUICode(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
		labels = new Label[this.rows][this.columns];
		GUIHere();
	}
	
	public void GUIHere() {
		BorderPane holderTop = new BorderPane();
		Text message = new Text("Cursor Location: ");
		HBox topDeets = new HBox(message);
		currLocation = new Label("(0 , 0)");
		Button shake = new Button("Shake");
		holderTop.setLeft(message);
		holderTop.setCenter(currLocation);
		holderTop.setRight(shake);
		this.setTop(holderTop);
		creation();
		shake.setOnAction(e -> {
			clear();
		});
	}
	
	public void creation() {
		GridPane grid = new GridPane();
		this.setCenter(grid);
		for(int rowCount = 0; rowCount < this.rows; rowCount++) {
			for(int colCount = 0; colCount < this.columns; colCount++) {
				Label etchLabel = new Label();
				labels[rowCount][colCount] = etchLabel; 
				etchLabel.getStyleClass().add("etchLabel");
				grid.add(etchLabel, colCount, rowCount);
			}
		}
		cursor = labels[0][0];
		cursor.getStyleClass().remove(cursor.getStyleClass().size()-1);
		cursor.getStyleClass().add("cursorLabel");
	}
	
	public void clear() {
		for(int rowCount = 0; rowCount < this.rows; rowCount++) {
			for(int colCount = 0; colCount < this.columns; colCount++) {
				if(rowCount == currRow && colCount == currCol) {
  					continue;
				}
  				else {
  					labels[rowCount][colCount].getStyleClass().remove(cursor.getStyleClass().size()-1);
  					labels[rowCount][colCount].getStyleClass().add("etchLabel");
  				}
			}
		}
	}
	
	public void currentLocation() {
		currLocation.setText("( " + currRow + " , " + currCol + " )");
	}
	
	public void keyMove(int row, int column, Game game) {
		if(game.verifier(currRow + row, currCol + column)) {
			cursor.getStyleClass().remove(cursor.getStyleClass().size()-1);
			cursor.getStyleClass().add("traversedLabel");
			this.currRow += row;
			this.currCol += column;
			cursor = labels[currRow][currCol];
			currentLocation();
			cursor.getStyleClass().remove(cursor.getStyleClass().size()-1);
			cursor.getStyleClass().add("cursorLabel");
		}
	}
}
