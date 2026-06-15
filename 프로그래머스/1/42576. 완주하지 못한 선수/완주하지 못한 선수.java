import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : completion) {
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name) + 1);
            }
        }
        
        for (String name : participant) {
            if (map.get(name) == null) {
                return name;
            } else {
                if (map.get(name) == 1) {
                    map.remove(name);
                } else {
                    map.put(name, map.get(name) - 1);
                }
            }
        }
        
        return "";
    }
}