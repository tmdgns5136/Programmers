import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 인접리스트 -> List<int[]> 형식으로 그래프 구성(원소(목적지, 가중치))
        List<int[]>graph[] = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int r[] : road){
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }
        // 최단 거리 배열 초기화
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // 가중치 기준 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{1, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] > dist[cur[0]]) continue;
            for(int[] next : graph[cur[0]]){
                if(dist[next[0]] > dist[cur[0]] + next[1]){
                    dist[next[0]] = dist[cur[0]] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}