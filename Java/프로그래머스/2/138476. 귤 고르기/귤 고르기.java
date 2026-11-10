import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int arr[] = new int[10000001];
        for(int t : tangerine){
            arr[t]++;
        }
        Arrays.sort(arr);
        int x = arr.length - 1;
        while(k > 0){
            k -= arr[x--];
            answer++;
        }
        return answer;
    }
}