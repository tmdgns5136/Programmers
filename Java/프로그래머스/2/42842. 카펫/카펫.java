class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0){
                // 노란색 좌우 개수 + 노란색 위아래 개수 + 양 대각선 끝 4 = 갈색
                if((yellow / i * 2) + i * 2 + 4 == brown){
                    // 너비
                    int x = i + 2;
                    // 높이
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