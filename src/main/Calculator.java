package main;

import java.util.EmptyStackException;
import java.util.Stack;

public class Calculator {
	
	public Calculator(){
		
	}
	
	/** apply addition
	 * @param sta Stack
	 */
	public void add(Stack<String> sta){
		this.check_parameter_len(sta, 2);
		
		double num1 = Double.parseDouble(sta.pop());
		double num2 = Double.parseDouble(sta.pop());
		double result = num1 + num2;
		sta.push(Double.toString(result));
	}
	
	/** apply subtraction
	 * @param sta Stack
	 */
	public void minus(Stack<String> sta){
		this.check_parameter_len(sta, 2);
		
		double num1 = Double.parseDouble(sta.pop());
		double num2 = Double.parseDouble(sta.pop());
		double result = num2 - num1;
		sta.push(Double.toString(result));
	}
	
	
	/** apply multiplication
	 * @param sta Stack
	 */
	public void multiply(Stack<String> sta){
		this.check_parameter_len(sta, 2);
		
		double num1 = Double.parseDouble(sta.pop());
		double num2 = Double.parseDouble(sta.pop());
		double result = num1 * num2;
		sta.push(Double.toString(result));
	}
	
	/** apply division
	 * @param sta
	 */
	public void divide(Stack<String> sta){
		this.check_parameter_len(sta, 2);
		
		double num1 = Double.parseDouble(sta.pop());
		double num2 = Double.parseDouble(sta.pop());
		double result = num2 / num1;
		sta.push(Double.toString(result));
	}
	
	
	/** apply square root
	 * @param sta
	 */
	public void sqrt(Stack<String> sta){
		this.check_parameter_len(sta, 1);
		
		double num = Double.parseDouble(sta.pop());
		double result = Math.sqrt(num);
		sta.push(Double.toString(result));
	}
	
	/** check if the stack have sufficient item for calculation
	 * throw EmptyStackException if it is insufficient.
	 * @param sta Stack
	 * @param len minimal size
	 */
	private void check_parameter_len(Stack<String> sta, int len){
		if(sta.size() < len){
			throw new EmptyStackException();
		}
	}
}
