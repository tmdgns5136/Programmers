import java.util.*;
class Solution {
    class Point{
        int x, y, time;
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public int solution(String[] maps) {
        char map[][] = new char[maps.length][maps[0].length()];
        for(int i = 0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        int sX = 0, sY = 0;
        int lX = 0, lY = 0;
        int eX = 0, eY = 0;
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                if(map[i][j] == 'S'){
                    sX = i; sY = j;
                }
                else if(map[i][j] == 'L'){
                    lX = i; lY = j;
                }
                else if(map[i][j] == 'E'){
                    eX = i; eY = j;
                }
            }
        }
        // 시작에서 레버 + 레버에서 출구
        int sTol = BFS(sX, sY, lX, lY, map);
        if(sTol == -1) return -1;
        int lToe = BFS(lX, lY, eX, eY, map);
        if(lToe == -1) return -1;
        return sTol + lToe;
    }
    private int BFS(int sX, int sY, int tX, int tY, char map[][]){
        int visited[][] = new int[map.length][map[0].length];
        Queue<Point>queue = new LinkedList<>();
        queue.add(new Point(sX, sY, 0));
        visited[sX][sY] = 1;
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(cur.x == tX && cur.y == tY){
                return cur.time;
            }
            for(int i = 0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length){
                    if(map[nx][ny] != 'X' && visited[nx][ny] == 0){
                        visited[nx][ny] = 1;
                        queue.add(new Point(nx, ny, cur.time+1));
                    }
                }
            }
        }
        
        return -1;
    }
}