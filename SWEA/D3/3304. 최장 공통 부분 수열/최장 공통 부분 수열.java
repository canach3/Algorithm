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

            char[] arr1 = st.nextToken().toCharArray();
            char[] arr2 = st.nextToken().toCharArray();

            int[][] dp = new int[arr1.length + 1][arr2.length + 1];

            for (int i = 1; i <= arr1.length; i++) {
                for (int j = 1; j <= arr2.length; j++) {
                    if (arr1[i - 1] == arr2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            sb.append(dp[arr1.length][arr2.length]).append("\n");
        }

        System.out.print(sb);
    }
}