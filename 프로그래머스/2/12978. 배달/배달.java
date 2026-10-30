import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : road) {
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];
            
            adjList.get(v1).add(new int[] {v2, cost});
            adjList.get(v2).add(new int[] {v1, cost});
        }
        
        int[] dist = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {1, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currV = curr[0];
            int currC = curr[1];
            
            if (currC > dist[currV]) continue;
            
            for (int[] next : adjList.get(currV)) {
                int nextV = next[0];
                int nextC = next[1];
                
                int newCost = currC + nextC;
                
                if (newCost < dist[nextV]) {
                    dist[nextV] = newCost;
                    pq.add(new int[] {nextV, newCost});
                }
            }
        }
        
        int cnt = -1;
        for (int cost : dist) {
            if (cost <= K) cnt++;
        }
        
        return cnt;
    }
}