class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        quad(0, 0, arr.length, arr, answer);
        return answer;
    }
    
    private void quad(int x, int y, int size, int arr[][], int answer[]){
        if(check(x, y, size, arr)){
            answer[arr[x][y]]++;
            return;
        }
        quad(x, y, size / 2, arr, answer);
        quad(x, y + size / 2, size / 2, arr, answer);
        quad(x + size / 2, y, size / 2, arr, answer);
        quad(x + size / 2, y + size / 2, size / 2, arr, answer);
    }
    private boolean check(int x, int y, int size, int arr[][]){
        int fV = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != fV) return false;
            }
        }
        return true;
    }
}