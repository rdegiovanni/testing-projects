package model_2048;

public class Board_2048 {

	// Stores the game board. Indices for cells must go from 1 to 4, both
	// for rows and for columns.
	Cell_2048 [][] elements;
	
	// Number of rows in the board
	// Should be constantly 4
	public static final int ROWS = 4;
	
	// Number of columns in the board
	// Should be constantly 4
	public static final int COLUMNS = 4;
	
	public Board_2048() {
		make_empty();
	}
	
	public Board_2048(boolean random) {
		if (!random)
			make_empty();
		else
			make_random();
	}
	
	
	public void make_empty() {
		// TODO: Creates an empty board of 4x4 cells (all cells with default value)
	}
	
	public void make_random(){
		// TODO
		// Creates a board of 4x4 cells, with all cells with default value (unset)
		// except for two randomly picked cells, which must be set with eithers 2 or 4.
		// Values to set the filled cells are chosen randomly. Positions of the two filled
		// cells are chosen randomly.
	}
	
	public int nr_of_filled_cells(){
		//TODO:Returns the number of filled cells in the board
		return 0;
	}
	
	public boolean is_full(){
		//TODO: Indicates if all cells in the board are set or not
		return false;
	}
	
	public boolean is_empty(){
		//TODO: Indicates if all cells in the board are not set
		return false;
	}
	
	public boolean can_move_left(){
		//TODO: Indicates whether the board would change through a movement to the left
		return false;
	}
	
	public boolean can_move_right(){
		//TODO: Indicates whether the board would change through a movement to the right
		return false;
	}
	
	public boolean can_move_up(){
		//TODO: Indicates whether the board would change through an up movement
		return false;
	}
	
	public boolean can_move_down(){
		//TODO: Indicates whether the board would change through a down movement
		return false;
	}
	
	public boolean is_winning_board(){
		//TODO: Indicates whether 2048 is present in the board, indicating that the board is a winning board
		return false;
	}

	public void set_cell(int row, int col, int value){
		//TODO: Set cell in [row,col] position with a given value require
	}
}
