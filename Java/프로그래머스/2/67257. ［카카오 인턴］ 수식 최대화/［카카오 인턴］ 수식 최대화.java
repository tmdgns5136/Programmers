import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String s[][] = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
        };
        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // 숫자, 연산자 분리해서 리스트에 넣기
        for(char c : expression.toCharArray()){
            if(c == '+' || c == '-' || c == '*'){
                numbers.add(Long.parseLong(sb.toString()));
                ops.add(String.valueOf(c));
                sb.setLength(0);
            }
            else{
                sb.append(c);
            }
        }
        // 마지막 숫자 넣기
        numbers.add(Long.parseLong(sb.toString()));
        
        for(String[] p : s){
            List<Long> subNums = new ArrayList<>(numbers);
            List<String> subOps = new ArrayList<>(ops);
            for(String op : p){
                for(int i = 0; i < subOps.size();){
                    if(subOps.get(i).equals(op)){
                        long n1 = subNums.get(i);
                        long n2 = subNums.get(i+1);
                        long res = calc(n1, n2, op);
                        
                        // 사용한 숫자 삭제 후 결과값 추가
                        subNums.remove(i);
                        subNums.remove(i);
                        subNums.add(i, res);
                        
                        // 사용한 연산자 삭제
                        subOps.remove(i);
                    }
                    else{
                        i++;
                    }
                    
                }
                
            }
            long result = Math.abs(subNums.get(0));
            answer = Math.max(result, answer);
        }
        
        return answer;
    }
    private long calc(long a, long b, String op){
        switch(op){
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
        }
        return 0;
    }
}