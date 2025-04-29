import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        int[][] map = new int[102][102];    // 지도 생성 (최대 50*2 = 100까지 가능)

        for (int[] rect : rectangle) {      // 직사각형 표시 (내부는 1, 테두리는 2)
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] == 0) {
                            map[i][j] = 2;
                        }
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>(); // 현재 좌표 -> 이동 가능 좌표 -> 스탭
        boolean[][] visited = new boolean[102][102];
        //int[] dx = {0, 0, -1, 1};
        //int[] dy = {1, -1, 0, 0};
        int[] dx = {-1, 0, 1, 0};   // 상, 우, 하, 좌 / 2차배열 map[x][y] 기준으로 보면 [-1][0] 은 위로 빠지는게 맞지만, (x,y) 좌표 기준으로 보면 왼쪽으로 -1 가는 걸로 볼 수 있다 => 기준이 중요
        int[] dy = {0, 1, 0, -1};   // (dx[i], dy[i])가 하나의 방향 벡터
        queue.offer(new int[]{characterX, characterY, 0}); // (현재 좌표, 스탭)
        visited[characterX][characterY] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];// 1
            int y = current[1];// 3
            int step = current[2];

            if (x == itemX && y == itemY) {
                return step / 2;    // 2배 확장했으니 결과는 절반으로
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (map[nx][ny] == 2 && !visited[nx][ny]) { // nx, ny 맵에 대한 크기 제한 하지 않았음..
                    queue.offer(new int[]{nx, ny, step + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }

}