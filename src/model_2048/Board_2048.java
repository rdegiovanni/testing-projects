package model_2048;

import java.util.Random;

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
		// Creates an empty board of 4x4 cells (all cells with default value)
		elements = new Cell_2048[ROWS][COLUMNS];
		for(int i = 0; i<ROWS; i++){
			for(int j=0; i<COLUMNS;j++){
				elements[i][j] = new Cell_2048();
			}
		}
	}
	
	public void make_random(){
		// Creates a board of 4x4 cells, with all cells with default value (unset)
		// except for two randomly picked cells, which must be set with eithers 2 or 4.
		// Values to set the filled cells are chosen randomly. Positions of the two filled
		// cells are chosen randomly.
		make_empty();
		int first_random_cell_row = getRandom(ROWS);
		int first_random_cell_col = getRandom(COLUMNS);
		int second_random_cell_row = getRandom(ROWS);
		int second_random_cell_col = getRandom(COLUMNS);
		while (first_random_cell_row==second_random_cell_row && first_random_cell_col==second_random_cell_col){
			second_random_cell_row = getRandom(ROWS);
			second_random_cell_col = getRandom(COLUMNS);	
		}
		int value = getRandom(2)%2;
		set_cell(first_random_cell_row, first_random_cell_col, value*2);
	}
	
	private int getRandom(int bound){
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt()%bound;
	    return randomInt;
	}
	
	public int nr_of_filled_cells(){
		//Returns the number of filled cells in the board
		int filled_cells=0;
		for(int i = 0; i<ROWS; i++){
			for(int j=0; i<COLUMNS;j++){
				if(!elements[i][j].is_available())
					filled_cells++;
			}
		}
		return filled_cells;
	}
	
	public boolean is_full(){
		//Indicates if all cells in the board are set or not
		return nr_of_filled_cells()==(ROWS*COLUMNS);
	}
	
	public boolean is_empty(){
		//Indicates if all cells in the board are not set
		return nr_of_filled_cells()==0;
	}
	
	public boolean can_move_left(){
		//Indicates whether the board would change through a movement to the left
		boolean can_move = false;
		for(int i = 0; (i<ROWS && !can_move); i++){
			for(int j = 1; (j < COLUMNS && !can_move); j++){
				if(!elements[i][j].is_available()){
					if (elements[i][j-1].is_available() || (elements[i][j-1].getValue() == elements[i][j].getValue())){
						//if the cell on the left is empty or has the same value, then you can move left
						can_move = true;
					}
				}
			}
		}
		return can_move;
	}
	
	public boolean can_move_right(){
		//Indicates whether the board would change through a movement to the right
		boolean can_move = false;
		for(int i = 0; (i<ROWS && !can_move); i++){
			for(int j = 0; (j < (COLUMNS-1) && !can_move); j++){
				if(!elements[i][j].is_available()){
					if (elements[i][j+1].is_available() || (elements[i][j+1].getValue() == elements[i][j].getValue())){
						//if the cell on the left is empty or has the same value, then you can move left
						can_move = true;
					}
				}
			}
		}
		return can_move;	
	}
	
	public boolean can_move_up(){
		//Indicates whether the board would change through an up movement
		boolean can_move = false;
		for(int i = 1; (i<ROWS && !can_move); i++){
			for(int j = 0; (j < COLUMNS && !can_move); j++){	
				if ((!elements[i][j].is_available() && elements[i-1][j].is_available()) || (elements[i][j].is_available() && elements[i-1][j].getValue() == elements[i][j].getValue())){
					//if the cell on the left is empty or has the same value, then you can move left
					can_move = true;
				}
				
			}
		}
		return can_move;	
	}
	
	public boolean can_move_down(){
		//Indicates whether the board would change through a down movement
		boolean can_move = false;
		for(int i = 1; (i<(ROWS-1) && !can_move); i++){
			for(int j = 0; (j < COLUMNS && !can_move); j++){	
				if ((!elements[i][j].is_available() && elements[i+1][j].is_available()) || (elements[i][j].is_available() && elements[i+1][j].getValue() == elements[i][j].getValue())){
					//if the cell on the left is empty or has the same value, then you can move left
					can_move = true;
				}
				
			}
		}
		return can_move;
	}
	
	public boolean is_winning_board(){
		//Indicates whether 2048 is present in the board, indicating that the board is a winning board
		boolean is_winning = false;
		for(int i = 1; (i<(ROWS-1) && !is_winning); i++){
			for(int j = 0; (j < COLUMNS && !is_winning); j++){	
				if (elements[i][j].getValue()==2048){
					//if the cell on the left is empty or has the same value, then you can move left
					is_winning = true;
				}	
			}
		}
		return is_winning;
	}

	public void set_cell(int row, int col, int v){
		//Set cell in [row,col] position with a given value require
		if (0<=row && row<ROWS && 0<col && col<COLUMNS && (new Cell_2048()).is_power_of_two(v)){
			elements[row][col].setValue(v);
		}
		else
			throw new IllegalArgumentException();
	}
}
