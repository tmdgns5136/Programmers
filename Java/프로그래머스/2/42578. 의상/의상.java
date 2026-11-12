import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = -1;
        HashMap<String, Integer>map = new HashMap<>();
        for(String []c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        int total = 1;
        for(int n : map.values()){
            total *= (n + 1);
        }
        answer += total;
        return answer;
    }
}