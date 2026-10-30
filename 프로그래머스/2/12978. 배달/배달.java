import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] adjMatrix = new int[N + 1][N + 1];
        
        for (int[] edge : road) {
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];
            
            if (adjMatrix[v1][v2] == 0) {
                adjMatrix[v1][v2] = cost;
                adjMatrix[v2][v1] = cost;
            } else {
               adjMatrix[v1][v2] = Math.min(adjMatrix[v1][v2], cost);
               adjMatrix[v2][v1] = Math.min(adjMatrix[v2][v1], cost);
            }
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
            
            for (int nextV = 1; nextV <= N; nextV++) {
                if (adjMatrix[currV][nextV] == 0) continue;
                
                int nextC = currC + adjMatrix[currV][nextV];
                
                if (nextC < dist[nextV]) {
                    dist[nextV] = nextC;
                    pq.add(new int[] {nextV, nextC});
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