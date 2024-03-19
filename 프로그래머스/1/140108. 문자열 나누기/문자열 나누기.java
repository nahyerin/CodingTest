class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] charS = new char[s.length()];
        for(int i = 0; i<charS.length; i++) {
            charS[i] = s.charAt(i);
        }
        
        char start = charS[0];
        start = charS[0];
        int startCount = 1;
        int nextCount = 0;
        for(int i = 1; i<charS.length-1; i++) {
            if(start == charS[i]) {
                startCount++;
            } else nextCount++;
            if(startCount == nextCount) {
                System.out.println("s: " +startCount);
                System.out.println("n: " +nextCount);
                answer++;
                start = charS[i + 1];
                i += 1;
                startCount = 1;
                nextCount = 0;
            }
            if(i == charS.length) {
                answer++;
            }
            
        }
        answer++;
        return answer;
    }
}