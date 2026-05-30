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
            int K = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][K + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    // 해당 물건 부피가 더 크다면 (담을 수 없는 경우)
                    if (arr[i][0] > j) {
                        dp[i][j] = dp[i - 1][j];
                    }

                    // 해당 물건을 담을 수 있는 경우
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
                    }
                }
            }

            sb.append(dp[N][K]).append("\n");
        }

        System.out.print(sb);
    }
}