class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];

            if (n % 2 == 0) {
                answer[i] = n + 1;
            }
            else{
                answer[i] = n + 1 + ((n ^ (n+1))>>2);
            }
        }

        return answer;
    }
}