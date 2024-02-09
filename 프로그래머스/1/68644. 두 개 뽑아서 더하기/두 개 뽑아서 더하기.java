import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        // 배열의 모든 두 요소의 합을 구하기 위한 이중for문
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
            	// 두 요소의 합이 list에 존재하지 않은 경우 (담기)
                if (!list.contains(numbers[i] + numbers[j])) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }

        // list를 오름차순 정렬하며 변환
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}