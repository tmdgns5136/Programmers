import java.util.*;
class Solution {
    List<int[]> result = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2, n) - 1][2];
        // hanoi(원판 개수, 시작, 목적지, 경유지)
        hanoi(n, 1, 3, 2);
        answer = result.toArray(new int[result.size()][]);
        return answer;
    }
    private void hanoi(int n, int start, int to, int via){
        if(n == 1){
            result.add(new int[]{start, to});
            return;
        }
        // 경유지로 옮김
        hanoi(n-1, start, via, to);
        
        // 제일 큰 원판 목적지로 이동
        result.add(new int[]{start, to});

        // 경유지에 있던 거 목적지로 옮김
        hanoi(n-1, via, to, start);
    }
}