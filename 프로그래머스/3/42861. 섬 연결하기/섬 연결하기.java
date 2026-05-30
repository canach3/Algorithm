import java.util.*;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        return kruskal(n, costs);
    }

    static int kruskal(int n, int[][] costs) {
        int result = 0;
        int cnt = 0;

        for (int i = 0; i < costs.length; i++) {
            if (cnt == n - 1) break;

            int[] edge = costs[i];

            if (union(edge[0], edge[1])) {
                result += edge[2];
                cnt++;
            }
        }

        return result;
    }

    static boolean union(int v1, int v2) {
        int v1Root = find(v1);
        int v2Root = find(v2);

        if (v1Root == v2Root) return false;

        parent[v2Root] = v1Root;
        return true;
    }

    static int find(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }
}