class Solution {
    public int[] solution(long begin, long end) {
        int length = (int) (end - begin + 1);
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            long cur = begin + i;
            answer[i] = get(cur);
        }
        return answer;
    }
    private int get(long n){
        if(n == 1) return 0;
        int x = 1;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                x = i;
                // 가장 작은 약수로 나눈 값은 자기 제외 가장 큰 약수
                if(n / i <= 10000000){
                    return (int) (n / i);
                }
            }
        }
        return x;
    }
}