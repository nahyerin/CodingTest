import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
    //1. 약관의 유효기간을 매핑한다.
    // - termMap : ["A", "6"]
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String [] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }
    //2. 각 개인정보의 유효기간 종료일을 계산한다.
        List<Integer> expiredList = new ArrayList<>();
        //정규표현식 구분자
        String [] todayParts = today.split("\\.");
        
        int todayYear = Integer.parseInt(todayParts[0]);
        int todayMonth = Integer.parseInt(todayParts[1]);
        int todayDay = Integer.parseInt(todayParts[2]);
        
        for(int i =0; i <privacies.length; i++){
            String[] info = privacies[i].split(" ");
            String[] dateParts = info[0].split("\\.");
            
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);
            
            int calcYear = year;
            int calcMonth = month + termMap.get(info[1]);
            int calcDay = day;

            while (calcMonth > 12) {
                calcYear += 1;
                calcMonth -= 12;
            }

            if (calcYear < todayYear || (calcYear == todayYear && calcMonth < todayMonth) ||
            (calcYear == todayYear && calcMonth == todayMonth && calcDay <= todayDay))
             {
                expiredList.add(i + 1);
            }

        }
        
        int[] result = new int[expiredList.size()];
        for(int i =0; i<expiredList.size(); i++){
            result[i] = expiredList.get(i);
        }
        
        return result;
    }
}