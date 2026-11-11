class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int x = 0;
        for(long i = left; i <= right; i++){
            answer[x++] = Math.max((int)(i/n), (int)(i%n)) + 1;
        }
        
        return answer;
    }
}