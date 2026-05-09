import java.util.*;

class Solution {
    static Node curr;               // 현재 선택된 노드
    static Node[] nodes;            // 노드들을 담은 배열
    static Stack<Node> removed;     // 삭제된 행을 담은 스택

    public String solution(int n, int k, String[] cmds) {
        // n : 행 개수 (5 <= 5 <= 1,000,000)
        // k : 처음에 선택된 행 위치
        // cmd : 명령어 배열 (1 <= 원소 개수 <= 200,000)

        // 자료구조 초기화, 초기 표 생성, 각 노드 연결
        removed = new Stack<>();

        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        nodes[0].next = nodes[1];
        nodes[n - 1].prev = nodes[n - 2];

        for (int i = 1; i < n - 1; i++) {
            nodes[i].prev = nodes[i - 1];
            nodes[i].next = nodes[i + 1];
        }

        // 초기 선택된 행
        curr = nodes[k];

        for (String cmd : cmds) {
            switch (cmd.charAt(0)) {
                case 'U':
                    up(Integer.parseInt(cmd.split(" ")[1]));
                    break;
                case 'D':
                    down(Integer.parseInt(cmd.split(" ")[1]));
                    break;
                case 'C':
                    remove();
                    break;
                case 'Z':
                    restore();
                    break;
            }
        }

        // 최종 체크
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!nodes[i].isRemoved) sb.append("O");
            else sb.append("X");
        }

        return sb.toString();
    }

    static void up(int offset) {
        for (int i = 0; i < offset; i++) {
            curr = curr.prev;
        }
    }

    static void down(int offset) {
        for (int i = 0; i < offset; i++) {
            curr = curr.next;
        }
    }

    static void remove() {
        // 삭제 처리, 큐에 담기
        curr.isRemoved = true;
        removed.push(curr);

        /* 연결 끊기 */

        // 이전 행만 없는 경우
        if (curr.prev == null) {
            curr.next.prev = null;
        }

        // 다음 행만 없는 경우
        else if (curr.next == null) {
            curr.prev.next = null;
        }

        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        // 현재 선택된 행을 아래행으로 조정(없으면 윗 행)
        if (curr.next == null) curr = curr.prev;
        else curr = curr.next;
    }

    static void restore() {
        // 스택에서 꺼내고 복구 처리
        Node node = removed.pop();
        node.isRemoved = false;

        /* 연결하기 */

        // 첫 번째 행인 경우
        if (node.prev == null) {
            node.next.prev = node;
        }

        // 마지막 행인 경우
        else if (node.next == null) {
            node.prev.next = node;
        }

        else {
            node.prev.next = node;
            node.next.prev = node;
        }
    }

    static class Node {
        Node prev;
        Node next;
        boolean isRemoved;
    }
}