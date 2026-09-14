import java.util.*;

class Solution {
    int shortestPath(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 0) {
                    dist[i][j] = -2;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m)
                            dist[ni][nj] = -2;
                    }
                }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1) {
                dist[i][0] = 1;            
                q.add(new int[]{i, 0});
            }
        }

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0], y = c[1];
            if (y == m - 1) return dist[x][y];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}