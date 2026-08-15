import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input.txt"));
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");

			List<Integer> list = new ArrayList<>();

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				char command = st.nextToken().charAt(0);
				int x = 0;
				int y = 0;
				
				switch(command) {
					case 'I':
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						
						for (int j = 0; j < y; j++) {
							list.add(j + x, Integer.parseInt(st.nextToken()));
						}
						
						break;
					case 'D':
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						
						for (int j = 0; j < y; j++) {
							list.remove(x + y - j);
						}
						break;
					case 'A':
						y = Integer.parseInt(st.nextToken());
						
						for (int j = 0; j < y; j++) {
							list.add(Integer.parseInt(st.nextToken()));
						}
						break;
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}