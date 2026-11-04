class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int x = 1; x <= r2; x++){
            // 피타고라스 이용
            long maxY = (long)Math.floor(Math.sqrt((long)r2*r2 - (long)x*x));
            
            long minY = 0;
            // 안에 작은 원 있을 시 큰 원 Y - 작은 원 Y
            if(x < r1){
                minY = (long)Math.ceil(Math.sqrt((long)r1*r1 - (long)x*x));
            }
            answer += (maxY - minY + 1);
        }
        return answer * 4;
    }
}