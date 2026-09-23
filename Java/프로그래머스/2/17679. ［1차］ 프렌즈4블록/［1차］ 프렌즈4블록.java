import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char b[][] = new char[m][n];
        for(int i = 0; i<m; i++){
            b[i] = board[i].toCharArray();
        }
        while(true){
            boolean visited[][] = new boolean[m][n];
            boolean hasDeleted = false; 
            for(int i = 0; i < m-1; i++){
                for(int j = 0; j<n-1; j++){
                    char block = b[i][j];
                    if(block != ' ' && block == b[i+1][j] &&
                      block == b[i][j+1] && block == b[i+1][j+1]){
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                        hasDeleted = true;
                    }
                }
            }
            if(!hasDeleted){
                break;
            }
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(visited[i][j]){
                        b[i][j] = ' ';
                        answer++;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                List<Character>list = new ArrayList<>();
                for(int j = m-1; j>-1; j--){
                    if(b[j][i] != ' '){
                        list.add(b[j][i]);
                    }
                }
                int idx = 0;
                for(int j = m-1; j>-1; j--){
                    if(list.size() > idx){
                        b[j][i] = list.get(idx++);
                    }
                    else{
                        b[j][i] = ' ';
                    }
                }   
            }
            
        }
        
        return answer;
    }
}