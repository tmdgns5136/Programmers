class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        back(numbers, target, 0, 0, 0);
        return answer;
    }
    private void back(int[] numbers, int target, int depth, int start, int sum){
        int dx[] = {1, -1};
        if(depth == numbers.length && sum == target){
            answer++;
            return;
        }
        for(int i = start; i < numbers.length; i++){
            back(numbers, target, depth + 1, i + 1, sum + numbers[i] * dx[0]);
            back(numbers, target, depth + 1, i + 1, sum + numbers[i] * dx[1]);
        }
    }
}