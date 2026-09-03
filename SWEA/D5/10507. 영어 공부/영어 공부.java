	import java.io.*;
	import java.util.*;
	
	class Solution {
	    public static void main(String[] args) throws Exception {
			// System.setIn(new FileInputStream("res/input.txt"));
			
	    	StringBuilder sb = new StringBuilder();
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	
	    	int T = Integer.parseInt(br.readLine());
	    	for (int testCase = 1; testCase <= T; testCase++) {
				sb.append("#").append(testCase).append(" ");
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				boolean[] arr = new boolean[1000001];
				int last = 0;
				
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					int idx = Integer.parseInt(st.nextToken()); 
					arr[idx] = true;
					
					if (i == N - 1) last = idx;
				}
				
				int left = 0;
				int right = -1;
				int use = 0;
				int max = 0;
				int curr = 0;
				
				while (right < last) {
					if (arr[right + 1]) {
						right++;
						curr++;
					} else {
						if (use < P) {
							right++;
							curr++;
							use++;
						} else {
							if (!arr[left]) use--;
							
							left++;
							curr--;
						}
					}
					
					max = Math.max(max, curr);
				}
				
				max = Math.max(max, curr + (P - use));
				
	    		sb.append(max).append("\n");
			}
	    	
	    	System.out.print(sb);
	    }
	}