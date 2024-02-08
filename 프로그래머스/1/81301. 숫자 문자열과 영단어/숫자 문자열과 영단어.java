class Solution {
    public int solution(String s) {
        
    	//영단어를 담는 String 타입의 배열 생성 영단어와 배열의 인덱스값 동일함.
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        //모든 영단어 검사, 문자열 s에 영단어가 있다면 replace를 사용해 변환한다.
        for(int i=0;i<arr.length;i++) {
        	if(s.contains(arr[i])) {
        		s = s.replace(arr[i], Integer.toString(i));
        	}
        }
        return Integer.parseInt(s);
    }
}