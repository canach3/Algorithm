import java.util.*;

class Solution {
    static Map<String, Node> map = new HashMap<>();
    static int size;
    static Node head;
    static Node tail;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;

        map = new HashMap<>();
        size = 0;
        int time = 0;

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

        for (String key : cities) {
            key = key.toLowerCase(); // 소문자 변환 (대소문자 구분 X)

            Node node = map.get(key);

            // 처음 등장하는 노드인 경우
            if (node == null) {
                // map에 등록
                node = new Node();
                map.put(key, node);

                // 캐시에 저장
                if (size < cacheSize) {
                    addLast(node); // 맨 뒤에 삽입
                    size++;
                } else {
                    addLast(node); // 맨 뒤에 삽입
                    removeFirst(); // 맨 앞 노드 삭제
                }

                time += 5;
            }

            // 등장한 적 있는 노드인 경우
            else {
                // 캐시에 저장되어있는 경우
                if (node.prev != null && node.next != null) {
                    // 위치를 tail로 옮기기
                    remove(node);
                    addLast(node);

                    time += 1;
                }

                // 캐시에 저장되어있지 않은 경우
                else {
                    removeFirst();
                    addLast(node);

                    time += 5;
                }
            }
        }

        return time;
    }

    static void addLast(Node curr) {
        Node prev = tail.prev;

        prev.next = curr;
        curr.prev = prev;
        curr.next = tail;
        tail.prev = curr;
    }

    static void removeFirst() {
        Node curr = head.next;

        head.next = curr.next;
        curr.next.prev = head;

        curr.prev = null;
        curr.next = null;
    }

    static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    static class Node {
        Node prev;
        Node next;
    }
}