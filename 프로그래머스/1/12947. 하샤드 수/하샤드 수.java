class Solution {
    public boolean solution(int x) {
        String str = Integer.toString(x);
        char[] ch = new char[str.length()];
        int sum = 0;
        boolean answer = true;
        
        for(int i=0; i<str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        for(int i = 0; i < ch.length; i++){
            sum+= Character.getNumericValue(ch[i]);
        }
        
        if(x%sum == 0){
            answer = true;
        } else{
            answer = false;
        }
        return answer;
    }
}