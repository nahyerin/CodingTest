import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.toUpperCase(); //대문자변환
        Map<Character, Integer> map = new HashMap<>(); 
        List<Character> list = new ArrayList<>(); 
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); //있으면 +1 없으면 1
            max = Math.max(max, map.get(c));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey()); 
        }
        if (list.size() > 1) { 
            System.out.print("?"); //리스트에 1개이상 -> ?
        } else {
            System.out.print(list.get(0)); //리스트에 1개만 있으면 -> 해당알파벳
        }

    }
}