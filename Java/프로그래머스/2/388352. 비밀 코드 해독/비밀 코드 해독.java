import java.util.*;
class Solution {
    int answer = 0;
    int code[] = new int[5];
    public int solution(int n, int[][] q, int[] ans) {
        backtrack(1, 0, n, q, ans);
        return answer;
    }
    // 모든 코드의 경우의 수를 구함
    private void backtrack(int start, int depth, int n, int q[][], int[] ans){
        if(depth == 5){
            if(isValid(q, ans)){
                answer++;
            }
            return;
        }
        for(int i = start; i <= n; i++){
            code[depth] = i;
            backtrack(i+1, depth+1, n, q, ans);
        }
    }
    // 5자리가 만들어지면 조건과 맞는지 확인
    private boolean isValid(int q[][], int ans[]){
        for(int i = 0; i < q.length; i++){
            int count = 0;
            for(int c : code){
                for(int target : q[i]){
                    if(c == target){
                        count++;
                        break;
                    }
                }
            }
            if(count != ans[i]){
                return false;
            }
        }
        return true;
    }
}