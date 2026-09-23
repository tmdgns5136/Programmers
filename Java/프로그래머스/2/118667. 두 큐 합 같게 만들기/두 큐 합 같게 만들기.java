// 원형배열로 합친 뒤 합이 큰 큐에서 꺼내 작은 큐로 넣는 것을 반복
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int queue[] = new int[queue1.length + queue2.length];
        int left = 0;
        int right = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        boolean check = false;
        for(int i = 0; i<queue1.length; i++){
            queue[i] = queue1[i];
            sum1 += queue1[i];
            queue[queue1.length+i] = queue2[i];
            sum2 += queue2[i];
        }
        for(int i = 0; i < 2 * queue.length; i++){
            if(sum1 > sum2){
                sum1 -= queue[left];
                sum2 += queue[left];
                left = (left+1)%queue.length;
                answer++;
            }
            else if(sum1 < sum2){
                sum2 -= queue[right];
                sum1 += queue[right];
                right = (right+1)%queue.length;
                answer++;
            }
            else{
                return answer;
            }
        }
        return -1;
    }
}