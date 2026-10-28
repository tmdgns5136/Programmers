import java.util.*;
class Solution {
    class Subject{
        String subject = "";
        int start = 0;
        int time = 0;
        Subject(String subject, int time, int start){
            this.subject = subject;
            this.start = start;
            this.time = time;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Subject>queue = new PriorityQueue<>((a,b) -> a.start - b.start);
        for(String plan[] : plans){
            int start = Integer.parseInt(plan[1].substring(0,2)) * 60 + Integer.parseInt(plan[1].substring(3, 5));
            int time = Integer.parseInt(plan[2]);
            queue.add(new Subject(plan[0], time, start));
        }
        // 멈춘 과제들을 담을 스택
        Stack<Subject> stack = new Stack<>();
        int i = 0;
        while(!queue.isEmpty()){
            Subject cur = queue.poll();
            if(!queue.isEmpty()){
                Subject next = queue.peek();
                if(cur.start + cur.time <= next.start){
                    answer[i++] = cur.subject; 
                    int freeTime = next.start - (cur.start + cur.time);
                    
                    // 남는 여유 시간 동안 스택에 멈춰둔 거 실시
                    while(freeTime > 0 && !stack.isEmpty()){
                        Subject stop = stack.peek();
                        if(stop.time <= freeTime){
                            freeTime -= stop.time;
                            answer[i++] = stack.pop().subject;
                        }
                        else{
                            stop.time -= freeTime;
                            freeTime = 0;
                        }
                    }
                }
                else{
                    cur.time -= (next.start - cur.start);
                    stack.push(cur);
                }
            }
            else{
                answer[i++] = cur.subject;
            }
        }
        while(!stack.isEmpty()){
            answer[i++] = stack.pop().subject;
        }
        return answer;
    }
}