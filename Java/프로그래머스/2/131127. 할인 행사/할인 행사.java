import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer>map = new HashMap<>();
        for(int i = 0; i <= discount.length - 10; i++){
            map.clear();
            boolean check = true;
            for(int j = 0; j < 10; j++){
                map.put(discount[i+j], map.getOrDefault(discount[i+j] , 0) + 1);
            }
            for(int k = 0; k < want.length; k++){
                if(map.getOrDefault(want[k], 0) < number[k]){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}