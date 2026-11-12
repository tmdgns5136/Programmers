class Solution {
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int visited[] = new int[dungeons.length];
        backtrack(dungeons, 0, k, visited);
        return max;
    }
    private void backtrack(int[][] dungeons, int sum, int k, int []visited){
        max = Math.max(sum, max);
        for(int i = 0; i < dungeons.length; i++){
            if(visited[i] == 0 && k >= dungeons[i][0]){
                visited[i] = 1;
                backtrack(dungeons, sum + 1, k - dungeons[i][1], visited);
                visited[i] = 0;
            }
        }
        return;
    }
}