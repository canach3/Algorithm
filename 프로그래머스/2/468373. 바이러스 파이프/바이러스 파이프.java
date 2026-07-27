import java.util.*;

class Solution {
    static int n;
    static int k;
    static int start;
    
    static List<List<int[]>> adjList;
    
    static int cnt;
    static int max;
    
    static boolean[] visited;
    
    public int solution(int mn, int infection, int[][] edges, int mk) {
        n = mn;
        k = mk;
        start = infection;
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            int type = edges[i][2];
            
            adjList.get(v1).add(new int[] {v2, type});
            adjList.get(v2).add(new int[] {v1, type});
        }
        
        max = 0;
        
        // 모든 경우의 수 구하기(파이프라인)
        perm(0, new int[k + 1]);
        
        return max;
    }
    
    static void perm(int idx, int[] caseArr) {
        // 종료조건
        if (idx == k) {
            System.out.println("이번 순서 : " + Arrays.toString(caseArr));
            
            visited = new boolean[n + 1];
            visited[start] = true;
            
            cnt = 1;
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) DFS(j, caseArr[i]);
                }
            }
            
            max = Math.max(max, cnt);
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            caseArr[idx + 1] = i;
            perm(idx + 1, caseArr);
        }
    }
    
    // 감염된 배양체 수 구하기
    static void DFS(int curr, int type) {
        if (!visited[curr]) cnt++;
        visited[curr] = true;
        
        for (int[] next : adjList.get(curr)) {
            if (!visited[next[0]] && next[1] == type) {
                DFS(next[0], type);
            }
        }
        
        max = Math.max(max, cnt);
    }
}