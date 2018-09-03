package homework1;

import java.util.HashSet;

public class Question1 {
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] input_list) {
		int result = 0;
		HashSet<Integer> h = new HashSet<Integer>();
		
		for(int i=0; i<input_list.length; i++){
			//only count num once
			if(!h.contains(input_list[i])){
				h.add(input_list[i]);
				result+=input_list[i];
			}
		}
		
		return result;
	}
}