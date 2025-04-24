import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) { // 효율 테스트 통과
        int n = maps.length;
        int m = maps[0].length;

        // 이동 방향 (상, 하, 좌, 우)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // x, y, distance
        maps[0][0] = 0; // 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 목적지 도착
            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // 맵 범위 내이고, 이동 가능한 길인 경우
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0; // 방문 처리
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }

        return -1; // 도착 불가능
    }

    /*
    public int solution(int[][] maps) { // 효율테스트 실패 -> boolean[][] visited = new boolean[n][m]; visited만 빼도 효율테스트 통과
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            visited[x][y] = true;
            if (x == n - 1 && y == m - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny, count+1});
                }

            }
        }
        return -1;
    }
    */
}