package sudoku;

public class Sudoku_Board {
	
	//This matrix represents the sudoku board.
	Sudoku_Cell [][] cells;
	
	public Sudoku_Board(){
	// Initializes the board as empty
		int i,j;
		Sudoku_Cell cell; 
		cells =new Sudoku_Cell[9][9];
		
		for(i=0;i<9;i++){
			for(j=0;j<9;i++){
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
	
	
	public boolean set_cell (int row, int col, int value){
    
		cells[row][col].setValue(value);
		return is_insertion_correct(row,col);
    }
	

	//Description: this routine unsets the value of the cell at row "row" and column "col"
	//Require: the value of the cell is diferent from Void and value<=9 and value>=1
	//Ensure: the value of the cell is Void
	public void unset_cell (int row, int col){
    	cells[row][col].setValue (0);
		
	}

	
	
	public void define_not_settable(int row,int col){
		cells[row][col].setSettable(false);
	}

	
	
	
	
	
	public boolean is_complete(){
		//Return true iff the board is complete (all cells are seted with a nonzero value)
		int i,j; //indexes used to pass through the matrix of SUDOKU_CELL
		boolean filled = true;//flag that indicates if the current cell is filled with a nonzero value
		i =0;
		while(i<9 && filled){
			j=0;
			while(j<9 && filled){
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
		int i,j;
		boolean repeated = false;
		j=0;
		i=0;
		//first check all rows and columns.
		while(i<9 && !repeated){
			repeated= repeated_element_in_row(i) || repeated_element_in_col(i);
		    i++;
		}
		//now check sub boards valids in the main board.
        i=0;
        while(i < 9 && !repeated){
        	j= 0;
        	while(j < 9 && !repeated){
                repeated = this.repeated_elements_in_square(i,j);
                j= j + 3;
        	}
        	i = i + 3;
        }
        //valid if nothing is repeated
    	return !repeated;
	}
	
  	//is the board solved? (valid and complete)
	public boolean is_solved(){
		return is_complete() &&  is_valid();
	}
	
	
	


	//feature only for testing

	
	public int count_seted_cells(){
		//count the cells that have been seted
		int i,j, count;
		count=0;
		
		for(i=0;i<9;i++){
			for(j=0;j<9;j++){
				if(cell_value(i,j)!=0) {
					count++;
				}
			}
			
		}
		return count;
	}
	
	
	//Control for insertion

	//Description : this routine allows user to know if a cell's value is in conflicts with another cell's value in the board
	 public boolean is_insertion_correct (int row,int col){
	 //if insertion is correct in the line, the column and the square then it is definitely correct!
		return  is_insertion_correct_in_row(row,col) &&  is_insertion_correct_in_col(row,col) &&  is_insertion_correct_in_square(row,col);
	 }

	//Description : this routine allows user to know if a cell's value is in conflicts with another cell's value in the row
	public boolean is_insertion_correct_in_row (int row, int col){
		int cur_col;
		boolean insertion_correct;
	
		insertion_correct= true;
		cur_col = 0;
		while(cur_col < 9 && insertion_correct){
			// if a cell in the row has the same as the cell we are checking then insertion is not correct
			if (col != cur_col && cell_value(row,col) == cell_value(row,cur_col)){
				insertion_correct = false;
			}
			cur_col++;
		}
		return  insertion_correct;
	}

	//Description : this routine allows user to know if a cell's value is in conflicts with another cell's value in the column
	public boolean is_insertion_correct_in_col (int row,int col){
		int cur_row;
		boolean insertion_correct;
	
		insertion_correct= true;
		cur_row = 0;
		while(cur_row < 9 && insertion_correct){
		   // if a cell in the column has the same as the cell we are checking then insertion is not correct
			if (row != cur_row && cell_value(row,col) == cell_value(cur_row,col) ){
				insertion_correct = false;
			}
			cur_row++;
		}
		return insertion_correct;
	}

	//Description : this routine allows user to know if a cell's value is in conflicts with another cell's value in the actual square
	public boolean is_insertion_correct_in_square (int row_cell,int col_cell){
		int cur_row,cur_col;
		int row_square, col_square;
		boolean insertion_correct;
	
		insertion_correct= true;

		//coords of the square :
		row_square = (row_cell-1);//3)*3+1
		col_square = (col_cell-1);//3)*3+1
		
		//beginning row index of the square
		cur_row = row_square;
		while(cur_row <= row_square+2 &&  insertion_correct){
			//beginning column index of the square
			cur_col= col_square;
			while(cur_col <= col_square+2 && insertion_correct){
				//if a cell in the square has the same as the cell we are checking then insertion is not correct
				if ((row_cell != cur_row || col_cell != cur_col) &&  cell_value(row_cell,col_cell) == cell_value(cur_row,cur_col)) {
					insertion_correct = false;
				}
				cur_col ++;
			}
			cur_row ++;
		}
		return insertion_correct;
	}
	
	
	
	
	
	
	
	//Return true if there are repeated elements in each row
	private boolean repeated_element_in_row (int row){
		int i,j;//Index for the columns.
		boolean repeat=false; //True if repeating elements in row.
		i=0;
		while(i<9 && !repeat){
			if(this.cell_value(row, i)!=0){
				j=i+1;
			   	while(j<9 && !repeat){
			   		if (cell_value(row, i) == cell_value(row, j))
			   			repeat =true;
			   		j++;
			   	}
			}
			i++;
			
		}
		return repeat;
	}
		
	
	private boolean repeated_element_in_col (int col){
		int i,j;//Index for the columns.
		boolean repeat=false; //True if repeating elements in row.
		i=0;
		while(i<9 && !repeat){
			if(this.cell_value(i,col)!=0){
				j=i+1;
			   	while(j<9 && !repeat){
			   		if (cell_value(i,col) == cell_value(j,col))
			   			repeat =true;
			   		j++;
			   	}
			}
			i++;
			
		}
		return repeat;
	}
	
	//-- Return true if there are repeated elements in each row and in each col of square 3x3.
	 private boolean repeated_elements_in_square(int row, int col){
		int i, j, i_aux;
		int[] aux;
        boolean repeat;
		//Load sub_board in aux array.
		 i_aux= 0;
		 aux = new int[9];       
		 i= row;
		 while(i <= row + 2){
		     j= col;
		     while(j <= col + 2){
		            aux[i_aux]= cell_value(i, j);
		            j++;
		            i_aux++;
		     }
		     i++;
		  }
		  //Verify repeated elements in aux array.
		 repeat = false;
		 i = 1;
		 while(i < 9 && !repeat){
		      if (aux[i] != 0){
		           	//from the one after i to the last one no need to start at 0
		            j = i + 1;
		             while(j < 9 && !repeat){
		                if (aux[i] == aux[j]){
		                       repeat = true;
		                }
		                j++;
		             }
		      }
		     i++;
	 	}
		 return repeat;
		    
		 
	 }
	 
	 
	 public void print_sudoku(){
		int current_value, row, col;
		
		for(row = 0; row<9;row++){
			System.out.print("| ");
				for(col = 0; col<9;col++){
					current_value = cell_value(row,col);
					if (current_value == 0){
						System.out.print("  | ");
					}else{
						System.out.print(current_value + " | ");
					}
				}
				System.out.println(" ");
		}
	 }
	 
	
	
	
}
