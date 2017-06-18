package main;

import java.util.ArrayList;

public class InputPhraser {
	
	public InputPhraser(){
		
	}
	
	/** push the new element in String into the ArrayList
	 * @param li ArratList
	 * @param s new input String
	 */
	public void listphrase(ArrayList<InputItem> li, String s){
		ArrayList<InputItem> new_s = this.stringphase(s);
		for (InputItem i: new_s){
			li.add(i);
		}
	}
	
	/** convert and split the input String into ArrayList<String> by the space
	 * @param s input String
	 * @return ArrayList<String>
	 */
	private ArrayList<InputItem> stringphase(String s){
		ArrayList<InputItem> result = new ArrayList<InputItem>();
		int in = 1;
		
		for(String i : s.split(" ")) {
			InputItem item = new InputItem(i, in);
			result.add(item);
			in = in + i.length() + 1;
		}
		return result;
	}
	
}
