package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S4_1337_2 {
    //ArrayList의 contains() 메서드는 요소를 찾기 위해 전체를 순회해야 하지만,
    //HashSet은 평균적으로 O(1)의 시간 복잡도로 요소를 검색할 수 있다.
    //그러므로 ArrayList 대신 HashSet을 사용하면 시간 복잡도를 줄일 수 있다고 생각하여 변경
    //처음풀이에서 각 원소마다 더한 값을 각각 확인하도록 풀이하였는데
    //이를 줄이기 위해 한 번의 반복으로 처리할 수 있다.

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(bf.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(bf.readLine()));
        }

        int maxCount = 0;

        // 1부터 5까지의 값이 모두 존재하는지 확인
        for (int i : set) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (set.contains(i + j)) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        // 필요한 값의 개수는 5에서 가장 많이 존재하는 개수를 뺀 값
        System.out.println(5 - maxCount);
    }
}
