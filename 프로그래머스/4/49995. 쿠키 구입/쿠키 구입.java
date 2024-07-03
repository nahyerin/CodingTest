class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for (int m=1;m<cookie.length;m++) {
            int i = m - 1;
            int r = m;
            int fir = cookie[i];
            int sec = cookie[r];
            
            while (true) {
                if (fir == sec) {
                    if (answer < fir) answer = fir;
                }
                
                if (fir <= sec && i > 0) {
                    i --;
                    fir += cookie[i];
                } else {
                    if (fir >= sec && r < cookie.length - 1) {
                        r ++;
                        sec += cookie[r];
                    } else break; 
                } 
            }
        }
        
        return answer;
    }
}