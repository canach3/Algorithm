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

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            maxHeap.add(A);

            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                // minHeap 에 먼저 넣고 하나 빼서 maxHeap 에 넣기
                minHeap.add(X);
                maxHeap.add(Y);

                if (maxHeap.peek() > minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(tmp);
                }

                sum = (sum + (maxHeap.peek() % 20171109)) % 20171109;
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}