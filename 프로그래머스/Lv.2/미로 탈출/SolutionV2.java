import java.util.LinkedList;
import java.util.Queue;

class SolutionV2 {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        int[] leverPoint = new int[3];

        boolean found = false;
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    found = true;
                    break;
                } /*else if (maps[i].charAt(j) == 'L') {
                    leverPoint[0] = i;
                    leverPoint[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    endPoint[0] = i;
                    endPoint[1] = j;
                }*/
            }
            if (found) break;
        }

        // S -> L 최단 거리 구하기
        boolean foundLever = false;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moving = current[2];

            if (maps[x].charAt(y) == 'L') {
                leverPoint[0] = x;
                leverPoint[1] = y;
                leverPoint[2] = moving;
                foundLever = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < m) && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, moving + 1});
                }
            }
        }
        if (!foundLever) {
            return -1;
        }
        // L -> E 최단 거리 구하기
        queue = new LinkedList<>();     // break로 나오냐고 큐에 데이터가 있을 수 있음.. => 초기화
        queue.offer(leverPoint);
        visited = new boolean[n][m];
        visited[leverPoint[0]][leverPoint[1]] = true;   // 초기위치 방문처리
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moving = current[2];

            if (maps[x].charAt(y) == 'E') {
                return moving;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx >= 0) && (nx < n) && (ny >= 0) && (ny < m) && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, moving + 1});
                }
            }
        }
        return -1;
    }
}