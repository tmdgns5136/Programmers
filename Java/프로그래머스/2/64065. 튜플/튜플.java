// 빈도 수가 많을 수록 앞에 위치
import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        HashMap<String, Integer>map = new HashMap<>();
        String n[] = s.replaceAll("[{}]", "").split(",");
        for(String s1 : n){
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        answer = new int[map.size()];
        for(String key : map.keySet()){
            answer[map.size() - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
}