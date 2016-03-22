package model_2048;

public class Cell_2048 {

	//	Returns the value stored in the cell
	//	When the value is zero, it means that the
	//	cell is not set.
	//	Value should otherwise be a power of two (greater than one)
	int value;
	
	public Cell_2048() {
		//  TODO: Create a new cell with default value
		//  Cell should be unset
	}
	
	public Cell_2048(int v) {
		//  TODO: creates a cell initialized with a user-provided value
	}
	
	public boolean is_valid_value (int v){
		//Returns true if value is either 0, or a power of two
		//greater than 1.
		return (v==0) || (v>1 && is_power_of_two(v));
	}
	
	public boolean is_power_of_two (int v){
		//TODO:Returns True if val is power of 2
		return false;
	}
	
	public boolean is_available(){
		//Returns true if a cell is available, that is that value is 0.
		return (value==0);
	}
	
	public String toString(){
	// Provides a string representation of a cell (shows its value as a string)
		return Integer.toString(value);
	}
}
