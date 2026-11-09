import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character>stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.peek() == s.charAt(i)){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.size() == 0){
            answer = 1;
        }
        return answer;
    }
}