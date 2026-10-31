import java.util.*;
class Solution {
    class Mset{
        int dia = 0;
        int iron = 0;
        int stone = 0;
        public int getPiro(){
            return dia * 25 + iron * 5 + stone;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int max = Math.min(minerals.length, totalPicks * 5);
        List<Mset>list = new ArrayList<>();
        for(int i = 0; i < max; i+=5){
            Mset mset = new Mset();
            for(int j = i; j < Math.min(i + 5, max); j++){
                if(minerals[j].equals("diamond")) mset.dia++;
                else if(minerals[j].equals("iron")) mset.iron++;
                else mset.stone++;
            }
            list.add(mset);
        }
        list.sort((a, b) -> b.getPiro() - a.getPiro());
        for(Mset mset : list){
            if(picks[0] > 0){
                answer += mset.dia + mset.iron + mset.stone;
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += mset.dia * 5 + mset.iron + mset.stone;
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += mset.getPiro();
                picks[2]--;
            }
            else{
                break;
            }
            
        }
        return answer;
    }
}