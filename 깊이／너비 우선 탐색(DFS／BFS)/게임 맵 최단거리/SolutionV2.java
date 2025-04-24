class SolutionV2 {
    private int minDistance = Integer.MAX_VALUE;
    private int n, m;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        dfs(maps, visited, 0, 0, 1);

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void dfs(int[][] maps, boolean[][] visited, int x, int y, int distance) {
        // 목적지 도착
        if (x == n - 1 && y == m - 1) {
            minDistance = Math.min(minDistance, distance);
            return;
        }

        visited[x][y] = true;

        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // 맵 범위 내이고, 이동 가능한 길이며, 아직 방문하지 않은 경우
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(maps, visited, nx, ny, distance + 1);
            }
        }

        visited[x][y] = false; // 백트래킹
    }
}