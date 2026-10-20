import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.isEmpty()) return "";
        int left = 0, right = 0;
        int idx = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '(') left++;
            else right++;
            if(left == right){
                idx = i + 1;
                break;
            }
        }
        String u = p.substring(0, idx);
        String v = p.substring(idx);
        
        // 규칙 3
        if(check(u)){
            return u + solution(v); // 재귀
        }
        
        // 규칙 4
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v));
        sb.append(")");
        
        for(int i = 1; i < u.length()-1; i++){
            if(u.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }
    private boolean check(String s){
        Queue<String>queue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ('(')){
                queue.add("(");
            }
            else if(s.charAt(i) == (')')){
                if(queue.size() == 0) return false;
                queue.poll();
            }
        }
        if(queue.size() == 0) return true;
        return false;
        
    }
}