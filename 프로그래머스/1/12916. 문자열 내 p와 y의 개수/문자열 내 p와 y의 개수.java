class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] str = new String[s.length()];
        int countP = 0;
        int countY = 0;

        for (int i = 0; i < s.length(); i++) {
            str[i] = Character.toString(s.charAt(i));
        }
        
        for (int i = 0; i < str.length; i++) {
            if (str[i].equalsIgnoreCase("p")) {
                countP++;
            } else if (str[i].equalsIgnoreCase("y")) {
                countY++;
            }
        }
        
        if (countP != countY) {
            answer = false; 
        }

        return answer;
    }
}