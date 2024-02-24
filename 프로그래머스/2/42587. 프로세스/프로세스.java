import java.util.*;

class Solution {
    // PriorityQueue 우선순위 큐 사용
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int num : priorities) {
			pq.add(num);
		}
		while(!pq.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == pq.peek()) {
					pq.poll();
					answer++;
					if(i == location)
						return answer;
				}
			}
		}  
        return answer;
    }
}