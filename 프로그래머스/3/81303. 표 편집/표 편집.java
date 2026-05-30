import java.util.*;

class Solution {
    static Node curr;   // 현재 선택된 노드
    static Node head;   // 헤드 노드
    static Node tail;   // 테일 노드

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

        // head <-> 첫 행 연결
        head = new Node();
        head.next = nodes[0];
        nodes[0].prev = head;
        nodes[0].next = nodes[1];

        // 마지막 행 <-> tail 연결
        tail = new Node();
        tail.prev = nodes[n -1];
        nodes[n - 1].prev = nodes[n - 2];
        nodes[n - 1].next = tail;

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

        // 연결끊기
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        // 현재 선택된 행을 아래행으로 조정(마지막 행이면 윗 행 선택)
        if (curr.next == tail) curr = curr.prev;
        else curr = curr.next;
    }

    static void restore() {
        // 스택에서 꺼내고 복구 처리
        Node node = removed.pop();
        node.isRemoved = false;

        // 연결하기
        node.prev.next = node;
        node.next.prev = node;
    }

    static class Node {
        Node prev;
        Node next;
        boolean isRemoved;
    }
}