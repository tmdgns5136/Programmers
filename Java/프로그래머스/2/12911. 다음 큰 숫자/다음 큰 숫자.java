class Solution {
    public int solution(int n) {
        int answer = 0;
        int one = Integer.bitCount(n);
        while(true){
            if(one == Integer.bitCount(++n)){
                answer = n;
                break;
            }
        }
        return answer;
    }
}