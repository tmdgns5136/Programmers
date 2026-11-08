import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[]sp = s.split(" ");
        List<Integer>list = new LinkedList<>();
        for(int i = 0; i < sp.length; i++){
            String s1 = "";
            if(sp[i].charAt(0) == '-'){
                for(int j = 1; j < sp[i].length(); j++){
                    s1 += sp[i].charAt(j);
                }
                list.add(-Integer.parseInt(s1));
            }
            else{
                for(int j = 0; j < sp[i].length(); j++){
                    s1 += sp[i].charAt(j);
                }
                list.add(Integer.parseInt(s1));
            }
        }
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }
}