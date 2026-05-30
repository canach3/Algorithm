import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            String curr = callings[i];
            int rank = map.get(curr);

            String prev = players[rank - 1];

            // 등수 바꾸기
            map.put(curr, rank - 1);
            players[rank - 1] = curr;

            map.put(prev, rank);
            players[rank] = prev;
        }

        return players;
    }
}