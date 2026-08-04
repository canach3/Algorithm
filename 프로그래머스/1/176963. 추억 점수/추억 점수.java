import java.util.*;

class Solution {
    public int[] solution(String[] names, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], yearning[i]);
        }
        
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            for (String name : photo[i]) {
                Integer score = map.get(name);
                
                if (score != null) {
                    result[i] += score;
                }
            }
        }
        
        return result;
        
    }
}