import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Arrays.sort(orders, (a, b) -> a.compareTo(b));
        List<String>list = new ArrayList<>();
        // 알파벳 순으로 정렬
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        for(int n : course){
            int max = 0;
            HashMap<String, Integer>map = new HashMap<>();
            for(String s : orders){
                if(s.length() >= n){
                    DFS(s, map, n, "", 0);
                }
            }
            for(int count : map.values()){
                if(count >= 2 && count > max){
                    max = count;
                }
            }
            if(max >= 2){
                for(String key : map.keySet()){
                    if(map.get(key) == max){
                        list.add(key);
                    }
                }
            }
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    private void DFS(String s, HashMap<String, Integer>map, int n, String o, int idx){
        if(n == o.length()){
            map.put(o, map.getOrDefault(o, 0)+1);
            return; 
        }
        for(int i = idx; i < s.length(); i++){
            DFS(s, map, n, o + s.charAt(i), i+1);
        }
    }
}