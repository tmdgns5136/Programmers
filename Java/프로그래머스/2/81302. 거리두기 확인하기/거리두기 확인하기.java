import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int a = 0;
        for(String[] place : places){
            char p[][] = new char[place.length][place[0].length()];
            for(int i = 0; i < place.length; i++){
                p[i] = place[i].toCharArray();
            }
            if(check(p)){
                answer[a++] = 1;
            }
            else{
                answer[a++] = 0;
            }
            
        }
        return answer;
    }
    private boolean check(char[][] p){
        for(int i = 0; i < p.length; i++){
            for(int j = 0; j < p[0].length; j++){
                if(p[i][j] == 'P'){
                    if(!BFS(p, i, j)) return false;
                }
            }
        }
        return true;
    }
    private boolean BFS(char[][] p, int x, int y){
        Queue<int[]>queue = new LinkedList<>();
        int[][] visited = new int[p.length][p[0].length];
        queue.add(new int[]{x, y, 0});
        visited[x][y] = 1;
        
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int dist = cur[2]; // 맨해튼 거리 2생각해야됨
            
            if(dist >= 2) continue;
            int dx[] = {1, -1, 0, 0};
            int dy[] = {0, 0, 1, -1};
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + curX;
                int ny = dy[i] + curY;
                if(nx >= 0 && nx < p.length && ny >= 0 && ny < p[0].length && visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    
                    // 파티션 있는 경우
                    if(p[nx][ny] == 'X') continue;
                    // 응시자 있는 경우 false
                    if(p[nx][ny] == 'P') return false;
                    queue.add(new int[]{nx, ny, dist+1});
                }
            }
        }
        return true;
    }
}