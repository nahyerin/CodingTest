import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0; 
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            // 값이 없으면 0, 있으면 + 1을 진행하여 HashMap에 저장
        }
        ArrayList<Integer> valueList = new ArrayList<>(map.values());
        // 내림차순 정렬
        Collections.sort(valueList, Collections.reverseOrder());
        for (int v : valueList) {
            if (sum + v >= k) {
                cnt++;
                break;
            } else {
                sum += v;
                cnt++;
            }
        }
        return cnt;
    }
}