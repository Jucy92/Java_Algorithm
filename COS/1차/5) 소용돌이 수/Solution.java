class Solution {

    public int solution(int n) {
        int[][] map = new int[n][n];
        int dir = 0;   // 0 = 우측 / 1 = 아래 / 2 = 좌측 / 3 = 위
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int sum = 0;

        for (int i = 1; i <= n * n; i++) {
            map[x][y] = i;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != 0) {
                dir = (dir+1)%4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }

        for (int i = 0; i < n; i++) {
            sum += map[i][i];
        }

        return sum;
    }
}