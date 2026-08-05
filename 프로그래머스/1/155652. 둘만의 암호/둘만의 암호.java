import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] isSkip = new boolean[26];
        for (char c : skip.toCharArray()) {
            isSkip[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {

            // index 만큼 뒤로가기
            int cnt = 0;
            while (cnt < index) {
                c++; 
                
                if (c > 'z') {
                    c = 'a';
                }
                
                if (!isSkip[c - 'a']) {
                    cnt++;
                }
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}