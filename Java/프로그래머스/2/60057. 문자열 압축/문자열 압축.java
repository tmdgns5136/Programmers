import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        // 길이는 반이면 됨
        for(int len = 1; len <= s.length() / 2; len++){
            StringBuilder sb = new StringBuilder();
            // 처음 target
            String target = s.substring(0, len);
            int count = 1;
            
            // len만큼씩 잘라가며 확인
            for(int j = len; j < s.length(); j+=len){
                String sub = s.substring(j, Math.min(j + len, s.length()));
                if(target.equals(sub)){
                    count++;
                }
                else{
                    if(count > 1) sb.append(count);
                    sb.append(target);
                    target = sub;
                    count = 1;
                }
            }
            if(count > 1) sb.append(count);
            sb.append(target);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}