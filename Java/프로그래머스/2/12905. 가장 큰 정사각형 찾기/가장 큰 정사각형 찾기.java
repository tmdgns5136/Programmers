class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                // 오른쪽, 아래, 대각아래 중 최소 값을 넣어줌 (정사각형이 아니면 0이 되는 것임) 
                if(i > 0 && j > 0 && board[i][j] == 1){
                    board[i][j] = Math.min(board[i-1][j], Math.min(board[i][j-1], board[i-1][j-1])) + 1;
                }
                answer = Math.max(board[i][j], answer);
                
            }
            
        }
        return answer * answer;
    }
}