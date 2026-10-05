import java.util.*;
class Solution {
    class Point{
        int x, y, count;
        public Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public int solution(String[] board) {
        int answer = -1;
        char boards[][] = new char[board.length][board[0].length()];
        for(int i = 0; i<board.length; i++){
            boards[i] = board[i].toCharArray();
        }
        int visited[][] = new int[board.length][board[0].length()];
        int sX = 0;
        int sY = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length(); j++){
                if(boards[i][j] == 'R'){
                    sX = i;
                    sY = j;
                    break;
                }
            }
        }
        Queue<Point>queue = new LinkedList<>();
        queue.add(new Point(sX, sY, 0));
        visited[sX][sY] = 1;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            if(boards[cur.x][cur.y] == 'G'){
                return cur.count;
            }
            for(int i = 0; i<4; i++){
                int nx = cur.x;
                int ny = cur.y;
                // 한 방향으로 최대치까지 반복
                while(nx + dx[i] >= 0 && nx + dx[i] < board.length && ny + dy[i] >= 0 && ny + dy[i] < board[0].length() && boards[nx+dx[i]][ny+dy[i]] != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                // 방문 안했으면 queue에 추가
                if(visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    queue.add(new Point(nx, ny, cur.count+1));
                }
            }
        }
        return -1;
    }    
}