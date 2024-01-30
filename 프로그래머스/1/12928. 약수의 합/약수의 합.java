class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i=1;i*i<=n;i++){
            if(n%i==0){
                if(i*i==n) answer +=i;
                else answer += i+(n/i);        
            }
        }
        return answer;
    }
}