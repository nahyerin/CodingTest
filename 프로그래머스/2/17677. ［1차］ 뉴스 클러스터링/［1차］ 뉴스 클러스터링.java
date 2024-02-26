import java.util.HashMap;
import java.util.LinkedList;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
        int answer = 0;
        HashMap<String, Integer> hashmap1 = new HashMap<>();
        HashMap<String, Integer> hashmap2 = new HashMap<>();
        LinkedList<String> que = new LinkedList<>();
        
        for(int i = 0; i < str1.length()-1; i++) {
        	char a = str1.charAt(i);
        	char b = str1.charAt(i+1);
        	if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
        		String temp = a+""+b;
        		if(!hashmap1.containsKey(temp)) {
        			que.add(temp);
        		}
        		hashmap1.put(temp, hashmap1.getOrDefault(temp, 0)+1);
        	}
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
        	char a = str2.charAt(i);
        	char b = str2.charAt(i+1);
        	if(a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
        		String temp = a+""+b;
        		if(!hashmap1.containsKey(temp) && !hashmap2.containsKey(temp)) {
        			que.add(temp);
        		}
        		hashmap2.put(temp, hashmap2.getOrDefault(temp, 0)+1);
        	}
        }
        
        double intersection = 0;
        double union = 0;
        
        while(!que.isEmpty()) {
        	String temp = que.poll();
        	int num1 = 0, num2 = 0;
        	if(hashmap1.containsKey(temp))
        		num1 = hashmap1.get(temp);
        	if(hashmap2.containsKey(temp))
        		num2 = hashmap2.get(temp);
        	
        	intersection += Math.min(num1, num2);
        	union += Math.max(num1, num2);
        }
        
        if(intersection == 0 && union == 0) {
        	return 65536;
        }
        
        answer = (int) (intersection * 65536 / union);
        
        return answer;
    }
}