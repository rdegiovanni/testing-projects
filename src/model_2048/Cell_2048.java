package model_2048;

public class Cell_2048 {

	//	Returns the value stored in the cell
	//	When the value is zero, it means that the
	//	cell is not set.
	//	Value should otherwise be a power of two (greater than one)
	private int value;
	
	public Cell_2048() {
		 //  Cell should be unset
		value=0;
	}
	
	public Cell_2048(int v) {
		if(is_valid_value(v))
			value = v;
		else
			throw new IllegalArgumentException("The value should be 0, or greater than 1 and power of 2.");
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		if(is_valid_value(v))
			value = v;
		else
			throw new IllegalArgumentException("The value should be 0, or greater than 1 and power of 2.");
	}

	public boolean is_valid_value (int v){
		//Returns true if value is either 0, or a power of two
		//greater than 1.
		return (v==0) || (v>1 && is_power_of_two(v));
	}
	
	public boolean is_power_of_two (int v){
		if (v > 0) {
			boolean power_of_two = true;
			for (int i=v; (i <= 1 || !power_of_two); i=i%2){
				if (i % 2 != 0)
				power_of_two = false;
			
			}
			return power_of_two;
		}
		else
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
