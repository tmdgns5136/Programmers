class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int length = s.length();
            s = s.replaceAll("0","");
            int one = s.length();
            answer[0]++;
            answer[1] += (length - one);
            s = Integer.toBinaryString(one);
        }
        return answer;
    }
}