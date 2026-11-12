import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer>list = new LinkedList<>();
        int arr[] = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            int n = 100 - progresses[i];
            // n을 스피드로 나눴을 때 0보다 크면 하루 더 필요하니 + 1
            n = n % speeds[i] > 0 ? n / speeds[i] + 1 : n / speeds[i];
            arr[i] = n;
        }
        int first = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(first >= arr[i]){
                count++;
            }
            else{
                first = arr[i];
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}