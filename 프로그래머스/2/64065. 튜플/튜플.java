import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
    }
     // { 제거 -> 정규식
    // s의 맨끝의 "}}"를 제거하고, "},"를 기준으로 배열(sArr)을 만들기
    // result에 들어가는 수의 순서 맞추기 ->  배열(sArr)를 배열의 길이 순으로 오름차순 정렬
    public static int[] solution(String s) {
        s = s.replaceAll("\\{", "");
        String[] sArr = s.substring(0, s.length() - 2).split("\\}\\,");
        Arrays.sort(sArr, Comparator.comparingInt(String::length));
 
        HashSet<Integer> duplicate = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        //중복을 제거하기 위해 Set 클래스를 생성하고 튜플의 원소를 담을 ArrayList 클래스를 생성 (이미 컬렉션 클래스를 사용해 배열 대신 ArrayList 사용)
        for (int i = 0; i < sArr.length; i++) {
            int[] tuple = Stream.of(sArr[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int num : tuple) {
                
                //중복된 값이 없다면 result에 해당 원소를 추가
                if (!duplicate.contains(num)) {
                    result.add(num);
                }
                duplicate.add(num);
            }
        }
        
        //완성된 result를 함수 반환 타입 int[]에 맞춰 변경
        int[] answer = new int[result.size()];
 
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
    
        return answer;
    }
}
