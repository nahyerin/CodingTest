import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
    	// 결과를 담을 배열
        int[] answer = new int[score.length];
        
        // 순위를 담을 List
        List<Integer> rank = new ArrayList<>();
        
        // score를 반복
        for (int i = 0; i < score.length; i++) {
            // score 추가
            rank.add(score[i]);
            //rank의 사이즈가 k보다 클 경우 rank에 존재하는 점수 중 가장 작은 점수를 제거
            if (rank.size() > k) {
                rank.remove(Collections.min(rank));
            }
            
            answer[i] = Collections.min(rank);
        }
        return answer;
    }
}