package sudoku;

public class Sudoku_Cell {
	private int value;
	// Value of the cell. When set, contains a valid value between 1 and 9

	private boolean settable;
	// field that indicates if cell is settable. You can't change cell that has been initialized at beginning

	public Sudoku_Cell(){
	// Default constructor of class.
	// Makes the cell "empty", i.e., unset.
		value = 0;
		settable = true;
	}
	
	public Sudoku_Cell(int new_value){
	// Initializes the cell set with new_value
	//require !is_settable & new_value > 0 & new_value < 10
		value = new_value;
	}
	
	public boolean is_set() {
	// Indicates if this cell is set.
		return (value != 0);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isSettable() {
		return settable;
	}

	public void setSettable(boolean settable) {
		this.settable = settable;
	}
}
