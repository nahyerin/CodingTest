import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        // 9x9 크기의 배열을 선언
        int arrays[][] = new int[9][9];

        // 입력된 숫자 배열에 저장
        for(int i = 0; i < 9; i++){
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arrays[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        br.close();

        // 최댓값을 저장할 변수 초기화
        int max = 0;

        // 배열 순회하며 최댓값 찾기
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(max < arrays[i][j]){
                    max  = arrays[i][j];
                }
            }
        }

        // 최댓값 출력
        System.out.println(max);

        // 최댓값의 위치 출력
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(arrays[i][j] == max){
                    System.out.println((i+1) + " " + (j+1));
                    return; // 최댓값의 위치를 찾으면 종료
                }
            }
        }
    }
}
