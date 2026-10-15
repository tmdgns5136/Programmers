// 비율 1:1, 2:3, 2:4, 3:4
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Double, Long>map = new HashMap<>();
        Arrays.sort(weights);
        for(int weight : weights){
            double w = (double)weight;
            
            double a = w * 1;
            double b = (w * 2) / 3;
            double c = w / 2;
            double d = (w * 3) / 4;
            
            if(map.containsKey(a)){
                answer += map.get(a);
            }
            if(map.containsKey(b)){
                answer += map.get(b);
            }
            if(map.containsKey(c)){
                answer += map.get(c);
            }
            if(map.containsKey(d)){
                answer += map.get(d);
            }
            map.put(w, map.getOrDefault(w, 0L) + 1L);
        }
        return answer;
    }
}