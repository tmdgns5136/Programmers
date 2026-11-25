import java.util.*;
class Pos{
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int solution(int[][] maps) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0));
        int arr[][] = new int[maps.length][maps[0].length];
        arr[0][0] = 1;
        bfs(maps, queue, arr);
        if(arr[maps.length-1][maps[0].length-1] == 0){
            return -1;
        }
        return arr[maps.length-1][maps[0].length-1];
    }
    private void bfs(int[][] maps, Queue<Pos> queue, int arr[][]){
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            Pos cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            if(x == maps.length - 1 && y == maps[0].length - 1){
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && arr[nx][ny] == 0 && maps[nx][ny] == 1){
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new Pos(nx, ny));
                    
                }
            }
        }
    }   
}