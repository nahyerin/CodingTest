class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (measure(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    public int measure(int num) {
        int count = 0;
        
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (i * i == num) count ++;
            else if (num % i == 0) count += 2;
        }
        
        return count;
    }
}