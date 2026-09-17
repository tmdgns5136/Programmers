import java.util.*;
import java.util.regex.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = files.clone();
        Pattern p = Pattern.compile("([a-zA-Z\\s.-]+)([0-9]{1,5})");
        Arrays.sort(answer, (s1, s2) -> {
            Matcher m1 = p.matcher(s1.toUpperCase());
            Matcher m2 = p.matcher(s2.toUpperCase());
            m1.find();
            m2.find();
            if(!m1.group(1).equals(m2.group(1))){
                return m1.group(1).compareTo(m2.group(1));
            }
            return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
        });
        return answer;
    }
}