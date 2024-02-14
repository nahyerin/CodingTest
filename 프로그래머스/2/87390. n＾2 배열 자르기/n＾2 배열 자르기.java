import java.util.Arrays;
 
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }
 
    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
       
        int idx = 0;
        for (long i = left; i <= right; i++) {
            //행
            long row = i / n + 1;
             //열 : 해당 인덱스 % n + 1
            long col = i % n + 1;
            answer[idx++] = (int) Math.max(row, col);
        }
 
        return answer;
    }
}