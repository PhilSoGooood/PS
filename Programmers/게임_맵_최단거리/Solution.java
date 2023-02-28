package Programmers.게임_맵_최단거리;

import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Deque<int[]> dq = new ArrayDeque<>();
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        dist[0][0] = 1;
        dq.add(new int[] {0, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int curX = cur[0];
            int curY = cur[1];

            for (int k=0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                dist[nx][ny] = dist[curX][curY] + 1;
                dq.add(new int[]{nx, ny});
            }
        }
        if (dist[n-1][m-1] == 0) return -1;
        return dist[n-1][m-1];
    }
}
