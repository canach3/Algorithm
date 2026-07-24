import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        String key = sc.next();

        boolean[] arr = new boolean[26];
        arr[9] = true;

        char[][] map = new char[5][5];
        int[][] idxMap = new int[26][2];

        // 키를 5*5 표에 저장
        int seq = 0;
        for (int i = 0; i < key.length(); i++) {
            int y = seq / 5;
            int x = seq % 5;

            char c = key.charAt(i);

            // 반복되는 알파벳 넘어가기
            if (arr[c - 'A']) continue;
            arr[c - 'A'] = true;

            map[y][x] = c;
            idxMap[c - 'A'][0] = y;
            idxMap[c - 'A'][1] = x;
            seq++;
        }

        // 나머지 알파벳 채우기
        while (seq < 25) {
            for (int i = 0; i < 26; i++) {
                if (seq >= 25) break;

                char c = (char) ('A' + i);

                if (arr[c - 'A']) continue;

                int y = seq / 5;
                int x = seq % 5;
                arr[c - 'A'] = true;
                
                map[y][x] = c;
                idxMap[c - 'A'][0] = y;
                idxMap[c - 'A'][1] = x;

                seq++;
            }
        }

        // 메시지 두 글자씩 나누기
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while(idx < msg.length() - 1) {
            char curr = msg.charAt(idx);
            char next = msg.charAt(idx + 1);

            if (curr == next) {
                sb.append(curr);
                if (next == 'X') sb.append('Q');
                else sb.append('X');
                idx += 1;
            } else {
                sb.append(curr);
                sb.append(next);
                idx += 2;
            }
        }

        if (idx == msg.length() - 1) {
            sb.append(msg.charAt(idx)).append('X');
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 2) {
            int y1 = idxMap[sb.charAt(i) - 'A'][0];
            int y2 = idxMap[sb.charAt(i + 1) - 'A'][0];
            int x1 = idxMap[sb.charAt(i) - 'A'][1];
            int x2 = idxMap[sb.charAt(i + 1) - 'A'][1];

            // 같은 행인 경우
            if (y1 == y2) {
                result.append(map[y1][(x1 + 1) % 5]);
                result.append(map[y1][(x2 + 1) % 5]);
            }

            // 같은 열인 경우
            else if (x1 == x2) {
                result.append(map[(y1 + 1) % 5][x1]);
                result.append(map[(y2 + 1) % 5][x1]);
            }

            // 이외의 경우
            else {
                result.append(map[y1][x2]);
                result.append(map[y2][x1]);
            }
        }

        System.out.println(result);
    }
}