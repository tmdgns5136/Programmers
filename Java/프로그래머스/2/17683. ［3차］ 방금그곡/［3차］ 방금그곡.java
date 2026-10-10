class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int length = m.length();
        int maxTime = -1;
        m = edit(m);
        for(String s : musicinfos){
            String ss[] = s.split(",");
            int sH = Integer.parseInt(ss[0].substring(0,2));
            int sM = Integer.parseInt(ss[0].substring(3,5));
            int eH = Integer.parseInt(ss[1].substring(0,2));
            int eM = Integer.parseInt(ss[1].substring(3,5));
            int sLength = (eH - sH) * 60 + (eM - sM);
            String melody = edit(ss[3]);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < sLength; i++){
                sb.append(melody.charAt(i % melody.length()));
                String playedM = sb.toString();
                if(playedM.contains(m)){
                    if(maxTime < sLength){
                        answer = ss[2];
                        maxTime = sLength;
                    }
                    break;
                }
            }
            
        }
        return answer;
    }
    private String edit(String m){
        // #이 붙은 음을 소문자로 치환해주는 전처리 (길이 계산을 편하게 하기 위함)
        return m.replace("C#", "c")
             .replace("D#", "d")
             .replace("F#", "f")
             .replace("G#", "g")
             .replace("A#", "a");
    }
}