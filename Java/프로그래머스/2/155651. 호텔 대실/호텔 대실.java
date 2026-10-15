import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int bT[][] = new int[book_time.length][];
        
        for(int i = 0; i < book_time.length; i++){
            bT[i] = new int[]{parseTime(book_time[i][0]), parseTime(book_time[i][1])+10};
        }
        // 입실이 빠른 순으로 정렬
        Arrays.sort(bT, (a,b) -> a[0] - b[0]);
        
        // 퇴실이 빠른 순으로 정렬
        PriorityQueue<int []> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(int i = 0; i < bT.length; i++){
            // 기존방 재사용 가능하므로 큐에서 빼기
            while(!queue.isEmpty() && queue.peek()[1] <= bT[i][0]){
                queue.poll();
            }
            queue.add(bT[i]);
            answer = Math.max(answer, queue.size());
        }
        return answer;
    }
    private int parseTime(String time){
        String t[] = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}