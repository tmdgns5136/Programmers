import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;  
        int a = arrayA[0];
        int b = arrayB[0];
        int checkA = 1;
        int checkB = 1;
        for(int i = 1; i<arrayA.length; i++){
            int gcd = Euclidean(a, arrayA[i]);
            a = gcd;
        }
        for(int i = 1; i<arrayB.length; i++){
            int gcd = Euclidean(b, arrayB[i]);
            b = gcd;
        }
        for(int i = 0; i<arrayB.length; i++){
            if(arrayB[i] % a == 0){
                checkB = 0;
                break;
            }
        }
        if(checkB == 1){
            answer = Math.max(answer, a);
        }
        for(int i = 0; i<arrayA.length; i++){
            if(arrayA[i] % b == 0){
                checkA = 0;
            }
        }
        if(checkA == 1){
            answer = Math.max(answer, b);
        }
        return answer;
    }
    private int Euclidean(int a, int b){
        if(b == 0) return a;
        return Euclidean(b, a % b);
    }
}