import java.io.*;
import java.util.*;

class Solution {
    static int[] heap;
    static int heapSize;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int testCase = 1; testCase <= T; testCase++) {
            sb.append("#").append(testCase).append(" ");

            int N = Integer.parseInt(br.readLine().trim());
            heap = new int[N + 1];
            heapSize = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int command = Integer.parseInt(st.nextToken());

                if (command == 1) insert(Integer.parseInt(st.nextToken()));
                else sb.append(delete()).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void insert(int item) {
        heap[++heapSize] = item;
        int child = heapSize;
        int parent = child / 2;

        while (parent > 0 && heap[child] > heap[parent]) {
            int tmp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = tmp;

            child = parent;
            parent = child / 2;
        }
    }

    static int delete() {
        if (heapSize == 0) return -1;

        int item = heap[1];
        heap[1] = heap[heapSize--];

        int parent = 1;
        int child = parent * 2;
        if (child + 1 <= heapSize && heap[child + 1] > heap[child]) child++;

        while (child <= heapSize && heap[child] > heap[parent]) {
            int tmp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = tmp;

            parent = child;
            child = parent * 2;
            if (child + 1 <= heapSize && heap[child + 1] > heap[child]) child++;
        }

        return item;
    }
}