import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer>map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }
        for(int i = 0; i <= discount.length - 10; i++){
            boolean check = true;
            HashMap<String, Integer>map1 = new HashMap<>(map);
            for(int j = 0; j < 10; j++){
                if(map1.getOrDefault(discount[i+j], 0) != 0){
                    map1.put(discount[i+j], map1.get(discount[i+j]) - 1);
                }
            }
            for(int n : map1.values()){
                if(n != 0){
                    check = false;
                    break;
                }
            }
            if(check){
                answer++;
            }
        }
        return answer;
    }
}