class Solution {
    public String solution(int n) {
        String answer = "";
        int a[] = {4, 1, 2};
        while(n / 3 != 0){
            answer = String.valueOf(a[n%3]) + answer;
            if(n%3==0){
                 n = n/3-1;
            }
            else{
                n /= 3;
            }
        }
        if(n == 0){
            return answer;
        }
        return String.valueOf(a[n]) + answer;
    }
}