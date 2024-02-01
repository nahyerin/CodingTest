import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor==0) { 
                list.add(arr[i]);  
            }
        }
        Collections.sort(list);   
        Integer[] answerInt =  list.toArray(new Integer[list.size()]);  
        if(answerInt.length==0) {   
            answer=new int[1];
            answer[0]=-1;
        }else {  
            answer=Arrays.stream(answerInt).mapToInt(Integer::intValue).toArray(); 
        }
        
        return answer;
    }
}
