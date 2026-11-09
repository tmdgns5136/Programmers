class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0){
                if((yellow / i * 2) + i * 2 + 4 == brown){
                    int x = i + 2;
                    int y = yellow / i + 2;
                    if(x >= y){
                        answer[0] = x;
                        answer[1] = y;
                    }
                }
            }
        }
        return answer;
    }
}