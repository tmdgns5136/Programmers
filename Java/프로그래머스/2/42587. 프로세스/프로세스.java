import java.util.*;
class Process{
    int p, l;
    public Process(int p, int l){
        this.p = p;
        this.l = l;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process>queue = new LinkedList<>();
        int l = priorities.length;
        for(int i = 0; i < l; i++){
            queue.add(new Process(priorities[i], i));
        }
        int arr[] = new int[l];
        while(!queue.isEmpty()){
            Process cur = queue.poll();
            int max = Collections.max(queue.isEmpty() ? List.of(cur) : queue, (a, b) -> a.p - b.p).p;
            if(cur.p < max){
                queue.add(cur);
            }else{
                answer++;
                if(cur.l == location){
                    return answer;
                }
            }
        }
        return answer;
    }
}