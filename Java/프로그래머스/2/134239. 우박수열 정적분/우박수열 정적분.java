import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer>list = new ArrayList<>();
        list.add(k);
        while(k > 1){
            if(k % 2 == 0){
                k /= 2;
                list.add(k);
            }
            else{
                k = k * 3 + 1;
                list.add(k);
            }
        }
        int n = list.size() - 1;
        
        // 구간별 넓이(사다리꼴) 1칸 넓이 = y[i] + y[i+1] / 2
        double area[] = new double[n];
        for(int i = 0; i < n; i++){
            area[i] = (list.get(i) + list.get(i+1)) / 2.0;
        }
        
        for(int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            if(start > end){
                answer[i] = -1.0;
            }
            else if(start == end){
                answer[i] = 0.0;
            }
            else{
                double sum = 0.0;
                for(int j = start; j < end; j++){
                    sum += area[j];
                }
                answer[i] = sum;
            }
        }
        
        return answer;
    }
}