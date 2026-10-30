// 자르는 칸 수 = W + H - gcd(W, H)
class Solution {
    public long solution(int w, int h) {
        long answer = (long)w * h - (w + h - gcd(w, h));
        return answer;
    }
    private int gcd(int x, int y){
        if(y == 0){
            return x;
        }
        return gcd(y, x % y);
    }
}