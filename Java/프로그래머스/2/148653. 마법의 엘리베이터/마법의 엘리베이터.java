class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int na = storey % 10;
            if(na < 5){
                answer += na;
            }
            else if (na > 5){
                answer += (10 - na);
                storey += 10;
            }
            else{ // 나머지 5인 경우 다음 자리수가 5보다 클 때는 올리는 게 이득
                answer += 5;
                if((storey / 10 % 10) >= 5){
                    storey += 10;
                }
            }
            storey /= 10;
        }
        return answer;
    }
}