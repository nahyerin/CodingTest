import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//하나의 원소에 대해, 배열에 원소, 원소+1, 원소+2, 원소+3, 원소+4 값이 각각 존재하는지를 체크

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //1. 입력
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        //2. 정렬
        Collections.sort(list);

        //3. 확인
        ArrayList<Integer> max = new ArrayList<>();
        for(int i=0;i<N;i++) {
            int count = 0;
            if(list.contains(list.get(i)))count++;
            if(list.contains(list.get(i)+1))count++;
            if(list.contains(list.get(i)+2))count++;
            if(list.contains(list.get(i)+3))count++;
            if(list.contains(list.get(i)+4))count++;
            max.add(count);
        }
        Collections.sort(max, Collections.reverseOrder());
        System.out.println(5-max.get(0));
    }
}