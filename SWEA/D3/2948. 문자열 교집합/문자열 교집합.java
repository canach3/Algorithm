import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<String, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String key = st.nextToken();
                map.put(key, 1);
            }

            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                String key = st.nextToken();
                if (map.get(key) != null) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}