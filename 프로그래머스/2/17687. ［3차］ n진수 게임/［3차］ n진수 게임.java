import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        
        //10진수 0부터시작, 총있어야 숫자의 개수 
        int num = 0 , len = t*m;
        
        //n진수로 변환 후 sb에 붙여주기.
        while(sb.length()<len) {
            //16진수일 경우 A~F는 소문자로 나오기때문에 대문자로 고쳐주기위한 toUpperCase() 사용한다.
        	String temp = Integer.toString(num,n).toUpperCase();
        	sb.append(temp);
        	num++;
        }
        
        String str = sb.substring(0, len);
        
        //p번째(인덱스로는 p-1번째)부터 시작해서 m번재 마다 읽어준다.
        for(int i=p-1; i<str.length(); i+=m) {
        	char ch = str.charAt(i);
        	answer.append(ch);
        }
        return answer.toString();

    }
}