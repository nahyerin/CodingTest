import java.util.*;

class Solution {
    
    // 팩토리얼을 구하기 위한 함수입니다. 
    long factorial(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
    
    // k 와 Factorial(n) 사이의 관계를 나타내기 위한 함수입니다. 
    // 몫과 나머지를 반환합니다. 
    long[] getQuotientAndRemainder (int n, long k) {
        long factorialNumber = factorial(n);
        long quotient = k / factorialNumber;
        long remainder = k % factorialNumber;
        return new long[]{quotient, remainder};
    }
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> sequence = new ArrayList();
        // 초기화 
        for (int i = 0; i < n; i++) {
            sequence.add(i + 1);
        }
        
        // 0번부터 인덱싱하기 위하여 1을 뻄.
        k--;
        int index = 0;
        
        while (!sequence.isEmpty()) {
            
            // n 수열은 n! 개의 수열을 가집니다. 
            // 첫번째 값을 알아내기 위해서 k 와 factorial(n - 1) 의 관계를 알아야합니다. 
            long[] quotientAndRemainder = getQuotientAndRemainder(n - 1, k);
            long quotient = quotientAndRemainder[0];
            long remainder = quotientAndRemainder[1];
            
            int value = sequence.get((int) quotient);
            sequence.remove((int) quotient);
            answer[index] = value;
            k = remainder;
            index++;
            n--;
        }

        return answer;
    }
}