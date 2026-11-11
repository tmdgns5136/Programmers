import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String>set = new HashSet<>();
        char first = ' ';
        char last = ' ';
        set.add(words[0]);
        last = words[0].charAt(words[0].length()-1);
        answer[0]++;
        answer[1]++;
        for(int i = 1; i < words.length; i++){
            first = words[i].charAt(0);
            answer[0]++;
            if(answer[0] > n){
                answer[0] = 1;
            }
            if(i % n == 0){
                answer[1]++;
            }
            if(last != first || set.contains(words[i])){
                return answer;
            }
            set.add(words[i]);
            last = words[i].charAt(words[i].length()-1);
        }
        return new int[]{0, 0};
    }
}