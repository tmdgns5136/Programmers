import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int time[] = new int[1450];
        for(String[] book : book_time){
            int sH = Integer.parseInt(book[0].substring(0,2));
            int sM = Integer.parseInt(book[0].substring(3,5));
            int sT = sH * 60 + sM;
            
            int eH = Integer.parseInt(book[1].substring(0,2));
            int eM = Integer.parseInt(book[1].substring(3,5));
            int eT = eH * 60 + eM + 10;
            
            for(int i = sT; i < eT; i++){
                time[i]++;
            }
        }
        Arrays.sort(time);
        answer = time[time.length-1];
        return answer;
    }
}