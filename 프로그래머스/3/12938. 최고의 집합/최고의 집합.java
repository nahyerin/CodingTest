class Solution {
    public int[] solution(int n, int s) {
        if(n>s){ // 합이 S가 되는 n개의 원소를 가진 집합이 존재하지 않는 경우
            return new int[] {-1};
        }
        int[] answer = new int[n];
        
        if(s%n==0){ //나눠지는 경우
            for(int i=0; i<n; i++){
                answer[i] = s/n; //가능한 작은 수부터 차례로 집합에 추가
            }
        }else{ 
            int remainder = s%n; //나머지를 계산하여 나중에 추가
            int po = n - remainder; //1씩 더해줘야하는 인덱스 위치
            for(int i=0; i<po; i++){
                answer[i] = s/n;//po까지는 원래대로 추가
            }
            for(int i=po; i<n; i++){
                answer[i] = s/n+1;//po부터 n까지는 1씩 추가
            }
        }
        return answer;
    }
}