import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int visited[][] = new int[land.length][land[0].length];
        int perCol[] = new int[land[0].length];
        for(int i = 0; i < land.length; i++){
            for(int j = 0; j < land[0].length; j++){
                if(land[i][j] == 1 && visited[i][j] == 0){
                    Queue<int[]>queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    int size = 0;
                    // 현 덩어리가 방문하는 열들을 중복없이 저장
                    Set<Integer> cols = new HashSet<>();
                    while(!queue.isEmpty()){
                        int cur[] = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        size++;
                        // 덩어리가 지나가는 열을 set에 저장
                        cols.add(y);
                        for(int k = 0; k < 4; k++){
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if(nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length && visited[nx][ny] == 0 && land[nx][ny] == 1){
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = 1;
                            }
                        } 
                    }
                    // 열마다 size를 더해줌
                    for(int col : cols){
                        perCol[col] += size;
                    }
                }
            }
        }
        for(int total : perCol){
            answer = Math.max(total, answer);
        }
        return answer;
    }
}