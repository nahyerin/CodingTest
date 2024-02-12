class Solution {
   public int solution(int[] list) {
    // 두 수의 곱 a * b = 최소공배수 * 최소공약수
    int answer = 0;
       int gcdnum = gcd(list[0], list[1]); //미리 0번, 1번 원소로 최소공약수
       answer = (list[0]*list[1])/gcdnum;
       
        if(list.length >=3) { 
            for(int i = 2; i < list.length; i++) {
                gcdnum = gcd(answer, list[i]);
                answer = (answer * list[i]) / gcdnum;
            }
        }

        return answer;
    }

    //최대 공약수
    private static int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
}