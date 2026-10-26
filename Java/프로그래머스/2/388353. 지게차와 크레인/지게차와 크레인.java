import java.util.*;
class Solution {
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        // 외부 접근 탐색을 쉽게 하기 위한 패딩 2
        // 패딩을 안주면 창고 테두리 전체를 탐색해야됨
        char stor[][] = new char[storage.length + 2][storage[0].length() + 2];
        for(int i = 0; i < storage.length+2; i++){
            Arrays.fill(stor[i], '0');
        }
        
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[0].length(); j++){
                stor[i+1][j+1] = storage[i].charAt(j);
            }
        }
        for(String req : requests){
            if(req.length() == 2){
                for(int i = 1; i <= storage.length; i++){
                    for(int j = 1; j <= storage[0].length(); j++){
                        if(stor[i][j] == req.charAt(0)){
                            stor[i][j] = '0';
                        }
                    }
                }
            }
            else{
                int visited[][] = new int[stor.length][stor[0].length];
                Queue<int[]>queue = new LinkedList<>();
                // 0부터 가능한 컨테이너 탐색하면서 원하는 컨테이너가 닿는지 확인
                queue.add(new int[]{0, 0});
                visited[0][0] = 1;
                List<int[]>list = new ArrayList<>();
                
                while(!queue.isEmpty()){
                    int cur[] = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    
                    for(int z = 0; z < 4; z++){
                        int nx = x + dx[z];
                        int ny = y + dy[z];
                        
                        if(nx >= 0 && nx < stor.length && ny >= 0 && ny < stor[0].length && visited[nx][ny] == 0){
                            if(stor[nx][ny] == '0'){
                                visited[nx][ny] = 1;
                                queue.add(new int[]{nx, ny});
                            }
                            else if(stor[nx][ny] == req.charAt(0)){
                                visited[nx][ny] = 1;
                                list.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
                for(int pos[] : list){
                    stor[pos[0]][pos[1]] = '0';
                }
            }
        }
        for(int i = 1; i <= storage.length; i++){
            for(int j = 1; j <= storage[0].length(); j++){
                if(stor[i][j] != '0'){
                    answer++;
                }
            }
        }
        return answer;
    }
}