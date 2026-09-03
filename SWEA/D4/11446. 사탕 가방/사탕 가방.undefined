import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine());
    	for (int testCase = 1; testCase <= T; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			
			long[] candies = new long[N];
			long max = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				candies[i] = Long.parseLong(st.nextToken());
				max = Math.max(max,  candies[i]);
			}
			
			long left = 1;
			long right = max;
			long result = 0;
			
			while (left <= right) {
				long bags = left + (right - left) / 2;
				long cnt = 0;
				
				for (long candy : candies) {
					cnt += candy / bags;
				}
				
				if (cnt < M) {
					right = bags - 1;
				} else {
					result = bags;
					left = bags + 1;
				}
			}
			
    		sb.append(result).append("\n");
		}
    	
    	System.out.print(sb);
    }
}