import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        br.close();
        int squareCount = 1; // 해당 대각선(순회하는 대각선)에 있는 칸
        int squareSum =  0; // 해당 대각선의 전 대각선 칸을 누적 더하기 저장
        while(true){
            if(X <= squareSum + squareCount){
                if(squareCount % 2 == 1){ 
                    System.out.println((squareCount-(X - squareSum -1) + "/" + (X - squareSum)));
                    break;
                }else{ //(해당 대각선의 칸의 개수가 짝수, 분자+분모(T) = 홀수)
                    //대각선의 개수가 짝수인 범위 내에서는 아래쪽(↙︎︎) 으로 순회 -> 분자 증가, 분모 감소
                    System.out.println((X - squareSum) + "/" + (squareCount-(X - squareSum -1)));
                    break;
                }
            }else{ //아직 X번째 분수가 해당 대각선에 포함하지 않는 경우
                squareSum += squareCount;
                squareCount++; 
            }
        }

    }
}