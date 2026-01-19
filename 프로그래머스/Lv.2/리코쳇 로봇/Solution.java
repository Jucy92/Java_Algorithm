import java.util.*;

class Solution {
    // 상, 하, 좌, 우 방향
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();

        // 시작 위치와 목표 위치 찾기
        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // BFS를 위한 큐와 방문 체크 배열
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{startX, startY, 0}); // {x, y, 이동횟수}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            // 목표 지점에 도달했는지 확인
            if (x == goalX && y == goalY) {
                return moves;
            }

            // 4방향으로 슬라이딩
            for (int dir = 0; dir < 4; dir++) {
                int nx = x;
                int ny = y;

                // 장애물이나 벽에 부딪힐 때까지 이동
                while (true) {
                    int nextX = nx + dx[dir];
                    int nextY = ny + dy[dir];

                    // 범위를 벗어나거나 장애물에 부딪히면 멈춤
                    if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols ||
                            board[nextX].charAt(nextY) == 'D') {
                        break;
                    }

                    nx = nextX;
                    ny = nextY;
                }

                // 이동한 위치가 원래 위치와 같거나 이미 방문했으면 스킵
                if ((nx == x && ny == y) || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, moves + 1});
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }
}