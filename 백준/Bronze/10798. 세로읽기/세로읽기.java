import java.io.*;

public class Main {
    //2차원 배열 문자열을 받고 그 배열을 세로로 한 열씩 읽기
    //값이 비어있으면 건너뛰고 다음 행의 같은 열의 값을 출력
    //(다섯줄을 입력 받는다고 나와있지만 입력 받을 문자의 길이는 1부터 15까지로 정해져있지 않음)
    //-> char형 배열 charAt을 이용해서 한 자씩 배열에 넣고 for문으로 세로로 출력
    //    (열의 크기를 15로 선언했으므로 값이 없는 열은 null인지 체크하고 출력)
    
    public static void main(String[] rgs) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

        char arr[][] = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String str = bfr.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                bfw.write(String.valueOf(arr[i][j]));
            }
        }

        bfr.close();
        bfw.flush();
        bfw.close();
    }
}