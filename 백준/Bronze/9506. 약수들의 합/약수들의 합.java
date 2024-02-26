import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            int[] array = new int[n];

            int sum = 0;

            for (int i = 1; i <= n; i++) {
                if (n % i == 0 && i != n) {
                    array[i] = i;
                    sum += i;
                }
            }

            //완전수가 아닐 경우
            if (sum != n) { 
                sb.append(n+ " is NOT perfect. \n");
                continue; //완전수가 아니기때문에 밑의 코드는 수행 X
            }

            sb.append(n + " = 1"); //1의 약수는 무조건 추가
            for(int i = 1; i <= n; i++){ //약수의 최대 몇개 인지 알고 있기 때문에 index만큼 반복문
                if(array[i-1] != 0 && array[i-1] != 1){ 
                    sb.append(" + " + array[i-1]);
                }

            }
            sb.append("\n");

        }
        br.close();
        System.out.println(sb);
    }

}