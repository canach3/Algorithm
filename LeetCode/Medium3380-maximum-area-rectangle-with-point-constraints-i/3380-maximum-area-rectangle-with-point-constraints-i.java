import java.util.*;

class Solution {
    static int N;
    static int[][] allPoints;
    static int max;

    public int maxRectangleArea(int[][] points) {
        N = points.length;
        allPoints = points;
        max = 0;

        DFS(new int[4][2], 0,0);
        return max == 0 ? -1 : max;
    }

    static void DFS(int[][] selected, int idx, int cnt) {
        if (cnt == 4) {
            int[][] tmpSelected = new int[4][2];
            for (int i = 0; i < 4; i++) {
                tmpSelected[i] = Arrays.copyOf(selected[i], 2);
            }

            // x값 기준 정렬(동일한 경우 y값 기준)
            Arrays.sort(tmpSelected, (a, b) -> {
                if (Integer.compare(a[0], b[0]) == 0) {
                    return Integer.compare(a[1], b[1]);
                }

                return Integer.compare(a[0], b[0]);
            });

            // 직사각형 조건 체크
            if (!(tmpSelected[0][0] == tmpSelected[1][0] && // x값 동일
                  tmpSelected[2][0] == tmpSelected[3][0] &&
                  tmpSelected[0][1] == tmpSelected[2][1] && // y값 동일
                  tmpSelected[1][1] == tmpSelected[3][1])) {
                return;
            }

            // 직사각형 내에 포인트 존재여부 확인
            for (int i = 0; i < N; i++) {
                int[] point = allPoints[i];

                // 이미 선택된 포인트인 경우 제외
                boolean isSelected = false;
                for (int j = 0; j < 4; j++) {
                    if (point[0] == tmpSelected[j][0] && point[1] == tmpSelected[j][1]) {
                        isSelected = true;
                        break;
                    }
                }

                if (isSelected) continue;

                if (point[0] >= tmpSelected[0][0] &&   // x값이 사각형 내에 존재하는지 체크
                    point[0] <= tmpSelected[2][0] &&
                    point[1] >= tmpSelected[0][1] &&   // y값이 사각형 내에 존재하는지 체크
                    point[1] <= tmpSelected[1][1]) {
                    return;
                }
            }

            // 사각형 넓이 계산 후 max 값 업데이트
            int area = (tmpSelected[1][1] - tmpSelected[0][1]) * (tmpSelected[2][0] - tmpSelected[0][0]);
            max = Math.max(max, area);

            return;
        }

        if (idx == N) {
            return;
        }

        DFS(selected, idx + 1, cnt);

        selected[cnt][0] = allPoints[idx][0];
        selected[cnt][1] = allPoints[idx][1];
        DFS(selected, idx + 1, cnt + 1);
    }
}