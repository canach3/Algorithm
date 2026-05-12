import java.io.*;
import java.util.*;

public class Solution {
    static int[] maxHeap;
    static int cnt;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("res/input.txt"));

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            maxHeap = new int[N + 1];
            cnt = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int command = Integer.parseInt(st.nextToken());
                if (command == 1) {
                    insert(Integer.parseInt(st.nextToken()));
                } else {
                    sb.append(remove()).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void insert(int value) {
        int idx = ++cnt;

        maxHeap[cnt] = value;

        while (idx / 2 > 0) {
            int child = maxHeap[idx];
            int parent = maxHeap[idx / 2];

            if (child <= parent) break;

            maxHeap[idx] = parent;
            maxHeap[idx / 2] = child;

            idx /= 2;
        }
    }

    static int remove() {
        if (cnt == 0) return -1;

        int result = maxHeap[1];
        maxHeap[1] = maxHeap[cnt];
        cnt--;

        int parentIdx = 1;
        while (parentIdx * 2 <= cnt) {
            int parent = maxHeap[parentIdx];

            int child = 0;
            int childIdx = 0;

            if (parentIdx * 2 == cnt || maxHeap[parentIdx * 2] >= maxHeap[parentIdx * 2 + 1]) {
                child = maxHeap[parentIdx * 2];
                childIdx = parentIdx * 2;
            } else {
                child = maxHeap[parentIdx * 2 + 1];
                childIdx = parentIdx * 2 + 1;
            }

            if (parent >= child) break;

            maxHeap[parentIdx] = child;
            maxHeap[childIdx] = parent;

            parentIdx = childIdx;
        }

        return result;
    }
}