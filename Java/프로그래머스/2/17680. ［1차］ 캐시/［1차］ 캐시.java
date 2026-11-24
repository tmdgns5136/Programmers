import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String>queue = new LinkedList<>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(String city : cities){
            city = city.toUpperCase();
            if(queue.isEmpty()){
                queue.add(city);
                answer += 5;
            }
            else{
                if(queue.contains(city)){
                    queue.remove(city);
                    queue.add(city);
                    answer++;
                }
                else{
                    if(queue.size() == cacheSize){
                        queue.poll();
                        queue.add(city);
                    }
                    else{
                        queue.add(city);
                    }
                    answer+=5;
                }
            }
        }
        return answer;
    }
}