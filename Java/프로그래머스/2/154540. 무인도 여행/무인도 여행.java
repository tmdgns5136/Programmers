import java.util.*;
class Solution {
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(String[] maps) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int visited[][] = new int[maps.length][maps[0].length()];
        char map[][] = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j<maps[0].length(); j++){
                if(map[i][j] != 'X'){
                    if(visited[i][j] != 1){
                        list.add(BFS(map, visited, i, j));
                    }
                }
            }
        }
        Collections.sort(list);
        if(list.isEmpty()) return new int[]{-1};
        return list.stream().mapToInt(i -> i).toArray();
    }
    private int BFS(char map[][], int visited[][], int x, int y){
        int total = map[x][y] - '0';
        Queue<Point>queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = 1;
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length){
                    if(map[nx][ny] != 'X' && visited[nx][ny] != 1){
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = 1;
                        total += map[nx][ny] - '0';
                    }
                }
            }
        }
        return total;
    }
}