import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // set에 하나씩 추가
        HashSet<Integer>set = new HashSet<>();
        // 한쪽을 map에다 몰아넣고 하나씩 줄여가며 비교
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int t : topping){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        for(int t : topping){
            set.add(t);
            map.put(t, map.get(t) - 1);
            if(map.get(t) <= 0) map.remove(t);
            if(map.size() == set.size()) answer++;
        }
        return answer;
    }
}