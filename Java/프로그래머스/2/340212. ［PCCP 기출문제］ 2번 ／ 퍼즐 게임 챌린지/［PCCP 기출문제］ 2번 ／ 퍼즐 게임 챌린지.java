class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100000;
        while(left <= right){
            int mid = (left + right) / 2;
            long total = 0;
            for(int i = 0; i < diffs.length; i++){
                if(diffs[i] <= mid){
                    total += times[i];
                }
                else{
                    long timePrev = (i > 0) ? times[i - 1] : 0;
                    total += (diffs[i] - mid) * (times[i] + timePrev) + times[i];
                }
            }
            if(total <= limit){
                answer = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return answer;
    }
}