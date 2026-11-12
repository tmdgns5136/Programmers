import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int l = citations.length;
        int x = 0;
        for(int i = 0; i <= l; i++){
            int sum = 0;
            for(Integer c : citations){
                if(x <= c){
                    sum++;
                }
            }
            if(sum >= x && l-sum < x){
                answer = x;
            }
            x++;
        }
        return answer;
    }
}