import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int arr[][] = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = (columns*i) + (j+1);
            }
        }
        int k = 0;
        Deque<Integer>queue = new LinkedList<>();
        for(int[] query : queries){
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int min = Integer.MAX_VALUE;
            for(int i = y1; i < y2; i++){
                if(queue.isEmpty()){
                    queue.add(arr[x1][i]);
                }
                else{
                    queue.add(arr[x1][i]);
                    arr[x1][i] = queue.poll();
                }
                min = Math.min(min, arr[x1][i]);
            }
            for(int i = x1; i < x2; i++){
                queue.add(arr[i][y2]);
                arr[i][y2] = queue.poll();
                min = Math.min(min, arr[i][y2]);
            }
            for(int i = y2; i > y1; i--){
                queue.add(arr[x2][i]);
                arr[x2][i] = queue.poll();
                min = Math.min(min, arr[x2][i]);
            }
            for(int i = x2; i >= x1; i--){
                if(i == x1){
                    arr[i][y1] = queue.poll();
                }
                else{
                    queue.add(arr[i][y1]);
                    arr[i][y1] = queue.poll();
                }
                min = Math.min(min, arr[i][y1]);
            }
            answer[k++] = min;
        }
        return answer;
    }
}