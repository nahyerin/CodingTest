import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        // 내림차순 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 배열값
        for (int i = 0; i < works.length; i++) {
            queue.add(works[i]);
        }
        
        while (n > 0) {
            // 가장 큰 수가 0이면 탐색중단
            if (queue.peek() == 0) {
                break;
            }
            queue.add(queue.poll() - 1);
            n--;
        }
        
        // 큐에 있는 값 제곱해서 더하기
        while (!queue.isEmpty()) {
            answer += Math.pow(queue.poll(), 2);
        }
        return answer;
    }
}