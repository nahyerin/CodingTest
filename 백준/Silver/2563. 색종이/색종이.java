import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//boolean 타입 이중 배열 -> 100, 100인 흰색 도화지
//색종이 갯수를 입력 받은만큼 반복문, 반복문 안에서는 색종이와 벽에서의 x 거리와 y 거리를 입력받고 이중 for문을 생성
//입력받은 x에서 색종이의 크기를 더한 x + 10까지 반복하고, y는 y + 10까지 반복하도록 하여 boolean이 false인 것만 true로 바꿔준다
//백지 도화지에 색종이를 붙이지만 겹치는 부분은 자동으로 배제되어 색종이 영역의 넓이 구하기


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int x = 0;
        int y = 0;
        int totalArea = 0;
        boolean[][] paper = new boolean[100][100];

        for (int i = 0; i < count; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            x = Integer.parseInt(stringTokenizer.nextToken());
            y = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;
                        totalArea++;
                    }
                }

            }
        }
        System.out.println(totalArea);
    }
}
