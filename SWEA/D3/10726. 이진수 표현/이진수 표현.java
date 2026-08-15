import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input.txt"));
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int target = (1 << N) - 1;
			
			if ((M & target) == target) {
				sb.append("ON");
			} else {
				sb.append("OFF");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}