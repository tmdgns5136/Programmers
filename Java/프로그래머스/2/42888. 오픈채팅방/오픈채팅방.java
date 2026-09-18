import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String>map = new HashMap<>();
        for(String s : record){
            String r[] = s.split(" ");
            if(r[0].equals("Enter") || r[0].equals("Change")){
                map.put(r[1], r[2]);
            }
        }
        for(String s : record){
            String r[] = s.split(" ");
            if(r[0].equals("Enter")){
                list.add(map.get(r[1]) + "님이 들어왔습니다.");
            }
            else if(r[0].equals("Leave")){
                list.add(map.get(r[1]) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[0]);
    }
}