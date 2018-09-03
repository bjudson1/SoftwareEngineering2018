package homework1;

public class Question3 {
	public Question3(){}
	
	public int getMirrorCount(int[] input_list) {
	    int max = 0;
	    
	    //find the largest mirror
	    for(int i=0; i<input_list.length; i++){
	        int count = 0;
	        int j = input_list.length - 1;
	        
	        while(j >= 0 && i+count < input_list.length){
	            if(input_list[i + count] == input_list[j]) {
	                count++;
	            } 
	            
	            else{
	                max = Math.max(max, count);
	                count = 0;
	            }
	            
	            j--;
	        }
	                                                                
	        max = Math.max(max, count);
	    }

	    return max;
	}
}
