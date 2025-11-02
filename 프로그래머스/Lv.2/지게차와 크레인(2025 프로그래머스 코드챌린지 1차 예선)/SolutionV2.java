import java.util.Arrays;

class SolutionV2 {  // 풀다가 너무 복잡해서 포기.. 그래도 나중에 다시 시도해보자 -> 단순하게 2개로 나눠서 size=2 or 1에 대해서 나눠서 처리하고 전체 맵에서 값 카운트 -> 다 똑같음 이게 문제가 아니라 BB 접근을 하는 로직을 따로 두고 체크해야함
    int n, m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(String[] storage, String[] requests) {
        // 1. 범위(지도) 설정
        n = storage.length;
        m = storage[0].length();
        char[][] map = new char[n + 2][m + 2];

        // 맵에 값 채우기
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
                    map[i][j] = '.';
                } else {
                    map[i][j] = storage[i - 1].charAt(j - 1);
                }
            }
        }
        System.out.println("map = " + Arrays.deepToString(map));

        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() > 1) {
                removeAll(map, target);
            } else {
                removeAccessible(map, target);
            }
        }
        return countRemainingContainers(map);
    }

    private void removeAccessible(char[][] map, char target) {
        boolean[][] toRemove = new boolean[n + 2][m + 2];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == target && isAccessible(map, i, j)) {
                    toRemove[i][j] = true;
                }
            }
        }
        System.out.println("toRemove = " + Arrays.deepToString(toRemove));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (toRemove[i][j]) {
                    map[i][j] = '.';
                }
            }
        }
        System.out.println("map = " + Arrays.deepToString(map));

    }

    private boolean isAccessible(char[][] map, int i, int j) {
        System.out.println("map["+i+"]["+j+"] = " + map[i][j]);
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k]; // 2 -> 2+(-1) = 1 / 2+0=2 / 2+1=3 / 2+0=2
            int ny = j + dy[k]; // 3 -> 3+0    = 3 / 3+1=4 / 3+0=3 / 3-1=2
            System.out.println("map["+nx+"]["+ny+"] = " + map[nx][ny]);
            if (map[nx][ny] == '.') {
                return true;
            }
        }
        return false;
    }

    private void removeAll(char[][] map, char target) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == target) {
                    map[i][j] = '.';
                }
            }
        }
        System.out.println("removeAllMap = " + Arrays.deepToString(map));
    }

    private int countRemainingContainers(char[][] map) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }
}

