import java.io.*;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        //N%B가 10보다 크다 = 10진수 이상의 수 -> N을 B로 나눈 나머지값에 +'A'를 더한 뒤 10을 빼주면 원하는 값
        //아스키코드를 char형으로 변환해서 StringBuilder에 담기
        //10보다 크지 않으면 그냥 N%B를 담기 (아스키코드 연산이 없으니 형변환을 안함)
        while(N != 0){
            if(N%B >= 10) sb.append((char)((N%B)+'A'-10));
            else sb.append(N%B);
            N/=B;
        }
        //StringBuilder제공 reverse 메소드 사용, char형 toString메소드를 통해 String으로 변환하여 출력
        System.out.print(sb.reverse().toString());
        br.close();
    }
}