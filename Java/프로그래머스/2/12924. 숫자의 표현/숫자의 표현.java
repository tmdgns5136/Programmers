// n의 홀수 약수 개수를 구하면 연속된 자연수의 합의 개수
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i+=2){
            if(n % i == 0){
                answer++;
            }
        }
        return answer;
    }
}