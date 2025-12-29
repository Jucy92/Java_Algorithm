import java.util.*;

class Solution {
    static class Point{
        int row, col;
        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int solution(int[][] land) {

        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];

        int[] oilCount = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, visited, i, j, n, m, oilCount);
                }
            }
        }
        return Arrays.stream(oilCount).max().getAsInt();
    }

    private void bfs(int[][] land, boolean[][] visited, int startRow, int startCol, int n, int m, int[] oilCount) {
        Queue<Point> queue = new LinkedList<>();
        Set<Integer> columns = new HashSet<>();

        queue.offer(new Point(startRow, startCol));
        visited[startRow][startCol] = true;
        columns.add(startCol);

        int size = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.row;
                int ny = dy[i] + cur.col;

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
                    columns.add(ny);
                }
            }
        }

        for (Integer column : columns) {
            oilCount[column] += size;
        }
    }
}