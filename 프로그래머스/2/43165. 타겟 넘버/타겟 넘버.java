import java.util.*;


class Solution {


    public int solution(int[] numbers, int target) {
        Queue<Status> que = new LinkedList<Status>();
        int[] cal = {1, -1}; // 합, 차를 담는 배열
        int method =0; // 방법의 갯수를 담는 변수
        
         for(int i=0; i< cal.length; i++){
				//첫 노드 = > 1* numbers[0] 
                //첫 노드 = > -1* numbers[0]
                // que에 넣는다
                int newSum =  cal[i]*numbers[0];
                que.add(new Status(newSum, 0));
            }

        
        while(!que.isEmpty()){
            Status st =que.poll();
            
            // 만약 이미 모든 노드를 탐방했다면
            if(st.count==numbers.length -1) {
                // 타겟과 현재까지의 sum이 같은지 확인, 같다면 method ++
                if(st.sum == target) method++;
                continue;
                
            }
            
            // 만약 모든 노드를 탐방하지 않았다면
            // 그 다음 자식 노드들 다시 탐방 (합, 차 노드)
            for(int i=0; i< cal.length; i++){
                int newSum = st.sum + cal[i]*numbers[st.count+1];
                que.add(new Status(newSum, st.count+1));
            }
            
        }  
        
        return method;
    }
}
  
class Status{
    int sum; // 현재까지 합
    int count; // 몇번째까지 더했는지, 인덱스
    
    public Status(int sum, int count){
        this.sum =sum;
        this.count =count;
    }
    
}