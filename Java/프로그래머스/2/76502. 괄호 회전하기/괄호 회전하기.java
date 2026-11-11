import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean check = true;
        Stack<Character>stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            check = true;
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt((i+j) % s.length()); 
                if(c == '[' || c == '(' || c == '{'){
                    stack.add(c);
                }
                else if(c == ']' || c == ')' || c == '}'){
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    if(c == ']' && stack.peek() == '['){
                        stack.pop();
                    }
                    else if(c == ')' && stack.peek() == '('){
                        stack.pop();
                    }
                    else if(c == '}' && stack.peek() == '{'){
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && check) answer++;
        }
        return answer;
    }
}