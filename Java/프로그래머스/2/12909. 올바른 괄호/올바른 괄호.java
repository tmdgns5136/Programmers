import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Queue<String>queue = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals(")")){
                if(queue.isEmpty()){
                    return false;
                }
                queue.poll();
            }
            else{
                queue.add("(");
            }
        }
        if(queue.isEmpty()){
            answer = true;
        }
        return answer;
    }
}