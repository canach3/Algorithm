import java.util.*;

class Solution {
    public int[] solution(String todayStr, String[] terms, String[] privacies) {
        int today = Integer.parseInt(todayStr.substring(0, 4)) * 336 + 
                    Integer.parseInt(todayStr.substring(5, 7)) * 28 +
                    Integer.parseInt(todayStr.substring(8, 10)); 
        
        int[] period = new int[26];
        for (String term : terms) {
            period[term.charAt(0) - 'A'] = Integer.parseInt(term.substring(2));
        }
        
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            
            int target = Integer.parseInt(privacy.substring(0, 4)) * 336 + 
                         Integer.parseInt(privacy.substring(5, 7)) * 28 +
                         Integer.parseInt(privacy.substring(8, 10)); 
            
            int plus = period[privacy.charAt(11) - 'A'];
            
            target += plus * 28;
            if (target <= today) tmpList.add(i + 1);
        }

        int[] result = new int[tmpList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tmpList.get(i);
        }
        
        return result;
    }
}