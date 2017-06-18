package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackReader {
	private final String ADD = "+";
	private final String MINUS = "-";
	private final String MULTIPLY = "*";
	private final String DIVIDE = "/";
	private final String SQRT = "sqrt";
	private final String UNDO = "undo";
	private final String CLEAR = "clear";
	
	private Calculator c = new Calculator();
	
	public StackReader(){
		
	}
	
	/** read the input and handle different operator
	 * @param s input String
	 */
	public void read(ArrayList<InputItem> s){
		
		// handle the undo and clear command
		try{
			this.undo_clear(s);
		}
		catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("stack: ");
			return;
		}
		
		Stack<String> sta = new Stack<String>();
		
		for(int i=0; i<s.size(); i++){
			try{
				Double.parseDouble(s.get(i).getValue());
				sta.push(s.get(i).getValue());
			}
			catch (NumberFormatException e){
				try{
					switch (s.get(i).getValue()){
					case ADD:
						c.add(sta);
						break;
					case MINUS:
						c.minus(sta);
						break;
					case MULTIPLY:
						c.multiply(sta);
						break;
					case DIVIDE:
						c.divide(sta);
						break;
					case SQRT:
						c.sqrt(sta);
						break;
					default:
						break;
					}
				}
				catch (EmptyStackException ese){
					System.out.println("operator "+ s.get(i).getValue() + " (position: "
				+ s.get(i).getIndex() +"): insucient parameters");
					s.clear();
					break;
				}
			}
		}
		
		print_result(sta);
	}
	
	/** remove the undo and previous element of the undo, 
	 * remove all the element before clear and includes clear
	 * @param s input String
	 */
	private void undo_clear(ArrayList<InputItem> s){
		int error_i=0; // index of error item
		try{
			for(int i=0; i<s.size(); i++){
				if(s.get(i).getValue().equals(UNDO)){
					error_i = i;
					s.remove(i);
					s.remove(i-1);
					// reset the index as the index was changed after remove
					i = 0;
				}
			}
		}
		// in case the undo is the first item
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("operator UNDO (position: "+ error_i +"): insucient parameters");
			s.clear();
			throw new ArrayIndexOutOfBoundsException();
		}
		
		// handle the clear command
		int clear_i = 0;
		for(int i=0; i<s.size(); i++){
			if(s.get(i).getValue().equals(CLEAR)){
				clear_i = i;
				s.subList(0, clear_i+1).clear();
				break;
			}
		}
		
	}
	
	/** print stack
	 * @param sta Stack
	 */
	private void print_result(Stack<String> sta){
		System.out.print("stack: ");
		for(String i: sta){
			// print the integer
			if (Double.parseDouble(i) == (int)(Double.parseDouble(i)))
			{
				System.out.print((int)(Double.parseDouble(i)) + " ");
			}
			// round the number for big decimal number and double
			else{
				double v = Double.parseDouble(i);
				BigDecimal bigv = new BigDecimal(v);
				double v1 = bigv.setScale(10, RoundingMode.HALF_UP).doubleValue();
				System.out.print(v1 + " ");
			}
		}
		System.out.print("\n");
	}
}
