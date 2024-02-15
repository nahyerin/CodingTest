import java.io.*;
//총 점의 개수 = (2^n + 1)^2 => (2의 n승 + 1)의 제곱 -> 2의 0승은 1이지만 초기는 2가 나와야하고 2의 1승은 2이지만 첫번째는 3이 나와야함 (+1)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
		br.close();
        
        // Math의 클래스의 pow()메서드
        // Math.pow(거듭제곱할 숫자, 거듭제곱(몇제곱);
        System.out.println((int)Math.pow(Math.pow(2, n) +1, 2));
    }
}