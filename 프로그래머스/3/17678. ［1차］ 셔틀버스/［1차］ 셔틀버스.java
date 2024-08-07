import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        //콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각을 구하여라.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time:timetable){
            pq.add(convertToTime(time));
        }
        
        int departureTime = 9*60;
        List<List<Integer>> bus = new ArrayList<>();
        for(int i=0; i<n; i++)
            bus.add(new ArrayList<>());
        
        int ans = 0;
        for(int i=0; i<n; i++){
            while(!pq.isEmpty()){
                int crew = pq.poll();
                //버스 출발 시간보다 일찍 왔고, 버스 인원이 아직 다 차지 않았다면
                if(bus.get(i).size() < m && crew<=departureTime){
                    bus.get(i).add(crew); //버스에 탈 수 있음 
                    ans = crew - 1; //마지막 탑승자라면 그 탑승자보다 빨리 와야 사무실로 갈 수 있음
                }
                else{
                    pq.add(crew);
                    break;
                }   
            }
            departureTime += t;
        }
        
        //마지막 버스에 자리가 남으면 그 버스의 출발시각에 도차하면 됨
        if(bus.get(n-1).size() < m){
            ans = departureTime - t;
        }
        
        answer += converToString(ans);
        
        return answer;
    }
    
    static int convertToTime(String s){
        String[] arr = s.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return hour*60+min;
    }
    
    static String converToString(int time){
        String hour = String.format("%02d", time/60);
        String min = String.format("%02d", time%60);
        return hour+":"+min;
    } 
}