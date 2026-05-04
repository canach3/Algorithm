import java.io.*;
import java.util.*;

class Solution {
    static int[][] tree;
    static int cnt;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            tree = new int[V + 1][3];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                tree[child][0] = parent;

                if (tree[parent][1] == 0) tree[parent][1] = child;
                else tree[parent][2] = child;
            }

            List<Integer> v1Ancestors = new ArrayList<>();
            List<Integer> v2Ancestors = new ArrayList<>();
            
            // v1, v2 각각 조상찾기
            int curr = v1;
            while (curr != 0) {
                v1Ancestors.add(curr);
                curr = tree[curr][0];
            }
            Collections.reverse(v1Ancestors);

            curr = v2;
            while (curr != 0) {
                v2Ancestors.add(curr);
                curr = tree[curr][0];
            }
            Collections.reverse(v2Ancestors);

            // LCA 찾기
            int LCA = 1;
            int idx = 0;
            while (idx < v1Ancestors.size() && idx < v2Ancestors.size() &&
                    v1Ancestors.get(idx).equals(v2Ancestors.get(idx))) {
                LCA = v1Ancestors.get(idx++);
            }

            // 서브트리 크기 구하기
            cnt = 0;
            DFS(LCA);

            sb.append(LCA).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }

    static void DFS(int curr) {
        cnt++;

        for (int i = 1; i <= 2; i++) {
            int child = tree[curr][i];
            if (child != 0) DFS(child);
        }
    }
}