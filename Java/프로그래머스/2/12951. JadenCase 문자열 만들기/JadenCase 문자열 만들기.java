class Solution {
    public String solution(String s) {
        String answer = "";
        int flag = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                flag = 1;
                answer += " ";
                continue;
            }
            if(flag == 1){
                answer += Character.toUpperCase(s.charAt(i));
                flag = 0;
            }
            else{
                answer += Character.toLowerCase(s.charAt(i));
            }
        }
        return answer;
    }
}