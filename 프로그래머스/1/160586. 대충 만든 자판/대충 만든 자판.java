import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alphabetIdx = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabetIdx[i] = 101;
        }
        
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char alphabet = key.charAt(i);
                alphabetIdx[alphabet - 'A'] = Math.min(alphabetIdx[alphabet - 'A'], i + 1);
            }
        }
        
        int[] result = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
                char alphabet = target.charAt(j);
                
                int idx = alphabetIdx[alphabet - 'A'];
                if (idx == 101) {
                    sum = -1; 
                    break;
                }
                
                sum += idx;
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}