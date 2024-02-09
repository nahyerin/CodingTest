import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // i, j, k를 담은 배열 순회
        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            // 추출한 배열 오름차순 정렬
            Arrays.sort(temp);
            
            // k번째 수 answer 배열에 담기
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}