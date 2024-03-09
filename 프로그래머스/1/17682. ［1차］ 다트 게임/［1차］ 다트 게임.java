class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3]; 
        int idx = -1; 

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            // 숫자인 경우
            if (Character.isDigit(c)) {
                idx++;
                // '10'의 경우 10점으로 처리하여 score 배열에 저장
                if (c == '1' && dartResult.charAt(i + 1) == '0') {
                    score[idx] = 10;
                    i++; // 다음 문자도 처리했으므로 인덱스 증가
                } else {
                    // 숫자인 경우 해당 값을 정수로 변환하여 score 배열에 저장
                    score[idx] = c - '0';
                }
                
            // 문자인 경우
            } else if (c == 'D') {
                // 'D'는 해당 라운드의 점수를 2제곱하여 score 배열에 저장
                score[idx] *= score[idx];
            } else if (c == 'T') {
                // 'T'는 해당 라운드의 점수를 3제곱하여 score 배열에 저장
                score[idx] *= score[idx] * score[idx];
            } else if (c == '*') {
                // '*'는 해당 라운드의 점수를 2배로 만들고, 이전 라운드의 점수도 2배로 만듦
                score[idx] *= 2;
                if (idx - 1 >= 0) {
                    score[idx - 1] *= 2;
                }
            } else if (c == '#') {
                // '#'는 해당 라운드의 점수를 음수로 만듦
                score[idx] *= -1;
            }
        }

        // 총점수
        return score[0] + score[1] + score[2];
    }
}