class Solution {
    public int[] solution(String s) {
        int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = -1;
        }
        
        int[] result = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            
            if (idx[c] == -1) {
                result[i] = -1;
            } else {
                result[i] = i - idx[c];
            }
            
            idx[c] = i;
        }

        return result;
    }
}