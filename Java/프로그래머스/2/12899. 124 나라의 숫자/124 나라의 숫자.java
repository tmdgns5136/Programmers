class Solution {
    public String solution(int n) {
        String answer = "";
        int a[] = {4, 1, 2};
        while(n > 0){
            answer = String.valueOf(a[n%3]) + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}