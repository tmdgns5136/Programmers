import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        HashMap<String, Integer>map = new HashMap<>();
        String sp[] = s.replaceAll("[{}]", "").split(",");
        for(int i = 0; i < sp.length; i++){
            map.put(sp[i], map.getOrDefault(sp[i], 0) + 1);
        }
        answer = new int[map.size()];
        // map 크기에서 빈도 수 빼면 위치가 됨
        for(String key : map.keySet()){
            answer[map.size() - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
}