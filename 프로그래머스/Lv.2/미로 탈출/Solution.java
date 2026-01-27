import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();

        int[] start = null, lever = null, exit = null;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    start = new int[]{i, j, 0};
                } else if (c == 'L') {
                    lever = new int[]{i, j, 0};
                } else if (c == 'E') {
                    exit = new int[]{i, j, 0};
                }
            }
        }

        int distToLever = bfs(maps, start, lever);
        if (distToLever == -1) return -1;

        int distToExit = bfs(maps, lever, exit);
        if (distToExit == -1) return -1;


        return distToLever + distToExit;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        int rows = maps.length;
        int cols = maps[0].length();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moving = current[2];

            if (current[0] == target[0] && current[1] == target[1]) {
                return moving;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx >= 0) && (nx < rows) && (ny >= 0) && (ny < cols)
                        && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, moving + 1});
                }
            }
        }
        return -1;
    }
}