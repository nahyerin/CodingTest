class Solution {
    // 다이나믹 프로그래밍(DP)을 활용하여 시작점에서 주어진 n까지 멀리뛰기를 하는 방법의 수를 찾기
    // 동적 계획법 
    public long solution(int n) {
        // 길이가 2001인 dp 배열
        int[] dp = new int[2001];
        dp[1] = 1; 
        dp[2] = 2; 

        // i = 3부터 dp 길이까지 반복
        for (int i = 3; i < dp.length; i++) {
            // i - 2일 때 방법의 수 + i - 1일 때 방법의 수를 저장
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        return dp[n];
    }
}