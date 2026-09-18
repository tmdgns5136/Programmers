class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if (n % 2 == 0) {
                answer[i] = n + 1;
            }
            else{
                long lastZero = ~n & (n + 1);
                answer[i] = (n | lastZero) & ~(lastZero >> 1);
            }
        }

        return answer;
    }
}