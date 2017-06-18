/** RPN Calculator
 * @author sihancen
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		ArrayList<InputItem> s = new ArrayList<InputItem>();
		InputPhraser ip = new InputPhraser();
		StackReader sr = new StackReader();
		
		
        System.out.println("Weclocme to use RPN Calculator, press crl+c to terminate the program.");
        System.out.println("only number, +, -, *, /, sqrt, undo, clear are accepted, "
        		+ "invalid input will not have any effect on the result.");
        
		Scanner Input = new Scanner(System.in);
        while(Input.hasNextLine()){
        	// scan
            String inputStr = Input.nextLine();
            
            // phrase the input
            ip.listphrase(s, inputStr);
            
            sr.read(s);
        }
    }
}
