package sudoku;

public class Sudoku_Board {
	
	//This matrix represents the sudoku board.
	Sudoku_Cell [][] cells;
	
	public Sudoku_Board(){
	// Initializes the board as empty
		int i,j;
		Sudoku_Cell cell; 
		cells =new Sudoku_Cell[10][10];
		
		for(i=0;i<=9;i++){
			for(j=0;j<=9;i++){
				cell=new Sudoku_Cell();
				cells[i][j] =cell;
			}
		}
		
		
		
	}
	
	
	public int cell_value (int row, int col){
		return cells[row][col].getValue();
	}
	
	public boolean cell_is_settable(int row, int col){
		return cells[row][col].isSettable();
	}
	
	public boolean is_complete(){
		//Return true iff the board is complete (all cells are seted with a nonzero value)
		int i,j; //indexes used to pass through the matrix of SUDOKU_CELL
		boolean filled = true;//flag that indicates if the current cell is filled with a nonzero value
		i =0;
		while(i<=9 && filled){
			j=0;
			while(j<=9 && filled){
				if (cell_value(i,j) == 0){
						filled = false;
				}	
				j++;
			}
			i++;
		}
			
		return filled;
	}
	
	
	
	public boolean is_valid(){
		// is the board valid (no conflicts so far)?
		return false;
	}
	
	public int count_seted_cells(){
		//count the cells that have been seted
		return 0;
	}
	
	public boolean set_cell (int row, int col, int value){
		// TODO:it returns true iff the value inserted in cell (row,col) 
		// does not produce a conflict in the board.
		return is_insertion_correct_in_row(row) && is_insertion_correct_in_col(col) && is_insertion_correct_in_square(row, col);
	}
	
	private boolean is_insertion_correct_in_row (int row){
		return false;
	}
	
	private boolean is_insertion_correct_in_col (int col){
		return false;
	}
	
	private boolean is_insertion_correct_in_square(int row, int col){
		return false;
	}
}
