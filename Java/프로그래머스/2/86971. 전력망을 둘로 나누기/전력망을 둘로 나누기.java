import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            int count = BFS(v1, v2, n, wires);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    private int BFS(int start, int skip, int n, int[][] wires){
        // 인접리스트 생성 -> skip으로 가는 간선 제외      
        List<Integer>list[] = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int wire[] : wires){
            // 끊으려는 간선은 추가 안함
            if(wire[0] == start && wire[1] == skip || 
              wire[1] == start && wire[0] == skip){
                continue;
            }
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        Queue<Integer>queue = new LinkedList<>();
        int visited[] = new int[n+1];
        queue.add(start);
        visited[start] = 1;
        int count = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : list[cur]){
                if(visited[next] == 0){
                    queue.add(next);
                    visited[next] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}