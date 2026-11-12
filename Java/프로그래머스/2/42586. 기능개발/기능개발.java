import java.util.*;
class Progress{
    int total = 0;
    int speeds = 0;
    Progress(int total, int speeds){
        this.total = total;
        this.speeds = speeds;
    }
    void day(){
        total += speeds;
    }
}
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        LinkedList<Integer>list = new LinkedList<>();
        Queue<Progress>queue = new LinkedList<>();
        for(int i = 0; i < speeds.length; i++){
            queue.add(new Progress(progresses[i], speeds[i]));
        }
        while(!queue.isEmpty()){
            int sum = 0;
            while(!queue.isEmpty() && queue.peek().total >= 100){
                queue.poll();
                sum++;
            }
            if(sum > 0){
                list.add(sum);
            }
            for(Progress p : queue){
                p.day();
            }
        }
        answer = new int[list.size()];
        for(int i = 0; i <list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}