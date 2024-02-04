class Solution {
  public int[] solution(int n, int m) {
        int gcd = getGcd(Math.min(n, m), Math.max(n, m));

        return new int[] {gcd, (n * m) / gcd};
    }

    public int getGcd(int min , int max) {
        return max % min != 0 ? getGcd(max % min, min) : min ;
    } // 유클리드 호제법 원리를 이용한 재귀함수
}