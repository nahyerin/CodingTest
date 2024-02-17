import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
         //캐시 크기 0
        if(cacheSize == 0){
            return cities.length * 5;
        }

        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();

            if(cache.contains(city)){ 
                cache.remove(city);
                cache.add(city); //맨 뒤에 추가
                answer+=1;
            }

            else{ 
                if(cache.size()==cacheSize){ 
                    cache.remove(0); //맨 앞 도시 지우기
                }

              //캐시가 다 안찼으면
                cache.add(city); //맨 뒤에 추가
                answer+=5;
            }
        }

        return answer;
    }
}