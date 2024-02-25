class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum =0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                	//배열 중 3개 더하기
                    sum = nums[i]+nums[j]+nums[k];
                    
                    //소수 찾기(소수이면 +1)
                    if(isPrime(sum)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
        
    private boolean isPrime(int num){
		//i=1부터가 아닌 이유는 1은 나눌 필요 없는 수
       	//나누어 떨어지면 소수가 아니므로 false
        for(int i=2; i<num; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }  
}