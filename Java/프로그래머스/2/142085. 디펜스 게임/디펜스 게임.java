import java.util.*;
// 그리디 + 우선순위 큐 -> 일단 다 막되 부족해지면 현재부터 지금까지 중 가장 많이 죽었을 때에 k사용
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer>queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<enemy.length; i++){
            n -= enemy[i];
            queue.add(enemy[i]);
            if(n < 0){
                if(k > 0){
                    n += queue.poll();
                    k--;
                }
                else{
                    return i;
                }
            }
            
        }
        return enemy.length;
    }
}