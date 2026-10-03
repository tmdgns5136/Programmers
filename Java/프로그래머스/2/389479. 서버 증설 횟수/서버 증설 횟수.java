import java.util.*;
class Solution {
    class Server{
        int time;
        
        public Server(int time){
            this.time = time;
        }
        
        public void minusTime(){
            this.time -= 1;
        }
    }
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Server>queue = new LinkedList<>();
        for(int player : players){
            if(!queue.isEmpty()){
                Iterator<Server> it = queue.iterator();
                while (it.hasNext()) {
                    Server s = it.next();
                    s.minusTime();
                    if (s.time == 0) {
                        it.remove();
                    }
                }
            }
            if(player / m > queue.size()){
                int needServer = player / m - queue.size();
                for(int i = 0; i < needServer; i++){
                    queue.add(new Server(k));
                    answer++;
                }
            }
        }
        return answer;
    }
}