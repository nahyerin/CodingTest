import java.util.Stack;
 
public class Solution {
  
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
    }
 
    public static int solution(String s) {
        int answer = 0;
 
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s);
            // 맨 앞의 문자열을 맨 뒤로 옮겨 회전
            String rotation = str.substring(0, i);
            str.delete(0,i);
            str.append(rotation);
 
            if(checkStr(str)){
                answer += 1;
            }
        }
        return answer;
    }
    // 회전한 문자열을 확인
    public static boolean checkStr(StringBuilder str) {
        Stack<Character> stack = new Stack<>();
        //stack이 비었다면 문자열(str)을 i 번째 문자열을 삽입
        //비어 있지 않다면 문자열의 i번째와 그 앞에 있는 문자가 올바른 쌍인지 확인하고, 올바른 쌍이라면 넣었던 문자를 제거
        //비어 있지 않지만 문자열의 i번째와 그 앞에 있는 문자가 올바른 쌍이 아니라면, 문자열의 i번째 문자를 삽입합니다.
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {      
                if (c == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else if (c == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else if (c == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
       
       //반복문이 종료되고 완성된 stack이 비었다면 모든 괄호가 올바른 쌍으로 이뤄져있으므로 true를, 아니라면 false를 반환
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}