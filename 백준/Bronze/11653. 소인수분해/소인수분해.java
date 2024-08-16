import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

        if(N == 1){
            return;
        }

        for(int i = 2; i <= N; i++){
            while(N%i == 0){
                N /= i;
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}