import java.util.Arrays;

class SolutionV2 {  // 풀다가 너무 복잡해서 포기.. 그래도 나중에 다시 시도해보자 -> 단순하게 2개로 나눠서 size=2 or 1에 대해서 나눠서 처리하고 전체 맵에서 값 카운트
    public int solution(String[] storage, String[] requests) {
        // 1. 범위(지도) 설정
        int totalAdditions = 0;
        int n = storage.length;
        int m = storage[0].length();
        String[][] map = new String[n + 2][m + 2];
        boolean[][] visited = new boolean[n + 2][m + 2];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        // 맵에 값 채우기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i+1][j+1] = String.valueOf(storage[i].charAt(j));
            }
        }

        // visited에도 패딩 영역 true 바꾸기
        for (int i = 0; i < n+2; i++) {
            visited[i][0] = true;
            visited[i][m+1] = true;
            for (int j = 0; j < m+2; j++) {
                if (i == 0) {
                    visited[i][j] = true;
                }
                if (i == n + 1) {
                    visited[i][j] = true;
                }
            }
        }

        for (int x = 0; x < requests.length; x++) {
            int size = requests[x].length();
            String outStr;
            if (size > 1) {
                outStr = String.valueOf(requests[x].charAt(0));
            } else {
                outStr = requests[x];
            }

            for (int i = 1; i < n + 2; i++) {
                for (int j = 1; j < m + 2; j++) {
                    if (!map[i][j].equals(outStr)) {
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        int nx = dx[k];
                        int ny = dy[k];
                        if (visited[i + nx][j + ny]) {
                            visited[i][j] = true;
                            break;
                        }
                    }
                    if (size == 1) {
                    } else {

                    }
                }
            }
        }


        return totalAdditions;
    }
}
