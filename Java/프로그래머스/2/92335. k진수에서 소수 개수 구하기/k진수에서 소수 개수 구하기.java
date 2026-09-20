class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s1 = Integer.toString(n, k);
        int i = 0;
        String []s2 = s1.split("0");
        for(String nS : s2){
            if (nS.isEmpty() || nS.equals("1")) {
                continue;
            }
            long num = Long.parseLong(nS);
            if(checkPrime(num)){
                answer++;
            }
        }
        return answer;
    }
    private boolean checkPrime(long n){
        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}