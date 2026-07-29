import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int prev = 0;
        int hp = health;
        
        for (int[] attack : attacks) {
            int curr = attack[0];
            int damage = attack[1];
            
            int time = curr - 1 - prev;
            int q = time / bandage[0];
            int plus = time * bandage[1] + q * bandage[2];
            
            hp = Math.min(health, hp + plus);
            if ((hp -= damage) <= 0) return -1;
            
            prev = curr;
            
            System.out.println("현재 hp : " + hp);
        }
        
        return hp;
    }
}