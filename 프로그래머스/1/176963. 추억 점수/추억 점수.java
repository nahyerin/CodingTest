import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        // 사진의 추억 점수를 담을 map
        Map<String, Integer> point = new HashMap<>();

        // 사진별 추억점수 map
        for (int i = 0; i < name.length; i++) {
            point.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            // 사진에 있는 사람들을 배열에 담기
            String[] person = photo[i];
            int score = 0;

            for (int j = 0; j < person.length; j++) {
                // 배열에 담긴 사진에 찍인 사람의 이름 순차적으로 꺼내기
                String personName = person[j];
                // containsKey메서드로 photo 배열을 순회하면서 각 이름이 point의 키로 존재하는지 확인
                // personName이 map에 key 값으로 하는 경우 해당 사람의 추억점수 더하기
                if (point.containsKey(personName)) {
                    score += point.get(personName);
                }

            }
            answer[i] = score;
        }

        return answer;
    }
}