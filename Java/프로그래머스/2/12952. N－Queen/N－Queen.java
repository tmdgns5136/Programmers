class Solution {
    int answer = 0;
    public int solution(int n) {
        int[] board = new int[n];
        backtrack(0, n, board);
        return answer;
    }
    private void backtrack(int row, int n, int[] board){
        if(row == n){
            answer++;
            return;
        }
        for(int i = 0; i < n; i++){
            // 행 위치
            board[row] = i;
            
            if(isValid(row, board)){
                backtrack(row+1, n, board);
            }
        }
    }
    private boolean isValid(int row, int board[]){
        for(int i = 0; i < row; i++){
            // i번째 행의 퀸 위치, 현재 행의 퀸 위치
            if(board[i] == board[row]) return false;
            
            // 행 차이와 열 차이가 같으면 대각선
            if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
        }
        
        return true;
    }
}