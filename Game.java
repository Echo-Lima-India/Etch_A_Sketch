package EtchApp;

public class Game {
	private int rows;
	private int columns;
	
	public Game(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}
	
	public boolean verifier(int row, int column) {
		if(row < 0 || column < 0 || row >= getRows() || column >= getColumns()) {
			return false;
		}
		return true;
		
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int row) {
		this.rows = row;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int column) {
		this.columns = column;
	}
}