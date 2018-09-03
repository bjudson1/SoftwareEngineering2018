package homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Question2 {
	public Question2(){}
	
	public String getMostFrequentWord(String input_string, String stop_string){
		HashMap<String,Integer> count_map = new HashMap<String,Integer>();
		String [] input_words = input_string.split(" ");
		List<String> stop_words = Arrays.asList(stop_string.split(" "));
		
		//create map of the counts
		for(int i=0;i<input_words.length;i++){
			//dont count stop words
			if(!stop_words.contains(input_words[i])){
				if(count_map.get(input_words[i]) == null){
					count_map.put(input_words[i], 1);
				}
				
				else {
					count_map.put(input_words[i], count_map.get(input_words[i]) + 1);
				}
			}
		}
		
		int max_value = 0;
		String max_key = null;
		
		//find the key for the max value
		for(HashMap.Entry<String,Integer> entry : count_map.entrySet()){
			if(entry.getValue() > max_value){
				max_value = entry.getValue();
				max_key = entry.getKey();
			}
			
			else if(entry.getValue() == max_value) {
				max_key = null;
			}
		}
		
		return max_key;
	}
}
