class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int triangle[][] = new int[n][n];
        int x = -1, y = 0;
        int num = 1;
        // 3 방향밖에 없기에 %3
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i % 3 == 0){ // 아래로
                    x++;
                }
                else if(i % 3 == 1){ // 오른쪽으로
                    y++;
                }
                else if(i % 3 == 2){ // 대각선위로
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                answer[idx++] = triangle[i][j];
            }
        }
        return answer;
    }
}