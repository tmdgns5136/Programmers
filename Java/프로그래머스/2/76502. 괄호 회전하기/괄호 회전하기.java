import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(check(s, i)) answer++;
        }
        return answer;
    }
    private boolean check(String s, int i){
        Stack<Character>stack = new Stack<>();
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt((i+j)%s.length());
            if(c == '[' || c == '(' || c == '{'){
                stack.add(c);
            }
            else{
                if(stack.isEmpty()) return false;
                if(c == ']' && stack.peek() == '[') stack.pop();
                else if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == '}' && stack.peek() == '{') stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}