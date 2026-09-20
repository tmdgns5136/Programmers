class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int min = 10000000;
        int sum = 0;
        while(right < sequence.length){
            sum += sequence[right];
            while(sum > k && left <= right){
                sum -= sequence[left++];
            }
            if(sum == k){
                if(min > right - left){
                    answer[0] = left;
                    answer[1] = right;
                    min = right-left;
                }
            }
            right++;
        }
        return answer;
    }
}