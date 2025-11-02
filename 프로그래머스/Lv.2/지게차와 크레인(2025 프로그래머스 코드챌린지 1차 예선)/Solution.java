import java.util.*;
/**
 * 물류창고 컨테이너 관리 솔루션
 *
 * 핵심 알고리즘:
 * 1. 지게차: BFS를 통해 외부에서 접근 가능한 컨테이너 찾기
 * 2. 크레인: 모든 해당 종류 컨테이너 제거
 *
 * 접근 가능한 컨테이너:
 * - 가장자리에 있는 컨테이너
 * - 빈 공간을 통해 외부와 연결된 컨테이너
 */
class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int n,m;

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();

        char[][] warehouse = new char[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                warehouse[i][j] = storage[i].charAt(j);
            }
        }

        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 1) {
                removeAccessible(warehouse, target);
            } else {
                removeAll(warehouse, target);
            }
        }
        return countContainers(warehouse);
    }

    private void removeAccessible(char[][] warehouse, char target) {
        boolean[][] isAccessible = findAccessible(warehouse);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] == target && isAccessible[i][j]) {
                    warehouse[i][j] = ' ';
                }
            }
        }
    }

    private boolean[][] findAccessible(char[][] warehouse) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        boolean[][] accessible = new boolean[n][m];

        // 가장자리만 처리
        for (int i = 0; i < n; i++) {   // initializeBoundary(warehouse, accessible, visited, queue);
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) { // isBoundary(int i, int j, int n, int m)
                    if (warehouse[i][j] == ' ') {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    } else {
                        accessible[i][j] = true;
                    }
                }
            }
        }
        // BFS로 가장자리부터 내부 접근 가능한 위치 찾기
        explorInterior(warehouse, accessible, visited, queue);

        return accessible;
    }

    private void explorInterior(char[][] warehouse, boolean[][] accessible, boolean[][] visited, Queue<int[]> queue) {

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 테두리 밖 영역
                if (visited[nx][ny]) continue;  // 위에서 체크한 영역 -> 이미 큐에 들어가있음
                if (warehouse[nx][ny] == ' ' && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else {
                    accessible[nx][ny] = true;
                }
            }
        }
    }

    private void removeAll(char[][] warehouse, char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] == target) {
                    warehouse[i][j] = ' ';
                }
            }
        }
    }

    private int countContainers(char[][] warehouse) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] != ' ') {
                    count++;
                }
            }
        }
        return count;
    }
}