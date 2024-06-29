import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    static HashMap<Long, Long> roomMap;
    static long roomSize;
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        roomMap = new HashMap<>();
        roomSize = k;

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }
    
    public static long findRoom(long roomNumber){
        if(!roomMap.containsKey(roomNumber)){
            roomMap.put(roomNumber, (roomNumber + 1) % roomSize);
            return roomNumber;
        }
        long emptyRoom = findRoom(roomMap.get(roomNumber));
        roomMap.put(roomNumber, (emptyRoom + 1) % roomSize);
        return emptyRoom;
    }
}