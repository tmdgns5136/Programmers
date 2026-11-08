import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[]sp = s.split(" ");
        List<Integer>list = new LinkedList<>();
        for(int i = 0; i < sp.length; i++){
            list.add(Integer.parseInt(sp[i]));
        }
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }
}