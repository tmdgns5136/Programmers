import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer>list = new ArrayList<>();
        long fac = 1;
        for(int i = 1; i <= n; i++){
            list.add(i);
            if(i < n){
                fac *= i;
            }
        }
        // k는 1부터 시작해서 -1
        k--;
        int idx = 0;
        // fac를 나눠가며 자릿수 구하기
        for(int i = 0; i<n; i++){
            if(i == n-1){
                answer[idx++] = list.get(0);
                break;
            }
            int selectedIdx = (int)(k/fac);
            answer[idx++] = list.get(selectedIdx);
            list.remove(selectedIdx);
            k %= fac;
            fac /= (n-i-1);
        }
        return answer;
    }
}